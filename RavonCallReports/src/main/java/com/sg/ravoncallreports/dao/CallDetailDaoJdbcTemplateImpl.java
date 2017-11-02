/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.ravoncallreports.dao;

import com.sg.ravoncallreports.model.CallAnswerTimeReport;
import com.sg.ravoncallreports.model.CallDurationReport;
import com.sg.ravoncallreports.model.MonthMinutesReport;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jstuart15
 */
public class CallDetailDaoJdbcTemplateImpl implements CallDetailDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //PREPARED STATEMENTS
    private static final String SQL_SELECT_BILLABLE_MINS_BY_CUSTOMER
            = "select monthname(enddate) as `Month`, sum(billsec/60) as Minutes "
            + "from call_details "
            + "where company = ? "
            + "and enddate >= date_sub(now(), interval 6 month) "
            + "group by monthname(enddate) "
            + "order by FIELD(`Month`,'January','February','March','April', "
            + "'May', 'June', 'July', 'August', 'September','October', "
            + "'November','December') desc;";

    private static final String SQL_SELECT_AVG_TIME_TO_ANSWER_ALL_COMPANIES_30DAYS
            = "select date(enddate) as Date, "
            + "avg(duration - billsec) as `Time-to-Answer (s)` "
            + "from call_details "
            + "where enddate >= date_sub(now(), interval 30 day) "
            + "group by date(enddate) desc;";

    private static final String SQL_SELECT_CALL_DURATIONS_BY_COMPANY_BY_DATES
            = "select calldate as `Start Time`, ani as `ANI`, dnis as `DNIS`, duration as `Duration (s)`\n"
            + "from call_details "
            + "where company = ? and "
            + "calldate >= ifnull(?,curdate()) and "
            + "enddate <= ifnull(?, now()) and "
            + "type = 'OUTBOUND' and "
            + "substring(dnis,3,3) "
            + "in ('218','320','507','612','651','763','952') "
            + "order by calldate desc;";

    //METHODS
    @Override
    public List<MonthMinutesReport> getMonthlyBillableMinutesByCustomer(String company) {
        return jdbcTemplate.query(SQL_SELECT_BILLABLE_MINS_BY_CUSTOMER,
                new MonthlyBillableMinutesMapper(), company);
    }

    @Override
    public List<CallAnswerTimeReport> getAverageTimeToAnswerLast30() {
        return jdbcTemplate.query(
                SQL_SELECT_AVG_TIME_TO_ANSWER_ALL_COMPANIES_30DAYS,
                new CallAnswerTimeReportMapper());
    }

    @Override
    public List<CallDurationReport> getCompanyCalls(String company, String startDate, String endDate) {
        //format date/time
        return jdbcTemplate.query(SQL_SELECT_CALL_DURATIONS_BY_COMPANY_BY_DATES,
                new CallDurationReportMapper(), company, startDate, endDate);
    }

    //MAPPERS
    private static final class CallDurationReportMapper implements RowMapper<CallDurationReport> {

        @Override
        public CallDurationReport mapRow(ResultSet rs, int i) throws SQLException {
            CallDurationReport r = new CallDurationReport();
            r.setStartTime(rs.getString("Start Time"));
            r.setAni(rs.getString("ANI"));
            r.setDnis(rs.getString("DNIS"));
            r.setDuration(rs.getBigDecimal("Duration (s)")
                    .setScale(0, RoundingMode.HALF_UP));
            return r;
        }
    }

    private static final class MonthlyBillableMinutesMapper implements RowMapper<MonthMinutesReport> {

        @Override
        public MonthMinutesReport mapRow(ResultSet rs, int i) throws SQLException {
            MonthMinutesReport r = new MonthMinutesReport();
            r.setMonth(rs.getString("Month"));
            r.setMinutes(rs.getBigDecimal("Minutes")
                    .setScale(0, RoundingMode.HALF_UP));
            return r;
        }
    }

    private static final class CallAnswerTimeReportMapper implements RowMapper<CallAnswerTimeReport> {

        @Override
        public CallAnswerTimeReport mapRow(ResultSet rs, int i) throws SQLException {
            CallAnswerTimeReport r = new CallAnswerTimeReport();
            r.setDate(rs.getString("date"));
            r.setAnswerTime(rs.getBigDecimal("Time-to-Answer (s)")
                    .setScale(1, RoundingMode.HALF_UP));
            return r;
        }
    }
}

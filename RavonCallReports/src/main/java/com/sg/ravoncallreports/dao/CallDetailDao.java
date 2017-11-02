/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.ravoncallreports.dao;

import com.sg.ravoncallreports.model.CallAnswerTimeReport;
import com.sg.ravoncallreports.model.CallDurationReport;
import com.sg.ravoncallreports.model.MonthMinutesReport;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public interface CallDetailDao {

    public List<MonthMinutesReport> getMonthlyBillableMinutesByCustomer(String company);

    public List<CallAnswerTimeReport> getAverageTimeToAnswerLast30();

    public List<CallDurationReport> getCompanyCalls(String company,
            String startDate, String endDate);

}

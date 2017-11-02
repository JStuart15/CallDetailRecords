/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.ravoncallreports.controller;

import com.sg.ravoncallreports.dao.CallDetailDao;
import com.sg.ravoncallreports.model.CallAnswerTimeReport;
import com.sg.ravoncallreports.model.CallDurationReport;
import com.sg.ravoncallreports.model.MonthMinutesReport;
import com.sg.ravoncallreports.ui.View;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public class ReportController {

    private CallDetailDao cdDao;
    private View view;

    public ReportController(CallDetailDao cdDao, View view) {
        this.cdDao = cdDao;
        this.view = view;
    }

    public void run() {
        //REPORT - minutes by month by customer
        List<MonthMinutesReport> monthlyMinutes
                = cdDao.getMonthlyBillableMinutesByCustomer("OPTUM");
        view.displayMonthMinutesReport(monthlyMinutes);

        //REPORT - daily average time-to-answer for all companies, last 30 days
        List<CallAnswerTimeReport> answerTimeReport
                = cdDao.getAverageTimeToAnswerLast30();
        view.displayCallAnswerTimeReport(answerTimeReport);

        //REPORT - Call details for all outbound calls to MN for a company 
        //          and specific time range
        String company = "OPTUM";
        String startTime = "2017-01-01T00:00:00";
        String endTime = "2018-01-01T00:00:00";

        List<CallDurationReport> callDurationReport
                = cdDao.getCompanyCalls(company, startTime, endTime);
        view.displayCallDurationReport(callDurationReport);
    }
}

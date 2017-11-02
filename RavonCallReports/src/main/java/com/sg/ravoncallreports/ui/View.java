/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.ravoncallreports.ui;

import com.sg.ravoncallreports.model.CallAnswerTimeReport;
import com.sg.ravoncallreports.model.CallDurationReport;
import com.sg.ravoncallreports.model.MonthMinutesReport;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestWord;
import de.vandermeer.asciithemes.a7.A7_Grids;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public class View {

    public void displayMonthMinutesReport(List<MonthMinutesReport> report) {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("Month", "Minutes");
        at.addRule();
        for (MonthMinutesReport currentMonth : report) {
            at.addRow(currentMonth.getMonth(), currentMonth.getMinutes());
        }
        at.addRule();
        at.getContext().setGrid(A7_Grids.minusBarPlusEquals());
        at.getRenderer().setCWC(new CWC_LongestWord());
        System.out.println(at.render());
    }

    public void displayCallAnswerTimeReport(List<CallAnswerTimeReport> report) {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("Date", "Time-to-Answer(s)");
        at.addRule();
        for (CallAnswerTimeReport row : report) {
            at.addRow(row.getDate(), row.getAnswerTime());
        }
        at.addRule();
        at.getContext().setGrid(A7_Grids.minusBarPlusEquals());
        at.getRenderer().setCWC(new CWC_LongestWord());
        System.out.println(at.render());
    }

    public void displayCallDurationReport(List<CallDurationReport> callDurationReport) {
        AsciiTable at = new AsciiTable();
        at.getContext().setWidth(94);
        at.addRule();
        at.addRow("Start Time", "ANI", "DNIS", "Duration(s)");
        at.addRule();
        for (CallDurationReport row : callDurationReport) {
            at.addRow(row.getStartTime(), row.getAni(), row.getDnis(), row.getDuration());
        }
        at.addRule();
        at.getContext().setGrid(A7_Grids.minusBarPlusEquals());
        System.out.println(at.render());
    }
}

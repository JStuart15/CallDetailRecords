/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.ravoncallreports.model;

import java.math.BigDecimal;

/**
 *
 * @author jstuart15
 */
public class MonthMinutesReport {

    private String month;
    private BigDecimal minutes;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getMinutes() {
        return minutes;
    }

    public void setMinutes(BigDecimal minutes) {
        this.minutes = minutes;
    }
}

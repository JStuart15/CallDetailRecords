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
public class CallAnswerTimeReport {

    private String date;
    private BigDecimal answerTime;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(BigDecimal answerTime) {
        this.answerTime = answerTime;
    }
}

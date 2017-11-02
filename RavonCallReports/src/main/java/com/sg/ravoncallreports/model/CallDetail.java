/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.ravoncallreports.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author jstuart15
 */
public class CallDetail {

    private int id;
    private String type;
    private String company;
    private String dnis;
    private String ani;
    private LocalDateTime calldate;
    private LocalDateTime enddate;
    private int duration;
    private int billsec;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDnis() {
        return dnis;
    }

    public void setDnis(String dnis) {
        this.dnis = dnis;
    }

    public String getAni() {
        return ani;
    }

    public void setAni(String ani) {
        this.ani = ani;
    }

    public LocalDateTime getCalldate() {
        return calldate;
    }

    public void setCalldate(LocalDateTime calldate) {
        this.calldate = calldate;
    }

    public LocalDateTime getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDateTime enddate) {
        this.enddate = enddate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getBillsec() {
        return billsec;
    }

    public void setBillsec(int billsec) {
        this.billsec = billsec;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.type);
        hash = 13 * hash + Objects.hashCode(this.company);
        hash = 13 * hash + Objects.hashCode(this.dnis);
        hash = 13 * hash + Objects.hashCode(this.ani);
        hash = 13 * hash + Objects.hashCode(this.calldate);
        hash = 13 * hash + Objects.hashCode(this.enddate);
        hash = 13 * hash + this.duration;
        hash = 13 * hash + this.billsec;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CallDetail other = (CallDetail) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.duration != other.duration) {
            return false;
        }
        if (this.billsec != other.billsec) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        if (!Objects.equals(this.dnis, other.dnis)) {
            return false;
        }
        if (!Objects.equals(this.ani, other.ani)) {
            return false;
        }
        if (!Objects.equals(this.calldate, other.calldate)) {
            return false;
        }
        if (!Objects.equals(this.enddate, other.enddate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CallDetail{" + "id=" + id + ", type=" + type + ", company=" + company + ", dnis=" + dnis + ", ani=" + ani + ", calldate=" + calldate + ", enddate=" + enddate + ", duration=" + duration + ", billsec=" + billsec + '}';
    }

}

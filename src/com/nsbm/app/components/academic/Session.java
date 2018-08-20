package com.nsbm.app.components.academic;

import java.sql.Date;
import java.sql.Time;

public abstract class Session {
    private Subject subject;
    private Time fromTime;
    private Time toTime;
    private boolean once;
    private Date fromDate;
    private Date toDate;

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setFromTime(Time fromTime) {
        this.fromTime = fromTime;
    }

    public void setToTime(Time toTime) {
        this.toTime = toTime;
    }

    public void setOnce(boolean once) {
        this.once = once;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Subject getSubject() {
        return subject;
    }

    public Time getFromTime() {
        return fromTime;
    }

    public Time getToTime() {
        return toTime;
    }

    public boolean isOnce() {
        return once;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }
}

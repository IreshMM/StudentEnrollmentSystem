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
}

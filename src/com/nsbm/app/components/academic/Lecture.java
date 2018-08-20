package com.nsbm.app.components.academic;

import com.nsbm.app.components.human.Lecturer;
import com.nsbm.app.database.Insertable;

import java.sql.Date;
import java.sql.Time;

public class Lecture extends Session implements Insertable {
    private int lectureID;
    private Lecturer lecturer;

    @Override
    public void insertToDatabase() {

    }

    @Override
    public Insertable retrieveFromDatabase() {
        return null;
    }

    @Override
    public void removeFromDatabase() {

    }
}

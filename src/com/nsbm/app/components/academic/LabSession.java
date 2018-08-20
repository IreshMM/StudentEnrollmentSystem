package com.nsbm.app.components.academic;

import com.nsbm.app.components.human.Instructor;
import com.nsbm.app.components.human.Student;
import com.nsbm.app.database.Insertable;

public class LabSession extends Session implements Insertable {
    private String labSessionID;
    private Laboratory laboratory;
    private Instructor[] instructors;
    private Student[] students;


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

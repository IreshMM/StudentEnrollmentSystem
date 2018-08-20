package com.nsbm.app.components.academic;

import com.nsbm.app.database.Insertable;

public class Subject implements Insertable {
    private String subjectCode;
    private String title;
    private double fee;
    private boolean optional;

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

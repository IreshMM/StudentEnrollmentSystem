package com.nsbm.app.components.academic;

import com.nsbm.app.database.Insertable;

public class Course implements Insertable {
    private String courseCode;
    private String title;

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

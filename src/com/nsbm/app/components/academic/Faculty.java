package com.nsbm.app.components.academic;

import com.nsbm.app.database.Insertable;

public class Faculty implements Insertable {
    private int facultyID;
    private String facultyName;

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

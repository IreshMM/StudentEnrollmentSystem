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

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public int getFacultyID() {
        return facultyID;
    }

    public String getFacultyName() {
        return facultyName;
    }
}

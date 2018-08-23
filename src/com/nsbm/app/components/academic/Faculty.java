package com.nsbm.app.components.academic;

import com.nsbm.app.database.Insertable;

import java.sql.SQLException;
import java.util.LinkedList;

public class Faculty implements Insertable {
    private int facultyID;
    private String facultyName;

    public Faculty(int facultyID, String facultyName) {
        this.facultyID = facultyID;
        this.facultyName = facultyName;
    }

    @Override
    public void insertToDatabase() {

    }

    @Override
    public void removeFromDatabase() {

    }

    @Override
    public void updateOnDatabase() {

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

    @Override
    public String toString() {
        return facultyName;
    }

    public static LinkedList<Faculty> getFaculties() throws SQLException {
        return databaseConnection.getFaculties();
    }
}

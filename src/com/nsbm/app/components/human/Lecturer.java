package com.nsbm.app.components.human;

import com.nsbm.app.database.DatabaseConnection;
import com.nsbm.app.database.Insertable;

import java.sql.SQLException;

public class Lecturer extends StaffMember {
    private int facultyID;

    @Override
    public void insertToDatabase() {

    }

    @Override
    public void removeFromDatabase() {

    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public int getFacultyID() {
        return facultyID;
    }

    public static int getCount() {
        try {
            return databaseConnection.getCount("Lecturer");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Lecturer retrieveFromDatabase(String key, int FLAG) throws SQLException {
        Lecturer lecturer = (Lecturer) databaseConnection.retrievePerson(key, DatabaseConnection.INSTRUCTOR, FLAG);
        return lecturer;
    }
}

package com.nsbm.app.components.human;

import com.nsbm.app.database.DatabaseConnection;

import java.sql.SQLException;

public class Instructor extends StaffMember {
    @Override
    public void insertToDatabase() {

    }

    @Override
    public void removeFromDatabase() {

    }

    public static int getCount() {
        try {
            databaseConnection.getCount("Instructor");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Instructor retrieveFromDatabase(String key, int FLAG) throws SQLException {
        Instructor instructor = (Instructor) databaseConnection.retrievePerson(key, DatabaseConnection.INSTRUCTOR, FLAG);
        return instructor;
    }
}

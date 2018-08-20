package com.nsbm.app.components.human;

import com.nsbm.app.database.Insertable;

public class Lecturer extends StaffMember {
    private int facultyID;

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

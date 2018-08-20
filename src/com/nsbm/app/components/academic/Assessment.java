package com.nsbm.app.components.academic;

import com.nsbm.app.database.Insertable;

public class Assessment implements Insertable {
    private int assessmentID;
    private String assementType;
    private String title;
    private char resutlGrade;

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

package com.nsbm.app.components.academic;

import com.nsbm.app.database.Insertable;

public class Laboratory implements Insertable {
    private String labID;
    private String description;

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

    public void setLabID(String labID) {
        this.labID = labID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabID() {
        return labID;
    }

    public String getDescription() {
        return description;
    }
}

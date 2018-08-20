package com.nsbm.app.database;

public interface Insertable {
    public void insertToDatabase();
    public Insertable retrieveFromDatabase();
    public void removeFromDatabase();
}

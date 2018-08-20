package com.nsbm.app.database;

import com.nsbm.main.Main;

public interface Insertable {
    DatabaseConnection databaseConnection = new DatabaseConnection(Main.databaseURL, Main.databaseUsername, Main.databasePassword);

    public void insertToDatabase();
    public Insertable retrieveFromDatabase();
    public void removeFromDatabase();
}

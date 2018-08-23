package com.nsbm.app.database;

import com.nsbm.main.Main;

import java.sql.SQLException;

public interface Insertable {
    DatabaseConnection databaseConnection = new DatabaseConnection(Main.databaseURL, Main.databaseUsername, Main.databasePassword);

    public void insertToDatabase() throws SQLException;
    public void removeFromDatabase();
    public void updateOnDatabase();
}

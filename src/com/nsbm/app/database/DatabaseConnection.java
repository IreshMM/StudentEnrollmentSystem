package com.nsbm.app.database;

import com.nsbm.app.components.human.Instructor;
import com.nsbm.app.components.human.Lecturer;
import com.nsbm.app.components.human.Student;

import java.sql.*;

public class DatabaseConnection {
    private static final int BYID = 1;
    private static final int BYNIC = 2;
    private static final int BYINDEXNO = 3;
    private static final int BYFACID = 4;

    private Connection con;

    public DatabaseConnection(String url, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection("jdbc:mysql://" + url +
                "/demo?autoReconnect=true&useSSL=true&verifyServerCertificate=false", user, password);
    }

    /* INSERTION FUNCTIONS */
    public void insertStudent(Student student) {

    }

    public void insertLecturer(Lecturer lecturer) {

    }

    public void insertInstructor(Instructor instructor) {

    }

    /* RETRIEVING FUNCTIONS */
    public Student getStudent(String key, int FLAG) {

        return null;
    }

    public Lecturer getLecturer(String key, int FLAG) {

        return null;
    }

    public Instructor getInstructor(String key, int FLAG) {

        return null;
    }
}

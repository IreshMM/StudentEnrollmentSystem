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

    public DatabaseConnection(String url, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://" + url +
                    "/demo?autoReconnect=true&useSSL=true&verifyServerCertificate=false", user, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /* INSERTION FUNCTIONS */
    public void insertStudent(Student student) {
        String query = "INSERT INTO Student (" +
                "NICNumber, " +
                "IndexNumber, " +
                "FirstName, " +
                "LastName, " +
                "DOB, " +
                "Address, " +
                "Phone, " +
                "Email, " +
                "Photo, " +
                "Signature, " +
                "CourseCode" +
                ") " +
                "VALUES (" +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, student.getNicNumber());
            statement.setInt(2, student.getIndexNumber());
            statement.setString(3, student.getFirstName());
            statement.setString(4, student.getLastName());
            statement.setDate(5, student.getDateOfBirth());
            statement.setString(6, student.getAddress());
            statement.setString(7, student.getPhone());
            statement.setString(8, student.getEmail());
            statement.setString(9, student.getPhoto());
            statement.setString(10, student.getSignature());
            statement.setString(11, student.getCourse().getCourseCode());

            statement.executeUpdate();


        } catch (SQLException e) {
            System.out.println("SQL Exception occurred!!! This exceptions needs to handled");
            e.printStackTrace();
        }
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

package com.nsbm.app.components.human;

import com.nsbm.app.components.academic.Course;
import com.nsbm.app.database.DatabaseConnection;

import java.sql.SQLException;

public abstract class Student extends Person {

    private int studentID;
    private int indexNumber;
    private Course course;
    private int registrationYear;

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setRegistrationYear(int registrationYear) {
        this.registrationYear = registrationYear;
    }

    public int getRegistrationYear() {
        return registrationYear;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public Course getCourse() {
        return course;
    }

    public static int getCount() {
        try {
            return databaseConnection.getCount("Student");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Student retrieveFromDatabase(String key, int FLAG) throws SQLException {
        return (Student) databaseConnection.retrievePerson(key, DatabaseConnection.STUDENT, DatabaseConnection.BYID);
    }
}

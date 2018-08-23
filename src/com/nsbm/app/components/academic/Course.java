package com.nsbm.app.components.academic;

import com.nsbm.app.database.Insertable;

import java.sql.SQLException;
import java.util.LinkedList;

public class Course implements Insertable {
    private String courseCode;
    private String title;
    private Faculty faculty;

    public Course() { }

    public Course(String courseCode, String title, Faculty faculty) {
        this.courseCode = courseCode;
        this.title = title;
        this.faculty = faculty;
    }

    @Override
    public void insertToDatabase() {

    }

    @Override
    public void removeFromDatabase() {

    }

    @Override
    public void updateOnDatabase() {

    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public static int getCount() {
        try {
            return databaseConnection.getCount("Course");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static LinkedList<Course> getCourses(boolean postgraduate) throws SQLException {
        return databaseConnection.getCourses(false);
    }

    @Override
    public String toString() {
        return title;
    }

}

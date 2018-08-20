package com.nsbm.app.components.academic;

import com.nsbm.app.database.Insertable;

public class Course implements Insertable {
    private String courseCode;
    private String title;

    public Course(String courseCode, String title) {
        this.courseCode = courseCode;
        this.title = title;
    }

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
}

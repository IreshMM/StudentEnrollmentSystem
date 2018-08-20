package com.nsbm.app.components.human;

import com.nsbm.app.components.academic.Course;

public abstract class Student extends Person {

    private String studentID;
    private int indexNumber;
    private Course course;

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getStudentID() {
        return studentID;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public Course getCourse() {
        return course;
    }
}

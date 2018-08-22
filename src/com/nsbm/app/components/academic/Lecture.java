package com.nsbm.app.components.academic;

import com.nsbm.app.components.human.Lecturer;
import com.nsbm.app.database.Insertable;

import java.sql.Date;
import java.sql.Time;

public class Lecture extends Session implements Insertable {
    private int lectureID;
    private Lecturer lecturer;

    @Override
    public void insertToDatabase() {

    }

    @Override
    public void removeFromDatabase() {

    }

    @Override
    public void updateOnDatabase() {

    }

    public void setLectureID(int lectureID) {
        this.lectureID = lectureID;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public int getLectureID() {
        return lectureID;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }
}

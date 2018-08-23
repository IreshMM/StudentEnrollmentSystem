package com.nsbm.app.components.academic;

import com.nsbm.app.database.Insertable;

public class Subject implements Insertable {
    private String subjectCode;
    private String title;
    private double fee;
    private boolean optional;
    private int semester;
    private int year;

    public Subject(String subjectCode, String title, double fee, boolean optional, int semester, int year) {
        this.subjectCode = subjectCode;
        this.title = title;
        this.fee = fee;
        this.optional = optional;
        this.semester = semester;
        this.year = year;

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

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }



    public String getSubjectCode() {
        return subjectCode;
    }

    public String getTitle() {
        return title;
    }

    public double getFee() {
        return fee;
    }

    public boolean isOptional() {
        return optional;
    }

    public int getSemester() {
        return semester;
    }


}

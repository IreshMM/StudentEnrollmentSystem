package com.nsbm.app.components.academic;

import com.nsbm.app.database.Insertable;

public class Subject implements Insertable {
    private String subjectCode;
    private String title;
    private double fee;
    private boolean optional;

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
}

package com.nsbm.app.components.academic;

import com.nsbm.app.database.Insertable;

public class Assessment implements Insertable {
    private int assessmentID;
    private String assementType;
    private String title;
    private char resultGrade;

    public Assessment(int assessmentID, String assementType, String title, char resultGrade) {
        this.assessmentID = assessmentID;
        this.assementType = assementType;
        this.title = title;
        this.resultGrade = resultGrade;
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

    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    public void setAssementType(String assementType) {
        this.assementType = assementType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setResultGrade(char resultGrade) {
        this.resultGrade = resultGrade;
    }

    public int getAssessmentID() {
        return assessmentID;
    }

    public String getAssementType() {
        return assementType;
    }

    public String getTitle() {
        return title;
    }

    public char getResultGrade() {
        return resultGrade;
    }
}

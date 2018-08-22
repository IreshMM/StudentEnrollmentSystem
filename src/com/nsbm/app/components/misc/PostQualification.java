package com.nsbm.app.components.misc;

import com.nsbm.app.database.Insertable;

import java.time.Year;

public class PostQualification implements Insertable {
    private String qualificationType;
    private String institute;
    private Year yearOfCompletion;

    @Override
    public void insertToDatabase() {

    }

    @Override
    public void removeFromDatabase() {

    }

    @Override
    public void updateOnDatabase() {

    }

    public void setQualificationType(String qualificationType) {
        this.qualificationType = qualificationType;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public void setYearOfCompletion(Year yearOfCompletion) {
        this.yearOfCompletion = yearOfCompletion;
    }

    public String getQualificationType() {
        return qualificationType;
    }

    public String getInstitute() {
        return institute;
    }

    public Year getYearOfCompletion() {
        return yearOfCompletion;
    }
}

package com.nsbm.app.components.academic;

import com.nsbm.app.components.human.Instructor;
import com.nsbm.app.components.human.Student;
import com.nsbm.app.database.Insertable;

public class LabSession extends Session implements Insertable {
    private String labSessionID;
    private Laboratory laboratory;
    private Instructor[] instructors;
    private Student[] students;


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

    public void setLabSessionID(String labSessionID) {
        this.labSessionID = labSessionID;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public void setInstructors(Instructor[] instructors) {
        this.instructors = instructors;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public String getLabSessionID() {
        return labSessionID;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public Instructor[] getInstructors() {
        return instructors;
    }

    public Student[] getStudents() {
        return students;
    }
}

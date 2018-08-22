package com.nsbm.app.components.academic;

import com.nsbm.app.components.human.Student;
import com.nsbm.app.components.misc.Invoice;
import com.nsbm.app.database.Insertable;

import java.util.LinkedList;

public class Enrollment implements Insertable {
    private Student student;
    private Subject subject;
    private LinkedList<Assessment> assessments;
    private char resultGrade;
    private Invoice invoice;

    @Override
    public void insertToDatabase() {

    }

    @Override
    public void removeFromDatabase() {

    }

    @Override
    public void updateOnDatabase() {

    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setAssessments(LinkedList<Assessment> assessments) {
        this.assessments = assessments;
    }

    public void setResultGrade(char resultGrade) {
        this.resultGrade = resultGrade;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public LinkedList<Assessment> getAssessments() {
        return assessments;
    }

    public char getResultGrade() {
        return resultGrade;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice() {
        return invoice;
    }
}

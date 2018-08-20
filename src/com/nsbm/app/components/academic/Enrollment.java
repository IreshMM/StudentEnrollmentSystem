package com.nsbm.app.components.academic;

import com.nsbm.app.components.human.Student;
import com.nsbm.app.components.misc.Invoice;
import com.nsbm.app.database.Insertable;

public class Enrollment implements Insertable {
    private Student student;
    private Subject subject;
    private Assessment[] assessments;
    private char resultGrade;
    private Invoice invoice;

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

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setAssessments(Assessment ...assessments) {
        this.assessments = assessments;
    }

    public void setResultGrade(char resultGrade) {
        this.resultGrade = resultGrade;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public Assessment[] getAssessments() {
        return assessments;
    }

    public char getResultGrade() {
        return resultGrade;
    }

    public Invoice getInvoice() {
        return invoice;
    }
}

package com.nsbm.app.components.misc;

import com.nsbm.app.components.academic.Enrollment;
import com.nsbm.app.components.human.Student;
import com.nsbm.app.database.Insertable;

public class Invoice implements Insertable {
    private Student student;
    private String invoiceID;
    private String description;
    private double amount;
    private Enrollment[] enrollments;

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

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setEnrollments(Enrollment ...enrollments) {
        this.enrollments = enrollments;
    }

    public Student getStudent() {
        return student;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public Enrollment[] getEnrollments() {
        return enrollments;
    }
}

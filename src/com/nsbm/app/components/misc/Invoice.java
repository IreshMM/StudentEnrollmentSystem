package com.nsbm.app.components.misc;

import com.nsbm.app.components.academic.Enrollment;
import com.nsbm.app.components.human.Student;
import com.nsbm.app.database.Insertable;

import java.sql.SQLException;

public class Invoice implements Insertable {
    private Student student;
    private int invoiceID;
    private String description;
    private double amount;
    private Enrollment[] enrollments;

    @Override
    public void insertToDatabase() {
        try {
            databaseConnection.insertInvoice(this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void setInvoiceID(int invoiceID) {
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

    public int getInvoiceID() {
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

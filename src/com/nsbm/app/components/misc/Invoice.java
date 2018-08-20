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
}

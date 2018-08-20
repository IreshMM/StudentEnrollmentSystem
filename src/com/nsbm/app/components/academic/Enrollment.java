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
}

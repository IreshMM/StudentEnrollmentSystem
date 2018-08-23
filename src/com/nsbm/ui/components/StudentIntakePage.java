package com.nsbm.ui.components;

import com.nsbm.app.components.human.Student;
import javafx.scene.layout.BorderPane;

public class StudentIntakePage extends BorderPane {
    private Student student;

    public StudentIntakePage() {
        this.setPrefWidth(1005);
        this.setPrefHeight(667);

        this.setCenter(new IntakePersonalDetailsPage(this));
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}

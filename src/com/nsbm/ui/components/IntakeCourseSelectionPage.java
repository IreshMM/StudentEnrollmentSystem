package com.nsbm.ui.components;

import com.nsbm.app.components.academic.Course;
import com.nsbm.ui.resources.Resource;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

public class IntakeCourseSelectionPage extends VBox {

    /* Reference to parent */
    private StudentIntakePage studentIntakePage;

    @FXML
    private ChoiceBox<Course> courseListDropDown;

    @FXML
    private Button nextButton;

    public IntakeCourseSelectionPage(StudentIntakePage studentIntakePage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Resource.fxml + "studentintakecourseselection.fxml"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch(IOException e) {
            e.printStackTrace();
        }

        this.studentIntakePage = studentIntakePage;
        initFields();
        init_Buttons();
    }

    public void init_Buttons() {
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                studentIntakePage.setCenter(new IntakeSubjectSelectionPage(studentIntakePage));
            }
        });
    }

    public void initFields() {
        try {
            LinkedList<Course> courses = Course.getCourses(false);

            courseListDropDown.setItems(FXCollections.observableArrayList(courses));

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}

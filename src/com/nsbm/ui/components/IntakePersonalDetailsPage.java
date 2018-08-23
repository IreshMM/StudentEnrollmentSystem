package com.nsbm.ui.components;

import com.nsbm.app.components.human.Student;
import com.nsbm.app.components.human.UndergraduateStudent;
import com.nsbm.ui.resources.Resource;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.Date;

public class IntakePersonalDetailsPage extends VBox {

    /* Reference to parent */
    private StudentIntakePage studentIntakePage;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField studentIDField;

    @FXML
    private TextField indexNoField;

    @FXML
    private TextField nicNoField;

    @FXML
    private TextArea addressField;

    @FXML
    private TextField emailField;

    @FXML
    private DatePicker dateOfBirthField;

    @FXML
    private Label ageLabel;

    @FXML
    private TextField phoneField;

    @FXML
    private ImageView studentImage;

    @FXML
    private Button uploadNewImageBtn;

    @FXML
    private ImageView stduentSignatureImage;

    @FXML
    private Button nextButton;

    public IntakePersonalDetailsPage(StudentIntakePage studentIntakePage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Resource.fxml + "studentintakepersonaldetails.fxml"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch(IOException e) {
            e.printStackTrace();
        }

        this.studentIntakePage = studentIntakePage;

        init_Buttons();
    }


    public void init_Buttons() {
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadFromFields();
                studentIntakePage.setCenter(new IntakeCourseSelectionPage(studentIntakePage));
            }
        });
    }

    public void loadFromFields() {
        UndergraduateStudent student = new UndergraduateStudent();

        student.setFirstName(firstNameField.getText());
        student.setLastName(lastNameField.getText());
        student.setIndexNumber(Integer.parseInt(indexNoField.getText()));
        student.setAddress(addressField.getText());
        student.setEmail(emailField.getText());
        student.setDateOfBirth(Date.valueOf(dateOfBirthField.getValue()));
        student.setPhoto(phoneField.getText());

        studentIntakePage.setStudent(student);
    }

}

package com.nsbm.ui.components;

import com.nsbm.app.components.academic.Course;
import com.nsbm.app.components.human.Student;
import com.nsbm.app.components.human.UndergraduateStudent;
import com.nsbm.app.database.Insertable;
import com.nsbm.ui.resources.Resource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.beans.EventHandler;
import java.io.IOException;
import java.sql.Date;

public class StudentManagementPage extends TabPane {

    @FXML
    private Tab personalDetailsTab;

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
    private Button personalDetailsResetBtn;

    @FXML
    private Button personalDetailsSaveChangesBtn;

    @FXML
    private Tab subjectSelectionTab;

    @FXML
    private Label numberOfSubjectsLabel;

    @FXML
    private Label yearLabel;

    @FXML
    private Label semesterLabel;

    @FXML
    private ComboBox<?> subject1DropDown;

    @FXML
    private Label subject1CreditsLabel;

    @FXML
    private ComboBox<?> subject2DropDown;

    @FXML
    private Label subject2CreditsLabel;

    @FXML
    private ComboBox<?> subject3DropDown;

    @FXML
    private Label subject3CreditsLabel;

    @FXML
    private ComboBox<?> subject4DropDown;

    @FXML
    private Label subject4CreditsLabel;

    @FXML
    private Label creditsCalculatedLabel;

    @FXML
    private Label requiredCreditsLabel;

    @FXML
    private Label daysUntilDeadlineLabel;

    @FXML
    private Button subjectSelectionResetBtn;

    @FXML
    private Button subjectSelectionSaveChangesBtn;

    public StudentManagementPage() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Resource.fxml + "managestudent.fxml"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        init_Buttons();
    }

    private void init_Buttons() {
        personalDetailsSaveChangesBtn.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Student student = new UndergraduateStudent();

                student.setNicNumber(nicNoField.getText());
                student.setIndexNumber(Integer.parseInt(indexNoField.getText()));
                student.setFirstName(firstNameField.getText());
                student.setLastName(lastNameField.getText());
                student.setDateOfBirth(Date.valueOf(dateOfBirthField.getValue()));
                student.setAddress(addressField.getText());
                student.setPhone(phoneField.getText());
                student.setEmail(emailField.getText());
                Course course = new Course();
                course.setCourseCode("SE01");
                student.setCourse(course);

                student.insertToDatabase();

                System.out.println("Here");
            }
        });
    }

    public void initFields(Student student) {
        firstNameField.setText(student.getFirstName());
        lastNameField.setText(student.getLastName());
        studentIDField.setText(String.valueOf(student.getStudentID()));
        indexNoField.setText(String.valueOf(student.getIndexNumber()));
        nicNoField.setText(student.getNicNumber());
        addressField.setText(student.getAddress());
        emailField.setText(student.getEmail());
        dateOfBirthField.setValue(student.getDateOfBirth().toLocalDate());
        phoneField.setText(student.getPhone());
    }

}

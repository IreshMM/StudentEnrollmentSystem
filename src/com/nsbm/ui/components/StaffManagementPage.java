package com.nsbm.ui.components;

import com.nsbm.app.components.human.StaffMember;
import com.nsbm.ui.resources.Resource;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class StaffManagementPage extends TabPane {

    @FXML
    private Tab personalDetailsTab;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField staffIDTextField;

    @FXML
    private ChoiceBox<?> designationDropDown;

    @FXML
    private TextField nicNoTextField;

    @FXML
    private TextArea addressTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private DatePicker dateOfBirthDateField;

    @FXML
    private Label ageLabel;

    @FXML
    private TextField phoneTextField;

    @FXML
    private ImageView lecturerImage;

    @FXML
    private Button uploadNewImageBtn;

    @FXML
    private ImageView signatureImage;

    @FXML
    private Button resetBtn;

    @FXML
    private Button saveChangesBtn;

    public StaffManagementPage() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Resource.fxml + "managestaff.fxml"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initField(StaffMember staffMember) {
        firstNameTextField.setText(staffMember.getFirstName());
        lastNameTextField.setText(staffMember.getLastName());
        staffIDTextField.setText(String.valueOf(staffMember.getStaffID()));
        nicNoTextField.setText(staffMember.getNicNumber());
        addressTextField.setText(staffMember.getAddress());
        emailTextField.setText(staffMember.getEmail());
        dateOfBirthDateField.setValue(staffMember.getDateOfBirth().toLocalDate());
        phoneTextField.setText(staffMember.getPhone());

    }

}

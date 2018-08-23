package com.nsbm.ui.components;

import com.nsbm.app.components.academic.Course;
import com.nsbm.app.components.academic.Faculty;
import com.nsbm.app.components.human.Instructor;
import com.nsbm.app.components.human.Lecturer;
import com.nsbm.app.components.human.Student;
import com.nsbm.app.database.DatabaseConnection;
import com.nsbm.main.Main;
import com.nsbm.ui.resources.Resource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.SQLException;

public class HomePage extends BorderPane {

    @FXML
    private Label numberOfRegisteredStd;

    @FXML
    private Label numberOfacademicStaff;

    @FXML
    private Label numberOfdegProg;

    @FXML
    private Button stdManagementSideBtn;

    @FXML
    private Button academicStaffSideBtn;

    @FXML
    private Button degreeProgramsSideBtn;

    @FXML
    private Button resourcesSideBtn;

    @FXML
    private Button billingSideBtn;

    @FXML
    private ChoiceBox<Object> selectFacultyDropDown;

    private Button studentIntakeBtn;

    public HomePage() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Resource.fxml + "home.fxml"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        init_Pages();
        init_Buttons();
        refreshLabels();
        initFields();

        this.setCenter(Main.selectStudentPage);

    }

    public void init_Buttons() {
        stdManagementSideBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.homePage.setCenter(Main.selectStudentPage);
            }
        });

        academicStaffSideBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.homePage.setCenter(Main.staffManagementPage);
            }
        });

        degreeProgramsSideBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.homePage.setCenter(Main.degreeManagementPage);
            }
        });

        resourcesSideBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.homePage.setCenter(Main.resourcesPage);
            }
        });

        billingSideBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.homePage.setCenter(Main.billingPage);
            }
        });

    }

    public void init_Pages() {
        Main.billingPage = new BillingPage();
        Main.degreeManagementChoicePage = new DegreeManagementChoicePage();
        Main.degreeManagementPage = new DegreeManagementPage();
        Main.homePage = this;
        Main.selectStudentPage = new ManagementSelectUserPage("Select a student to continue");
        Main.selectStaffMemberPage = new ManagementSelectUserPage("Select a staff member to continue");
        Main.resourcesPage = new ResourcesPage();
        Main.staffManagementPage = new StaffManagementPage();
        Main.studentManagementPage = new StudentManagementPage();

        Main.selectStudentPage.setContinueBtnEvent(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Student currentStudent = Student.retrieveFromDatabase(Main.selectStudentPage.getStudentID(),
                            DatabaseConnection.BYID);
                    Main.studentManagementPage.initFields(currentStudent);
                    Main.homePage.setCenter(Main.studentManagementPage);
                } catch (SQLException e) {
                    e.printStackTrace();
                    //Expression to show error box
                }
            }
        });

        Main.selectStaffMemberPage.setContinueBtnEvent(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    public void refreshLabels() {
        numberOfRegisteredStd.setText(String.valueOf(Student.getCount()));
        numberOfacademicStaff.setText(String.valueOf(Lecturer.getCount() + Instructor.getCount()));
        numberOfdegProg.setText(String.valueOf(Course.getCount()));
    }

    public void initFields() {

        ObservableList<Object> ob = FXCollections.observableArrayList(Main.faculties);
        ob.add(new Separator());
        ob.add("STUDENT INTAKE");
        selectFacultyDropDown.setItems(ob);
        selectFacultyDropDown.getSelectionModel().select(Main.currentFaculty);

    }
}

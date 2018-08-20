package com.nsbm.ui.components;

import com.nsbm.ui.resources.Resource;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class DegreeManagementPage extends TabPane {

    @FXML
    private Tab manageSubjectsTab;

    @FXML
    private ComboBox<?> selectSemesterDropDown;

    @FXML
    private VBox subjectsVBox;

    @FXML
    private Button subjectAddNewBtn;

    @FXML
    private Button subjectRemoveBtn;

    @FXML
    private TextField subjectNumOfLectures;

    @FXML
    private Button numOfLecturesUpdateBtn;

    @FXML
    private TextField subjectNumOfLabSessions;

    @FXML
    private Button numOfLabSessionsUpdateBtn;

    @FXML
    private TextField subjectNumberOfPracticals;

    @FXML
    private Button numOfPracticalsUpdateBtn;

    @FXML
    private TextField subjectNumberOfAssessments;

    @FXML
    private Button numOfAssessmentsUpdateBtn;

    @FXML
    private TextArea subjectDescriptionTextField;

    @FXML
    private Button subjectDescriptionUpdateBtn;

    @FXML
    private Button subjectDescriptionResetBtn;

    @FXML
    private Tab lecturesTab;

    @FXML
    private ComboBox<?> lecSelectSubjectDropDown;

    @FXML
    private VBox lectureSetsVbox;

    @FXML
    private Button lectureSetAddNewBtn;

    @FXML
    private Button lectureSetRemoveBtn;

    @FXML
    private TextField lecConductedByTextField;

    @FXML
    private TextField lecTimeSlotFrom;

    @FXML
    private TextField lecTimeSlotTo;

    @FXML
    private ChoiceBox<?> lecWeekdayDropDown;

    @FXML
    private TextField lecNumberOfSessions;

    @FXML
    private RadioButton lecOnceRadioBtn;

    @FXML
    private ToggleGroup lecfreq;

    @FXML
    private RadioButton lecWeeklyRadioBtn;

    @FXML
    private TextField lecVenue;

    @FXML
    private DatePicker lecFromDateField;

    @FXML
    private DatePicker lecToDateField;

    @FXML
    private DatePicker lecDateField;

    @FXML
    private Button lecInformationResetBtn;

    @FXML
    private Button lecInformationUpdateBtn;

    @FXML
    private Tab laboratoryTab;

    @FXML
    private ComboBox<?> labSelectSubjectDropDown;

    @FXML
    private VBox labSessionsVBox;

    @FXML
    private Button labSessionAddNewBtn;

    @FXML
    private Button labSessionRemoveBtn;

    @FXML
    private VBox labInstructorListVBox;

    @FXML
    private TextField labFromTimeSlot;

    @FXML
    private TextField labToTimeSlot;

    @FXML
    private ChoiceBox<?> labWeekdayDropDown;

    @FXML
    private TextField labNumOfSessions;

    @FXML
    private RadioButton labOnceRadioBtn;

    @FXML
    private ToggleGroup lecfreq1;

    @FXML
    private RadioButton labWeeklyRadioBtn;

    @FXML
    private TextField labVenue;

    @FXML
    private DatePicker labFromDateField;

    @FXML
    private DatePicker labToDateField;

    @FXML
    private DatePicker labDateField;

    @FXML
    private Button labAllocateStudentsBtn;

    @FXML
    private Button labInformationResetBtn;

    @FXML
    private Button labInformationUpdateBtn;

    public DegreeManagementPage() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Resource.fxml + "managedegree.fxml"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

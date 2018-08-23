package com.nsbm.ui.components;
import com.nsbm.ui.resources.Resource;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
        import javafx.scene.control.ComboBox;
        import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class IntakeSubjectSelectionPage extends VBox {

    /* Reference to parent */
    private StudentIntakePage studentIntakePage;

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
    private Button finishButton;

    public IntakeSubjectSelectionPage(StudentIntakePage studentIntakePage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Resource.fxml + "studentintakesubjectselection.fxml"));
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
        finishButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((Stage) studentIntakePage.getScene().getWindow()).close();
            }
        });
    }
}

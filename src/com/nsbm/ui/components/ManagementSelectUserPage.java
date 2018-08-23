package com.nsbm.ui.components;

import com.nsbm.ui.resources.Resource;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ManagementSelectUserPage extends VBox {
    @FXML
    private Label titleText;

    @FXML
    private TextField studentID;

    @FXML
    private Button continueBtn;

    public ManagementSelectUserPage(String title) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Resource.fxml + "managementstartpage.fxml"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch(IOException e) {
            e.printStackTrace();
        }

        titleText.setText(title);
    }

    public void setContinueBtnEvent(EventHandler<ActionEvent> event) {
        continueBtn.setOnAction(event);
    }

    public String getStudentID() {
        return studentID.getText();
    }

}

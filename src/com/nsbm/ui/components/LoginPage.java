package com.nsbm.ui.components;

import com.nsbm.app.components.academic.Faculty;
import com.nsbm.main.Main;
import com.nsbm.ui.resources.Resource;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
        import javafx.scene.control.ComboBox;
        import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginPage extends HBox {

    @FXML
    private ComboBox<Faculty> selectFacultyDropDown;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    public LoginPage() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Resource.fxml + "loginpage.fxml"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch(IOException e) {
            e.printStackTrace();
        }
        init_Fields();
        init_Buttons();
    }

    public void init_Buttons() {
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(passwordField.getText().equals(Main.password)) {
                    Main.currentFaculty = selectFacultyDropDown.getSelectionModel().getSelectedItem();

                    Main.currentScene = new Scene(new HomePage());
                    Main.currentStage.close();
                    String stageTitle = Main.currentStage.getTitle();
                    Main.currentStage = new Stage();
                    Main.currentStage.setTitle(stageTitle);
                    Main.currentStage.setScene(Main.currentScene);
                    Main.currentStage.show();


                    Main.currentStage.setTitle(Main.currentStage.getTitle() + " | " + Main.currentFaculty.getFacultyName());
                }
            }
        });
    }

    public void init_Fields() {
        try {
            Main.faculties = Faculty.getFaculties();
            selectFacultyDropDown.setItems(FXCollections.observableArrayList(Main.faculties));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

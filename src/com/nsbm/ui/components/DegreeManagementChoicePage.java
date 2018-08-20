package com.nsbm.ui.components;

import com.nsbm.ui.resources.Resource;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class DegreeManagementChoicePage extends VBox {

    @FXML
    private Button manageExistingBtn;

    @FXML
    private Button addNewBtn;
    public DegreeManagementChoicePage() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Resource.fxml + "degreestartpage.fxml"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

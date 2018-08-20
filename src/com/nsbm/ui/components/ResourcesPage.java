package com.nsbm.ui.components;

import com.nsbm.ui.resources.Resource;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;

import java.io.IOException;

public class ResourcesPage extends TabPane {

    @FXML
    private Tab laboratoriesTab;

    @FXML
    private TableView<?> laboratoriesTable;
    public ResourcesPage() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Resource.fxml + "resources.fxml"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

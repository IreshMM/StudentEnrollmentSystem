package com.nsbm.ui.components;

import com.nsbm.ui.resources.Resource;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.io.IOException;

public class BillingPage extends TabPane {

    @FXML
    private Tab invoicesTab;

    @FXML
    private TextField studentIDField;

    @FXML
    private ChoiceBox<?> studentYearDropDown;

    @FXML
    private ChoiceBox<?> studentSemesterDropDown;

    @FXML
    private TableView<?> invoiceTable;
    public BillingPage() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Resource.fxml + "billing.fxml"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

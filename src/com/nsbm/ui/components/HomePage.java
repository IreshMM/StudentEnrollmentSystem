package com.nsbm.ui.components;

import com.nsbm.ui.resources.Resource;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class HomePage extends BorderPane {

    @FXML
    private Label numberOfRegisteredStd;

    @FXML
    private Label numberOfacademicStaff;

    @FXML
    private Label numberOfdegProg;

    @FXML
    private ImageView settingsBtn;

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
    private HomePage homePage = this;
    private StudentManagementPage stdMgtPage;
    private StaffManagementPage staffMgtPage;
    private DegreeManagementChoicePage degMgtChoicePage;
    private ResourcesPage resourcesPage;
    private BillingPage billingPage;

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

        this.setCenter(stdMgtPage);

    }

    public void setStdMgtPage(StudentManagementPage stdMgtPage) {
        this.stdMgtPage = stdMgtPage;
    }

    public void setStaffMgtPage(StaffManagementPage staffMgtPage) {
        this.staffMgtPage = staffMgtPage;
    }

    public void setDegMgtChoicePage(DegreeManagementChoicePage degMgtChoicePage) {
        this.degMgtChoicePage = degMgtChoicePage;
    }

    public void setResourcesPage(ResourcesPage resourcesPage) {
        this.resourcesPage = resourcesPage;
    }

    public void setBillingPage(BillingPage billingPage) {
        this.billingPage = billingPage;
    }

    public StudentManagementPage getStdMgtPage() {
        return stdMgtPage;
    }

    public StaffManagementPage getStaffMgtPage() {
        return staffMgtPage;
    }

    public DegreeManagementChoicePage getDegMgtChoicePage() {
        return degMgtChoicePage;
    }

    public ResourcesPage getResourcesPage() {
        return resourcesPage;
    }

    public BillingPage getBillingPage() {
        return billingPage;
    }

    public void init_Buttons() {
        stdManagementSideBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                homePage.setCenter(stdMgtPage);
            }
        });

        academicStaffSideBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                homePage.setCenter(staffMgtPage);
            }
        });

        degreeProgramsSideBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                homePage.setCenter(degMgtChoicePage);
            }
        });

        resourcesSideBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                homePage.setCenter(resourcesPage);
            }
        });

        billingSideBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                homePage.setCenter(billingPage);
            }
        });
    }

    public void init_Pages() {
        this.setStdMgtPage(new StudentManagementPage());
        this.setStaffMgtPage(new StaffManagementPage());
        this.setDegMgtChoicePage(new DegreeManagementChoicePage());
        this.setResourcesPage(new ResourcesPage());
        this.setBillingPage(new BillingPage());
    }
}

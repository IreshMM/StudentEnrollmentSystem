package com.nsbm.main;

import com.nsbm.app.components.academic.Course;
import com.nsbm.app.components.human.UndergraduateStudent;
import com.nsbm.app.database.DatabaseConnection;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.Date;

public class Main extends Application {
    public static String databaseURL;
    public static String databaseUsername;
    public static String databasePassword;

    @Override
    public void start(Stage primaryStage) throws Exception{

        DatabaseConnection db = new DatabaseConnection("localhost:3306", "root", "");

        UndergraduateStudent st = new UndergraduateStudent();

        st.setNicNumber("19101873730v");
        st.setIndexNumber(18007299);
        st.setFirstName("Renee");
        st.setLastName("Corpes");
        st.setDateOfBirth(new Date(1997, 4, 20));
        st.setAddress("18 Maple Wood Place");
        st.setPhone("94764374759");
        st.setEmail("rcorpes0@barnesandnoble.com");
        st.setCourse(new Course("SB02", "The title"));
        st.setPhone("4545");
        st.setPhoto("D");
        st.setSignature("DFDF");

        db.insertPerson(st);


/*        Parent root = new HomePage();

        primaryStage.setTitle("Student Enrollment NSBM Green University");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}

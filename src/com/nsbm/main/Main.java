package com.nsbm.main;

import com.nsbm.app.components.academic.Enrollment;
import com.nsbm.app.components.human.Instructor;
import com.nsbm.app.components.human.Student;
import com.nsbm.app.database.DatabaseConnection;
import com.nsbm.ui.components.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.LinkedList;

public class Main extends Application {
    public static String databaseURL = "localhost:3306";
    public static String databaseUsername = "root";
    public static String databasePassword = "";

    /* Globally available UI elements */
    public static BillingPage billingPage;
    public static DegreeManagementChoicePage degreeManagementChoicePage;
    public static DegreeManagementPage degreeManagementPage;
    public static HomePage homePage;
    public static ManagementSelectUserPage selectStudentPage;
    public static ManagementSelectUserPage selectStaffMemberPage;
    public static ResourcesPage resourcesPage;
    public static StaffManagementPage staffManagementPage;
    public static StudentManagementPage studentManagementPage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Instructor instructor = (Instructor) Instructor.retrieveFromDatabase("110004", DatabaseConnection.BYID);

        instructor.setFirstName("Iresh");
        System.out.println(instructor.getFirstName());
        instructor.updateOnDatabase();

/*        DatabaseConnection db = new DatabaseConnection("localhost:3306", "root", "");

        Student student = (Student) db.retrievePerson("2", DatabaseConnection.STUDENT, DatabaseConnection.BYID);

        System.out.println(student.getFirstName());

        LinkedList<Enrollment> linkedList = db.retriveEnrollments(student);

        for (Enrollment enrollment: linkedList) {
            System.out.println(enrollment.getSubject().getTitle());
        }*/

       /*  UndergraduateStudent st = new UndergraduateStudent();

        st.setNicNumber("19741873730v");
        st.setIndexNumber(18017299);
        st.setFirstName("Renee");
        st.setLastName("Corpes");
        st.setDateOfBirth(new Date(1997, 4, 20));
        st.setAddress("18 Maple Wood Place");
        st.setPhone("94764374859");
        st.setEmail("rcorpes0@barnddesandnoble.com");
        st.setCourse(new Course("SB02", "The title", new Faculty(1, "SCHOOL OF ENGINEERING")));
        st.setPhone("45445");
        st.setPhoto("sd");
        st.setSignature("gh");

        db.insertPerson(st);*/

/*        Parent root = new HomePage();

        primaryStage.setTitle("Student Enrollment NSBM Green University");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}

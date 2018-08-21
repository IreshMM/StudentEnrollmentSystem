package com.nsbm.app.database;

import com.nsbm.app.components.academic.Course;
import com.nsbm.app.components.academic.Faculty;
import com.nsbm.app.components.human.*;

import java.sql.*;

public class DatabaseConnection {

    private Connection connection;

    public DatabaseConnection(String url, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://" + url +
                    "/demo?autoReconnect=true&useSSL=true&verifyServerCertificate=false", user, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /* INSERTION FUNCTIONS */
    public int insertPerson(Person person) throws SQLException {

        String query;
        String specializedColumns;
        String additionalValues;

        String queryBegin = "INSERT INTO ";
        String queryColumns = " (NICNumber, FirstName, LastName, DOB, Address, Phone, Email, Photo, Signature, ";
        String queryValues = ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ";
        String queryEnd = ");";

        if (person instanceof Student) {
            specializedColumns = "IndexNumber, CourseCode";
            additionalValues = "?, ?";
        } else if (person instanceof Instructor) {
            specializedColumns = "Staff_ID";
            additionalValues = "?";
        } else {
            specializedColumns = "Staff_ID, FacultyID";
            additionalValues = "?, ?";
        }

        query = queryBegin + queryColumns + specializedColumns + queryValues + additionalValues + queryEnd;

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, person.getNicNumber());
        statement.setString(2, person.getFirstName());
        statement.setString(3, person.getLastName());
        statement.setDate(4, person.getDateOfBirth());
        statement.setString(5, person.getAddress());
        statement.setString(6, person.getPhone());
        statement.setString(7, person.getEmail());
        statement.setString(8, person.getPhoto());
        statement.setString(9, person.getSignature());

        if (person instanceof Student) {
            statement.setInt(10, ((Student) person).getIndexNumber());
            statement.setString(11, ((Student) person).getCourse().getCourseCode());
        } else if (person instanceof Instructor) statement.setString(10, ((Instructor) person).getStaffID());
        else {
            statement.setString(10, ((Lecturer) person).getStaffID());
            statement.setInt(11, ((Lecturer) person).getFacultyID());
        }

        return statement.executeUpdate();
    }

    /* RETRIEVING FUNCTIONS */
    public Person retrivePerson(String key, int TYPE, int FLAG) throws SQLException {
        Person person;
        String query;
        ResultSet resultSet;

        Statement statement = connection.createStatement();

        String keyFieldName;

        if(FLAG == BYID) keyFieldName = "Staff_ID";
        else keyFieldName = "NICNumber";

        if(TYPE == STUDENT) {
            if(FLAG == BYID) {
                keyFieldName = "StudentID";
            }

            String subQuery = "(SELECT Student.*, Course.title AS courseTitle, Postgraduate, FacultyID " +
                    "FROM Student INNER JOIN Course ON Course.CourseCode = Student.CourseCode " +
                    "WHERE " + keyFieldName + "=" + key + ")";

            query = "SELECT t.*, title FROM " +
                    "subQuery AS t INNER JOIN Faculty ON " +
                    "t.FacultyID = Faculty.FacultyID;";

            resultSet = statement.executeQuery(query);
            resultSet.next();

            if(resultSet.getBoolean("Postgraduate")) {
                person = new PostgraduateStudent();
            } else {
                person = new UndergraduateStudent();
            }

            Faculty studentFaculty = new Faculty(resultSet.getInt("FacultyID"), resultSet.getString("title"));
            Course studentCourse = new Course(resultSet.getString("courseCode"), resultSet.getString("courseTitle"), studentFaculty);

            ((Student) person).setCourse(studentCourse);
            ((Student) person).setIndexNumber(resultSet.getInt("IndexNumber"));

        } else {
            if(TYPE == INSTRUCTOR) {
                person = new Instructor();

                query = "SELECT * FROM Instructor " +
                        "WHERE " + keyFieldName + "=" + key + ";";

                resultSet = statement.executeQuery(query);
            }
            else {
                person = new Lecturer();
                query = "SELECT * FROM Lecturer " +
                        "WHERE " + keyFieldName + "=" + key + ";";

                resultSet = statement.executeQuery(query);
                resultSet.next();

                ((Lecturer) person).setFacultyID(resultSet.getInt("FacultyID"));
            }

            ((StaffMember) person).setStaffID(resultSet.getString("Staff_ID"));
        }

        person.setNicNumber(resultSet.getString("NICNumber"));
        person.setFirstName(resultSet.getString("FirstName"));
        person.setLastName(resultSet.getString("LastName"));
        person.setDateOfBirth(resultSet.getDate("DOB"));
        person.setAddress(resultSet.getString("Address"));
        person.setPhone(resultSet.getString("Phone"));
        person.setEmail(resultSet.getString("Email"));
        person.setPhoto(resultSet.getString("Photo"));
        person.setSignature(resultSet.getString("Signature"));

        return person;

    }


    /* FLAGS */
    public static final int BYID = 1;
    public static final int BYNIC = 2;

    /* TYPES */
    public static final int STUDENT = 3;
    public static final int INSTRUCTOR = 4;
    public static final int LECTURER = 5;
}

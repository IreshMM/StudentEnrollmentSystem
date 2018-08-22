package com.nsbm.app.database;

import com.nsbm.app.components.academic.*;
import com.nsbm.app.components.human.*;
import com.nsbm.app.components.misc.Invoice;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;
import java.util.LinkedList;

public class DatabaseConnection {

    private Connection connection;
    private Statement statement;

    public DatabaseConnection(String url, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://" + url +
                    "/demo?autoReconnect=true&useSSL=true&verifyServerCertificate=false", user, password);

            statement = connection.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /* INSERTION FUNCTIONS */
    public int insertPerson(Person person, boolean update) throws SQLException {

        String query;
        String specializedColumns;
        String additionalValues;
        String tableName;

        String queryBegin = "INSERT INTO ";
        String queryColumns = " (NICNumber, FirstName, LastName, DOB, Address, Phone, Email, Photo, Signature";
        String queryValues = ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?";
        String queryUpdate = ") " +
                "ON DUPLICATE KEY UPDATE " +
                "NICNumber = VALUES(NICNumber), " +
                "FirstName = VALUES(FirstName), " +
                "LastName = VALUES(LastName), " +
                "DOB = VALUES(DOB), " +
                "Address = VALUES(Address), " +
                "Phone = VALUES(Phone), " +
                "Email = VALUES(Email), " +
                "Photo = VALUES(Photo), " +
                "Signature = VALUES(Signature)";
        String queryEnd = ";";

        if (person instanceof Student) {
            specializedColumns = ", IndexNumber, CourseCode";
            additionalValues = ", ?, ?";
            tableName = "Student";
            queryUpdate = queryUpdate + ", IndexNumber = VALUES(IndexNumber), CourseCode = VALUES(CourseCode)";

            if(update) {
                specializedColumns = specializedColumns + ", StudentID";
                additionalValues = additionalValues + ", ?";
                queryUpdate = queryUpdate + ", StudentID = VALUES(StudentID)";
            }
        } else {
            specializedColumns = "";
            additionalValues = "";
            tableName = "Instructor";

            if(update) {
                specializedColumns = specializedColumns + ", Staff_ID";
                additionalValues = additionalValues + ", ?";
                queryUpdate = queryUpdate + ", Staff_ID = VALUES(Staff_ID)";
            }

            if(person instanceof Lecturer) {
                specializedColumns = specializedColumns + ", FacultyID";
                additionalValues = ", ?";
                tableName = "Lecturer";
                queryUpdate = queryUpdate + ", FacultyID = VALUES(FacultyID)";
            }
        }

        query = queryBegin + tableName + queryColumns + specializedColumns +
                queryValues + additionalValues + queryUpdate + queryEnd;

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

            if(update) {
                statement.setInt(12, ((Student) person).getStudentID());
            }
        } else {
            int index = 9;
            if(update) {
                statement.setInt(index + 1, ((StaffMember) person).getStaffID());
                index++;
            }
            if(person instanceof Lecturer) {
                statement.setInt(index + 1, ((Lecturer) person).getFacultyID());
            }

        }

        System.out.println(statement);
        return statement.executeUpdate();
    }

    private int insertEnrollment(Enrollment enrollment) throws SQLException {
        String query = "INSERT INTO Enrollment " +
                "(StudentID, SubjectCode, InvoiceID) " +
                "VALUES (?, ?, ?);";

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, enrollment.getStudent().getStudentID());
        statement.setString(2, enrollment.getSubject().getSubjectCode());
        statement.setInt(3, enrollment.getInvoice().getInvoiceID());

        return statement.executeUpdate();
    }

    public int insertInvoice(Invoice invoice) throws SQLException {
        String query = "INSERT INTO Payment " +
                "(InvoiceID, Description, Amount) " +
                "VALUES (?, ?, ?);";

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, invoice.getInvoiceID());
        statement.setString(2, invoice.getDescription());
        statement.setDouble(3, invoice.getAmount());

        statement.executeUpdate();

        for(Enrollment enrollment: invoice.getEnrollments()) {
            enrollment.setInvoice(invoice);
            insertEnrollment(enrollment);
        }

        return 1;
    }

    /* RETRIEVING FUNCTIONS */
    public Person retrievePerson(String key, int TYPE, int FLAG) throws SQLException {
        Person person;
        String query;
        ResultSet resultSet;

        String keyFieldName;

        if(FLAG == BYID) keyFieldName = "Staff_ID";
        else keyFieldName = "NICNumber";

        if(TYPE == STUDENT) {
            if(FLAG == BYID) {
                keyFieldName = "StudentID";
            }

            String subQuery = "(SELECT Student.*, Course.Title AS courseTitle, Postgraduate, FacultyID " +
                    "FROM Student INNER JOIN Course ON Course.CourseCode = Student.CourseCode " +
                    "WHERE " + keyFieldName + "='" + key + "')";

            query = "SELECT t.*, FacultyName FROM " + subQuery +
                    " AS t INNER JOIN Faculty ON " +
                    "t.FacultyID = Faculty.FacultyID;";

            resultSet = statement.executeQuery(query);
            resultSet.next();

            if(resultSet.getBoolean("Postgraduate")) {
                person = new PostgraduateStudent();
            } else {
                person = new UndergraduateStudent();
            }

            Faculty studentFaculty = new Faculty(resultSet.getInt("FacultyID"), resultSet.getString("FacultyName"));
            Course studentCourse = new Course(resultSet.getString("courseCode"), resultSet.getString("courseTitle"), studentFaculty);

            ((Student) person).setStudentID(resultSet.getInt("StudentID"));
            ((Student) person).setCourse(studentCourse);
            ((Student) person).setIndexNumber(resultSet.getInt("IndexNumber"));

        } else {
            if(TYPE == INSTRUCTOR) {
                person = new Instructor();

                query = "SELECT * FROM Instructor " +
                        "WHERE " + keyFieldName + "='" + key + "';";

                resultSet = statement.executeQuery(query);
                resultSet.next();
            }
            else {
                person = new Lecturer();
                query = "SELECT * FROM Lecturer " +
                        "WHERE " + keyFieldName + "='" + key + "';";

                resultSet = statement.executeQuery(query);
                resultSet.next();

                ((Lecturer) person).setFacultyID(resultSet.getInt("FacultyID"));
            }

            ((StaffMember) person).setStaffID(resultSet.getInt("Staff_ID"));
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

    public LinkedList<Enrollment> retriveEnrollments(Student student) throws SQLException {
        LinkedList<Enrollment> enrollments = new LinkedList<>();

        int studentID = student.getStudentID();

        String queryEnrollments = "SELECT Enrollment.* FROM " +
                "Student INNER JOIN Enrollment ON Student.StudentID = Enrollment.StudentID " +
                "WHERE Student.StudentID " + "=" + studentID;

        ResultSet resultSet = statement.executeQuery(queryEnrollments);

        RowSetFactory factory = RowSetProvider.newFactory();
        CachedRowSet cachedResultSet = factory.createCachedRowSet();
        cachedResultSet.populate(resultSet);

        while(cachedResultSet.next()) {
            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student);
            enrollment.setResultGrade(cachedResultSet.getString("ResultGrade").charAt(0));

            /* Retrieve subject details */
            String querySubject = "SELECT * FROM Subject_ " +
                    "WHERE SubjectCode = '" + cachedResultSet.getString("SubjectCode") + "';";

            ResultSet subjectResultSet = statement.executeQuery(querySubject);
            subjectResultSet.next();
            Subject studentSubject = new Subject(subjectResultSet.getString("SubjectCode"),
                    subjectResultSet.getString("Title"),
                    subjectResultSet.getInt("Fee"),
                    subjectResultSet.getBoolean("Optional"));

            /* Retrieve assessments */
            LinkedList<Assessment> assessments = null;

            String queryAssessments = "SELECT * FROM Assessment " +
                    "WHERE EnrollmentID = " + cachedResultSet.getString("EnrollmentID") + ";";
            ResultSet assessmentsResultSet = statement.executeQuery(queryAssessments);

            while(assessmentsResultSet.next()) {
               assessments = new LinkedList<>();

                Assessment assessment = new Assessment(assessmentsResultSet.getInt("AssessmentID"),
                        assessmentsResultSet.getString("AssessmentType"),
                        assessmentsResultSet.getString("title"),
                        assessmentsResultSet.getString("ResultGrade").charAt(0));

                assessments.add(assessment);
            }


            enrollment.setSubject(studentSubject);
            enrollment.setAssessments(assessments);

            enrollments.add(enrollment);
        }

        return enrollments;
    }

    /* HELPER FUNCTIONS FOR RETRIEVING COUNTS */
    public int getCount(String tableName) throws SQLException {
        String query = "SELECT COUNT(*) FROM " + tableName + ";";

        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        return resultSet.getInt(1);
    }

    /* UPDATING FUNCTIONS */



    /* FLAGS */
    public static final int BYID = 1;
    public static final int BYNIC = 2;

    /* TYPES */
    public static final int STUDENT = 4;
    public static final int INSTRUCTOR = 5;
    public static final int LECTURER = 6;
}

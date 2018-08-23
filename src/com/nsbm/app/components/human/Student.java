package com.nsbm.app.components.human;

import com.nsbm.app.components.academic.Course;
import com.nsbm.app.components.academic.Enrollment;
import com.nsbm.app.components.academic.Subject;
import com.nsbm.app.database.DatabaseConnection;
import com.nsbm.main.Main;

import java.sql.SQLException;
import java.util.LinkedList;

public abstract class Student extends Person {

    private int studentID;
    private int indexNumber;
    private Course course;
    private int registrationYear;

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setRegistrationYear(int registrationYear) {
        this.registrationYear = registrationYear;
    }

    public int getRegistrationYear() {
        return registrationYear;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public Course getCourse() {
        return course;
    }

    public int getCurrentYear() {
        return Main.getDate().getYear() - registrationYear + 1;
    }

    public int getCurrentSemester() {
        return Main.getDate().getMonthValue() > 6 ? 2 : 1;
    }

    public LinkedList<Subject> getSubjectsForCurrentSemester() throws SQLException {
        LinkedList<Subject> subjects = course.getSubjects();
        LinkedList<Subject> subjectsForSem = new LinkedList<>();

        for(Subject subject: subjects) {
            if(subject.getSemester() == getCurrentSemester()) {
                subjectsForSem.add(subject);
            }
        }
        return subjectsForSem;
    }

    public LinkedList<Subject> getEnrolledSubjectsForSemester() throws SQLException {
        LinkedList<Subject> subjects = new LinkedList<>();

        LinkedList<Enrollment> enrollments = databaseConnection.retrieveEnrollments(this);
        int currentSemester = getCurrentSemester();

        for(Enrollment enrollment : enrollments) {
            Subject subject = enrollment.getSubject();
            if(subject.getSemester() == getCurrentSemester()) {
                subjects.add(subject);
            }
        }
        return subjects;
    }

    public static int getCount() {
        try {
            return databaseConnection.getCount("Student");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Student retrieveFromDatabase(String key, int FLAG) throws SQLException {
        return (Student) databaseConnection.retrievePerson(key, DatabaseConnection.STUDENT, DatabaseConnection.BYID);
    }

}

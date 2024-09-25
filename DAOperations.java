package DAO;

import Bean.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDAO class for handling database operations related to the Student entity.
 */
public class StudentDAO {

    // Database credentials
    private final String dbURL = "jdbc:mysql://localhost:3306/University"; // Replace with your actual DB name
    private final String dbUsername = "root";  // Replace with your actual username
    private final String dbPassword = "123456789"; // Replace with your actual password
    private final String dbDriver = "com.mysql.cj.jdbc.Driver";

    // Method to initialize the database connection
    private Connection initializeDatabase() throws ClassNotFoundException, SQLException {
        Class.forName(dbDriver);
        return DriverManager.getConnection(dbURL, dbUsername, dbPassword);
    }

    // Method to save student information to the database
    public void saveStudent(Student student) throws ClassNotFoundException, SQLException {
        String INSERT_STUDENT_SQL = "INSERT INTO Students (regNo, name, dob, gender, branch, year, semester, collegeName) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = initializeDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {

            preparedStatement.setString(1, student.getRegisteredNo());
            preparedStatement.setString(2, student.getStudentName());
            preparedStatement.setString(3, student.getDob());
            preparedStatement.setString(4, student.getGender());
            preparedStatement.setString(5, student.getBranch());
            preparedStatement.setInt(6, student.getYear());
            preparedStatement.setString(7, student.getSemester());
            preparedStatement.setString(8, student.getCollegeName());

            preparedStatement.executeUpdate();
        }
    }

    // Method to retrieve all student details from the database
    public List<Student> getStudentDetails() throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM Students";
        List<Student> studentList = new ArrayList<>();

        try (Connection connect = initializeDatabase();
             Statement stmt = connect.createStatement();
             ResultSet res = stmt.executeQuery(query)) {

            while (res.next()) {
                String registeredNo = res.getString(1);
                String studentName = res.getString(2);
                String dob = res.getString(3);
                String gender = res.getString(4);
                String branch = res.getString(5);
                int year = res.getInt(6);
                String semester = res.getString(7);
                String collegeName = res.getString(8);

                Student student = new Student(registeredNo, studentName, dob, gender, branch, year, semester, collegeName);
                studentList.add(student);
            }
        }
        return studentList;
    }

    // Method to get a student by registration number
    public Student getStudentByRegisteredNo(String registeredNo) throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM Students WHERE regNo = ?";
        Student student = null;

        try (Connection connect = initializeDatabase();
             PreparedStatement preparedStatement = connect.prepareStatement(query)) {
            preparedStatement.setString(1, registeredNo);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                String studentName = res.getString(2);
                String dob = res.getString(3);
                String gender = res.getString(4);
                String branch = res.getString(5);
                int year = res.getInt(6);
                String semester = res.getString(7);
                String collegeName = res.getString(8);

                student = new Student(registeredNo, studentName, dob, gender, branch, year, semester, collegeName);
            }
        }
        return student;
    }

    // Method to update a student's details in the database
    public void updateStudent(Student student) throws ClassNotFoundException, SQLException {
        String UPDATE_STUDENT_SQL = "UPDATE Students SET name = ?, dob = ?, gender = ?, branch = ?, year = ?, semester = ?, collegeName = ? WHERE regNo = ?";

        try (Connection connection = initializeDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {

            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getDob());
            preparedStatement.setString(3, student.getGender());
            preparedStatement.setString(4, student.getBranch());
            preparedStatement.setInt(5, student.getYear());
            preparedStatement.setString(6, student.getSemester());
            preparedStatement.setString(7, student.getCollegeName());
            preparedStatement.setString(8, student.getRegisteredNo());

            preparedStatement.executeUpdate();
        }
    }

    // Method to delete a student from the database
    public void deleteStudent(String registeredNo) throws ClassNotFoundException, SQLException {
        String DELETE_STUDENT_SQL = "DELETE FROM Students WHERE regNo = ?";

        try (Connection connection = initializeDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL)) {

            preparedStatement.setString(1, registeredNo);
            preparedStatement.executeUpdate();
        }
    }
}

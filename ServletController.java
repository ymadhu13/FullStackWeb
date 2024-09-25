package Controller;

import Bean.Student;
import DAO.StudentDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletController() {
        super();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("display".equals(action)) {
                displayStudentDetails(request, response);
            } else if ("update".equals(action)) {
                showUpdateForm(request, response);
            } else if ("delete".equals(action)) {
                deleteStudent(request, response);
            } else {
                displayStudentDetails(request, response); // Default action
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error occurred: " + e.getMessage());
        }
    }


    private void saveStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String registeredNo = request.getParameter("registeredNo");
        String studentName = request.getParameter("studentName");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String branch = request.getParameter("branch");
        int year = Integer.parseInt(request.getParameter("year"));
        String semester = request.getParameter("semester");
        String collegeName = request.getParameter("collegeName");

        Student student = new Student(registeredNo, studentName, dob, gender, branch, year, semester, collegeName);

        try {
            StudentDAO studentDAO = new StudentDAO();
            studentDAO.saveStudent(student);
            response.getWriter().println("Student data saved successfully!");
            displayStudentDetails(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error saving student data: " + e.getMessage());
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String registeredNo = request.getParameter("registeredNo");
        try {
            StudentDAO studentDAO = new StudentDAO();
            Student student = studentDAO.getStudentByRegisteredNo(registeredNo);
            request.setAttribute("student", student);
            RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateStudent.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error retrieving student data: " + e.getMessage());
        }
    }

    protected void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String registeredNo = request.getParameter("registeredNo");
        String studentName = request.getParameter("studentName");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String branch = request.getParameter("branch");
        int year = Integer.parseInt(request.getParameter("year"));
        String semester = request.getParameter("semester");
        String collegeName = request.getParameter("collegeName");

        Student student = new Student(registeredNo, studentName, dob, gender, branch, year, semester, collegeName);

        try {
            StudentDAO studentDAO = new StudentDAO();
            studentDAO.updateStudent(student);
            response.getWriter().println("Student data updated successfully!");
            displayStudentDetails(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error updating student data: " + e.getMessage());
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String registeredNo = request.getParameter("registeredNo");
        try {
            StudentDAO studentDAO = new StudentDAO();
            studentDAO.deleteStudent(registeredNo);
            response.getWriter().println("Student deleted successfully!");
            displayStudentDetails(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error deleting student data: " + e.getMessage());
        }
    }

    private void displayStudentDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentDetails;
        try {
            StudentDAO studentDAO = new StudentDAO();
            studentDetails = studentDAO.getStudentDetails();
            RequestDispatcher dispatcher = request.getRequestDispatcher("StudentInfoDetails.jsp");
            request.setAttribute("studentDetails", studentDetails);
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error retrieving student details: " + e.getMessage());
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("submit"); // Assuming action is set by form's submit button

        try {
            if ("Register".equals(action)) {
                saveStudent(request, response); // Handle student registration
            } else if ("update".equals(request.getParameter("action"))) {
                updateStudent(request, response); // Handle student update
            } else {
                doGet(request, response); // Default to GET behavior if no action matched
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error occurred: " + e.getMessage());
        }
    }

}

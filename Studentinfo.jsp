<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Bean.Student" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e0f7fa;
            text-align: center;
        }
        .button-group {
            margin: 20px;
        }
        .nav-button {
            padding: 10px 20px;
            margin: 0 10px;
            border-radius: 4px;
            text-decoration: none;
            color: white;
            font-weight: bold;
            background-color: #2196F3; /* Blue */
            transition: background-color 0.3s;
        }
        .nav-button:hover {
            background-color: #1976D2; /* Darker Blue */
        }
        table {
            margin: 20px auto;
            border-collapse: collapse;
            width: 80%;
        }
        th, td {
            border: 1px solid #00796b;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #00796b;
            color: white;
        }
        tr:hover {
            background-color: #b2ebf2;
        }
        .action-link {
            padding: 6px 12px;
            margin: 0 5px;  /* Add space between links */
            border-radius: 4px;
            text-decoration: none;
            color: white;
            font-weight: bold;
            transition: background-color 0.3s;
        }
        .update-link {
            background-color: #4caf50; /* Green */
        }
        .update-link:hover {
            background-color: #45a049; /* Darker Green */
        }
        .delete-link {
            background-color: #f44336; /* Red */
        }
        .delete-link:hover {
            background-color: #e53935; /* Darker Red */
        }
    </style>
</head>
<body>
<div class="button-group">
        <a href="Home.jsp" class="nav-button">Home</a>
        <a href="StudentForm.jsp" class="nav-button">Add Student</a>
    </div>
    <h1>Student Information Details</h1>

    <table>
        <thead>
            <tr>
                <th>Registration Number</th>
                <th>Name</th>
                <th>Date of Birth</th>
                <th>Gender</th>
                <th>Branch</th>
                <th>Year</th>
                <th>Semester</th>
                <th>College Name</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Suppressing unchecked cast warning
                @SuppressWarnings("unchecked")
                List<Student> studentDetails = (List<Student>) request.getAttribute("studentDetails");

                if (studentDetails != null && !studentDetails.isEmpty()) {
                    for (Student student : studentDetails) {
            %>
            <tr>
                <td><%= student.getRegisteredNo() %></td>
                <td><%= student.getStudentName() %></td>
                <td><%= student.getDob() %></td>
                <td><%= student.getGender() %></td>
                <td><%= student.getBranch() %></td>
                <td><%= student.getYear() %></td>
                <td><%= student.getSemester() %></td>
                <td><%= student.getCollegeName() %></td>
                <td>
                    <a href="ServletController?action=update&registeredNo=<%= student.getRegisteredNo() %>" class="action-link update-link">Update</a>
                </td>
                <td>                    <a href="ServletController?action=delete&registeredNo=<%= student.getRegisteredNo() %>" class="action-link delete-link" onclick="return confirm('Are you sure you want to delete this student?');">Delete</a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="9">No student information available.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>

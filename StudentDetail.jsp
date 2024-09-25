<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration</title>
   	<style>
   	body {
    font-family: Arial, sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    margin: 0;
}
.container {
    background-color:Teal;
    padding: 20px;
    border-radius: 10px;
    box-shadow: black;
    width: 300px;
}
h2 {
    text-align: center;
    color: Black;
}
form {
    display: flex;
    flex-direction: column;
}
label {
    margin-top: 10px;
}
input, select {
    padding: 8px;
    margin-top: 5px;
    border: 1px solid black;
    border-radius: 5px;
}
button {
    margin-top: 15px;
    padding: 10px;
    border: none;
    border-radius: 5px;
    background-color:green;
    color: white;
    cursor: pointer;
}
button[type="reset"] {
    background-color:red ;
}
button[type="button"] {
    background-color: blue;
}
		button:hover {
    	opacity: 0.8;
		}
		.button-group {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }
        .button-group a {
            display: inline-block;
            padding: 10px 20px;
            text-decoration: none;
            font-size: 16px;
            color: white;
            border-radius: 4px;
            text-align: center;
            box-sizing: border-box;
            margin-top:10px;
        }
        .view-button {
            background-color: #4CAF50;
        }
        .view-button:hover {
            background-color: #45a049;
        }
        .add-button {
            background-color: #2196F3;
        }
        .add-button:hover {
            background-color: #1e88e5;
            }

   	</style>
</head>
<body>
    <div class="container" >
        <h2>Student Registration</h2>
        <form>
            <label for="regNo">Registration No:</label>
            <input type="text" id="regNo" name="regNo" required>
            <label for="studentName">Student Name:</label>
            <input type="text" id="studentName" name="name" required>
            <label for="dob">DOB:</label>
            <input type="text" id="dob" name="dob" placeholder="mm/dd/yyyy" required>
            <label for="gender">Gender:</label>
            <select id="gender" name="gender" required>
                <option value="">Select your gender</option>
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
            </select>
            <label for="branch">Branch:</label>
            <select id="branch" name="branch" required>
                <option value="">Select your branch</option>
           		<option value="">CSE(AIML)</option>
           		<option value="">CSE(DS)</option>
           		<option value="">CSE</option>
           		<option value="">IT</option>
           		<option value="">ECE</option>
           		<option value="">EEE</option>
           		<option value="">CIVIL</option>
           		<option value="">MECH</option>
            </select>
            <label for="year">Year:</label>
            <select id="year" name="year" required>
                <option value="">Select year</option>
                <option value="">1st Year</option>
                <option value="">2nd year</option>
                <option value="">3rd year</option>
                <option value="">4th year</option>
            </select>
            <label for="semester">Semester:</label>
            <select id="semester" name="semester" required>
                <option value="">Select semester</option>
               <option value="">1st Semester</option>
                <option value="">2nd Semester</option>
            </select>
            <label for="colage_name">CollageName</label>
           <input type="text" class=collage_name id="collage_name" placeholder="enter your collage name ">
            <button type="submit">Submit</button>
            <button type="reset">Reset</button>
            <div class="button-group">
            <a href="Home.jsp" target="_self" class="add-button">Go To Home</a>
            </div>
        </form>
    </div>
</body>
</html>
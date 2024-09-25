<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #ffffff;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: center;
            width: 100%;
            max-width: 400px;
            box-sizing: border-box;
        }
        h1 {
            margin-bottom: 20px;
            font-size: 24px;
            color: #333;
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
    <div class="container">
        <h1>Welcome to Student</h1>
        <div class="button-group">
            <a href="" class="view-button">Student Details</a>
            <a href="StudentDetails.jsp" target="_self" class="add-button">Add Student Details</a>
        </div>
    </div>
</body>
</html>
-- Create a new database (optional step, if you haven't already created one)
CREATE DATABASE University;

-- Use the created database
USE University;
CREATE TABLE Students (
    regNo VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    dob DATE NOT NULL,
    gender CHAR(1) NOT NULL,
    branch VARCHAR(255) NOT NULL,
    year INT NOT NULL,
    semester INT NOT NULL,
    collegeName VARCHAR(255) NOT NULL
);
SELECT *FROM Students;

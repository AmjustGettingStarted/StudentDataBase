<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Student</title>
    <link rel="stylesheet" href="styles/styles2.css">
</head>
<body>
    <div class="bg_heart"></div>
    <div class="form-container">
        <h1>Enter Details</h1>
        <form action="add-student" method="post">
            <label for="studentId">Student ID:</label>
            <input type="number" id="studentId" name="studentId" required><br>
            <label for="studentName">Student Name:</label>
            <input type="text" id="studentName" name="studentName" required><br>
            <label for="studentEmail">Student Email:</label>
            <input type="email" id="studentEmail" name="studentEmail" required><br>
            <label for="studentAge">Student Age:</label>
            <input type="number" id="studentAge" name="studentAge" required><br>
            <label for="studentCourse">Student Course:</label>
            <input type="text" id="studentCourse" name="studentCourse" required><br>
            <label for="studentCity">Student City:</label>
            <input type="text" id="studentCity" name="studentCity" required><br>
            <button type="submit">Submit</button>
        </form>
        
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="script/script2.js"></script> 
</body>
</html>

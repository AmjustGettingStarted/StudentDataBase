<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
<link rel="stylesheet" href="styles/styles2.css">
</head>
<body>
    <%
        ResultSet rs = (ResultSet) request.getAttribute("resultSet");
        if (rs != null) {
            try {
                if (rs.next()) {
    %>
    <div class="bg_heart"></div>
    <div class="form-container">
        <h1>Update Student</h1>
        <form action="save-update-details" method="post">
            <label for="studentId">Student ID:</label>
            <input type="number" name="studentId" readonly="readonly" value="<%= rs.getInt(1) %>"><br> 
            
            <label for="studentName">Student Name:</label>
            <input type="text" id="studentName" name="studentName" value="<%= rs.getString(2) %>"><br> 

            <label for="studentEmail">Student Email:</label> 
            <input type="email" id="studentEmail" name="studentEmail" required value="<%= rs.getString(3) %>"><br> 

            <label for="studentAge">Student Age:</label> 
            <input type="number" id="studentAge" name="studentAge" required value="<%= rs.getInt(4) %>"><br> 

            <label for="studentCourse">Student Course:</label> 
            <input type="text" id="studentCourse" name="studentCourse" required value="<%= rs.getString(5) %>"><br> 

            <label for="studentCity">Student City:</label> 
            <input type="text" id="studentCity" name="studentCity" required value="<%= rs.getString(6) %>"><br> 

            <button type="submit">Submit</button>
        </form>
    </div>
    <%
                } else {
                    out.print("<h2>No Data Found</h2>");
                }
            } catch (SQLException e) {
                out.print("<h2>Error retrieving data</h2>");
            }
        } else {
            out.print("<h2>No Data Found</h2>");
        }
    %>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="script/script2.js"></script> 
</body>
</html>

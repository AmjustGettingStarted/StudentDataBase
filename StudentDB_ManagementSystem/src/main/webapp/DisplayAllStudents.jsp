<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display All Students</title>
<link rel="stylesheet" type="text/css" href="styles/styles3.css"> 
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="script/script3.js"></script>
</head>
<body>
    <div class="bg_heart"></div>
    <div class="table-container">
        <%
        ResultSet rs = (ResultSet) request.getAttribute("resultSet");
        if (rs != null) {
        %>
        <h1>All Student Details</h1>
        <table>
            <tr>
                <th>Student ID</th>
                <th>Student Name</th>
                <th>Student Email</th>
                <th>Student Age</th>
                <th>Student Course</th>
                <th>Student City</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <%
            while (rs.next()) {
            %>
            <tr>
                <td><%= rs.getInt(1) %></td>
                <td><%= rs.getString(2) %></td>
                <td><%= rs.getString(3) %></td>
                <td><%= rs.getInt(4) %></td>
                <td><%= rs.getString(5) %></td>
                <td><%= rs.getString(6) %></td>
                <td class = "redirect"><a href="getId?StudentId=<%= rs.getInt(1) %>">Update</a></td>
                <td class = "redirect"><a href="deleteStudent?studentId=<%= rs.getInt(1) %>" onclick="return confirm('Are you sure you want to delete this student?');">Delete</a></td>
                <%-- <td><a href="deleteStudent?studentId=<%= rs.getInt(1) %>">Delete</a></td> --%>
            </tr>
            <%
            }
            %>
        </table>
        <h2><a class="back-to-dashboard" href="index.jsp"><span class="arrow-left">&#8592;</span> Go To Dashboard</a></h2>
        <%
        } else {
        out.print("<h2>No Data Found</h2>");
        }
        %>
    </div>
</body>
</html>

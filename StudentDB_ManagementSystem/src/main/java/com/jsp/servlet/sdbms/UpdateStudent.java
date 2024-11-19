package com.jsp.servlet.sdbms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/save-update-details")
public class UpdateStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("UpdateStudentId-> working");
		int studentId = Integer.parseInt(req.getParameter("studentId"));
		String studentName = req.getParameter("studentName");
		String studentEmail = req.getParameter("studentEmail");
		int studentAge = Integer.parseInt(req.getParameter("studentAge"));
		String studentCourse = req.getParameter("studentCourse");
		String studentCity = req.getParameter("studentCity");

		// JDBC Connection

		Connection conn = null;

		try {
			// S1 Loading mySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// S2 Establishing Connection
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/servlet_student-management-system?user=root&password=root");

			// S3 Prepared Statement
			PreparedStatement pst = conn.prepareStatement("UPDATE STUDENT SET STUDENTNAME=?,STUDENTEMAIL=?, STUDENTAGE=?,STUDENTCOURCE=?,STUDENTCITY=? WHERE STUDENTID=?");

			pst.setString(1, studentName);
			pst.setString(2, studentEmail);
			pst.setInt(3, studentAge);
			pst.setString(4, studentCourse);
			pst.setString(5, studentCity);
			pst.setInt(6, studentId);

			// S4 Execute Statement
			pst.execute();

			// S5 redirects to main page
			resp.sendRedirect("Display-all-students");
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					// S6 -> Close Connection
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}



}

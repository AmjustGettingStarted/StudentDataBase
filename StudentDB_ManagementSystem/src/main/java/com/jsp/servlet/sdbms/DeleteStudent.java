package com.jsp.servlet.sdbms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteStudent")
public class DeleteStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Delete Working -> Working ");
		int studentId = Integer.parseInt(req.getParameter("studentId"));

		Connection conn = null;

		try {
			// S1 Loading mySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// S2 Establishing Connection
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/servlet_student-management-system?user=root&password=root");

			// S3 Prepared Statement
			PreparedStatement pst = conn.prepareStatement("DELETE FROM STUDENT WHERE STUDENTID = ?");
			pst.setInt(1, studentId);

			// S4
			pst.execute();

			// S5 Redirect to Display all Students
			resp.sendRedirect("Display-all-students");

		} catch (Exception e) {
			e.printStackTrace();

		}
		// S6 Close Connection
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

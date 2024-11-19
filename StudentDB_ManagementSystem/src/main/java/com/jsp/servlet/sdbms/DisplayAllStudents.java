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
@WebServlet("/Display-all-students")
public class DisplayAllStudents extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection conn = null;

		try {
			// S1 Loading mySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// S2 Establishing Connection
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/servlet_student-management-system?user=root&password=root");

			// S3 Prepared Statement
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM STUDENT");

			// S4
			ResultSet rs = pst.executeQuery();

			req.setAttribute("resultSet", rs);
			RequestDispatcher rd = req.getRequestDispatcher("DisplayAllStudents.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

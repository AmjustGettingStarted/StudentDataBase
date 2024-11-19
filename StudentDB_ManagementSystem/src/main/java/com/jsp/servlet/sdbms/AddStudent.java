package com.jsp.servlet.sdbms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-student")
public class AddStudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
			PreparedStatement pst = conn.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?,?,?)");

			pst.setInt(1, studentId);
			pst.setString(2, studentName);
			pst.setString(3, studentEmail);
			pst.setInt(4, studentAge);
			pst.setString(5, studentCourse);
			pst.setString(6, studentCity);

			// S4 Execute Statement
			int res = pst.executeUpdate();
			System.out.println(res + " Data Inserted to DB");

			// S5 redirects to main page
			resp.sendRedirect("index.jsp");

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

package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeQueries;
import com.dao.MyConnectionManager;

public class UpdateDetailServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UpdateDetailServlet() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		try (Connection conn = MyConnectionManager.getConnection();
				 PreparedStatement stmt = conn.prepareStatement(EmployeeQueries.updateAll); ) {
					stmt.setString(1, request.getParameter("first_name"));
					stmt.setString(2, request.getParameter("last_name"));
					stmt.setInt(3, Integer.parseInt(request.getParameter("age")));
					stmt.setString(4, request.getParameter("email"));
					int result = stmt.executeUpdate();
					out.println(result + " no. of record(s) was successfully added in the database..!!");
				}
		   catch (SQLException ex) {
					ex.printStackTrace();
				}
		out.close();
	}
}

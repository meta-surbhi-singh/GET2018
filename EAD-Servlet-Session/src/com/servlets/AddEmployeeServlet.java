package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.*;

@SuppressWarnings("serial")
public class AddEmployeeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out =  response.getWriter();
	Employee employee = new Employee(request.getParameter("First_Name"),request.getParameter("Last_Name"),request.getParameter("Email"),Integer.parseInt(request.getParameter("age")));
	
	//out.println(query);
	try (
			Connection conn = MyConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(EmployeeQueries.insertQuery); ) {
		    stmt.setString(1, employee.getFirstName());
		    stmt.setString(2, employee.getLastName());
		    stmt.setString(3, employee.getEmail());
		    stmt.setInt(4, employee.getAge());
			int result = stmt.executeUpdate();
			out.println(result+ " no. of record(s) was successfully added in the database..!!");
		} 
	catch (SQLException ex) {
			ex.printStackTrace();
		}
	out.close();
    }
}

package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Employee;
import com.dao.EmployeeQueries;
import com.dao.MyConnectionManager;

public class ShowAllEmployeeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShowAllEmployeeServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<Employee> employeeList = new ArrayList<Employee>();
		try (Connection conn = MyConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(EmployeeQueries.selectQuery);) {

			ResultSet rset = stmt.executeQuery();
			int rowCount = 0;
			while (rset.next()) {
				employeeList.add(new Employee(rset.getString("First_Name"), rset.getString("Last_Name"),rset.getString("Email"), rset.getInt("age")));
				++rowCount;
			}
			out.println("<center>");
			out.println("<h1>TOTAL " + rowCount +" EMPLOYEE RECORDS </h1>");
			out.println("<font size = \"6\">");
			
		    out.println("<table border =\"1\" cellpadding =\"8\"> <tr><td>First Name</td> <td>Last Name</td> <td>Email</td> <td>age</td></tr>");
			
		for (Employee employee : employeeList) {
			out.println("<form action = UpdateServlet>");
			out.print("<tr><td>" + employee.getFirstName() + "</td> <td>" + employee.getLastName() +"</td> <td>" + employee.getEmail() +"</td> <td>" + employee.getAge() + "</td>");
			out.print("<td> <input type = \"hidden\" value = " + employee.getEmail()+ " name = \"email\"></td>");
			out.println("<td><input type = \"submit\" value = \"Update\"></td></tr> </form>");
		}
		out.println(" </table></font> </center>");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		out.close();
	}

}

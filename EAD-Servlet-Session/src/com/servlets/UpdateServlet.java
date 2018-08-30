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

public class UpdateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try (Connection conn = MyConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(EmployeeQueries.selectWithEmailQuery);) {
			stmt.setString(1, request.getParameter("email"));
			ResultSet rset = stmt.executeQuery();

			while (rset.next()) {
				Employee employee = new Employee(rset.getString("First_name"), rset.getString("Last_name"),
						rset.getString("Email"), rset.getInt("Age"));
				out.println("<center>");
				out.println("<table>");
				out.println("<form action =\"UpdateDetailServlet\" ");
				out.println("<tr> <td> First Name </td>");
				out.println("<td> <input type = \"text\" name =\"first_name\" value = \"" + employee.getFirstName()
						+ "\"</td> </tr>");
				out.println("<tr> <td> Last Name </td>");
				out.println("<td> <input type = \"text\" name =\"last_name\" value = \"" + employee.getLastName()
						+ "\" </td> </tr>");
				out.println("<tr>");
				out.println(
						"<td> <input type = \"hidden\" name = \"email\" value = \" " + employee.getEmail() + " \"</td> </tr>");
				out.println("<tr> <td> Age </td>");
				out.println("<td> <input type = \"number \" name = \"age\" value = \"" + employee.getAge()
						+ "\"</td> </tr>");
				out.println("<tr> <td> <input type = \"reset\" name = \"reset\" </td>");
				out.println("<td> <input type = \"submit\" name = \"Update\" value =\"Update\" </td> </tr>");
				out.println("</table>");
				out.println("</center>");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		out.close();

	}
}

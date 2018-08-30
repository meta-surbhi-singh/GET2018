package com.dao;

public class EmployeeQueries {

	public EmployeeQueries() {
		
	}
	public static final String insertQuery = "INSERT INTO employee (First_name, Last_name, Email, Age)VALUES (?,?,?,?)";
	
	public static final String selectWithNameQuery = "SELECT * FROM employee WHERE First_Name = ? AND Last_Name = ? ";
	
	public static final String selectWithEmailQuery = "SELECT * FROM employee WHERE Email = ?";
	
	public static final String selectQuery = "SELECT * FROM employee";

	public static final String updateAll = "UPDATE employee "
			+ " SET First_name = ? , Last_name = ?, Age= ?"
			+ " WHERE Email = ?";
}

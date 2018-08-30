package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnectionManager {
	 public static Connection getConnection()
	  {
	    Connection conn = null;
	    try
	    {
	      Class.forName("com.mysql.jdbc.Driver");
	      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "database");
	    }
	    catch (ClassNotFoundException e)
	    {
	      e.printStackTrace();
	      System.exit(1);
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      System.exit(2);
	    }
	    return conn;
	  }
}

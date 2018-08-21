package query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import databaseConnection.GetConnection;
import pojo.Orders;
public class Query1 implements Query{
	String query;
	
	public Query1(String query) {
		this.query = query;
		}

	public void executeQuery() {
		//System.out.println(strSelect);
		try (
				// Step 1: Allocate a database 'Connection' object
				Connection conn = GetConnection.getConnection();
				// Step 2: Allocate a 'Statement' object in the Connection
				PreparedStatement stmt = conn.prepareStatement(query);
			) {
			// Step 3: Execute a SQL SELECT query, the query result
			// is returned in a 'ResultSet' object.
			
			System.out.println("The SQL query is: " + query); // Echo For debugging
			System.out.println();

			ResultSet rset = stmt.executeQuery();

			// Step 4: Process the ResultSet by scrolling the cursor forward via next().
			// For each row, retrieve the contents of the cells with getXxx(columnName).
			System.out.println("The records selected are:");
			int rowCount = 0;
			while (rset.next()) { // Move the cursor to the next row, return false if no more row
				Orders order = new Orders();
				order.setID(rset.getInt("ID") ); 
			    order.setOrders_Date(rset.getDate("Orders_Date"));
			    order.setBill(rset.getInt("Bill"));
			    System.out.println(order);
				++rowCount;
			}
			System.out.println("Total number of records = " + rowCount);
	
	}
	catch (SQLException ex) {
			ex.printStackTrace();
		}
		// Step 5: Close the resources - Done automatically by try-with-resources
	}
	
}
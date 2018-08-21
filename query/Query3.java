package query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import databaseConnection.GetConnection;
public class Query3 implements Query{
	String query;
	public Query3(String query) {
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
		 int count = stmt.executeUpdate(query);
	         System.out.print("No. Of Updated Records " + count);
       }	  
	catch (SQLException ex) {
		ex.printStackTrace();
	}
	// Step 5: Close the resources - Done automatically by try-with-resources
}


      
}

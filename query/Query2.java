package query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import databaseConnection.GetConnection;
public class Query2 implements Query{
	String query;
	
	public Query2(String query) {
		this.query = query;
	}
	
	public void executeQuery() {
		try (
				// Step 1: Allocate a database 'Connection' object
				Connection conn = GetConnection.getConnection();
				// In MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"

				// Step 2: Allocate a 'Statement' object in the Connection
				PreparedStatement stmt = conn.prepareStatement(query);) {
			try {
				conn.setAutoCommit(false);
				System.out.println("The SQL query is: " + query); // Echo For debugging
				System.out.println();

				for (int i = 1; i <= 1 ; i++) {
					stmt.setInt(1,343);
					stmt.setInt(2,34);;
					stmt.setString(3,"'E:\\dbms:\\image.jpeg'");
					stmt.addBatch();
				}

				int[] result = stmt.executeBatch();
				System.out.println("The number of rows inserted: " + result.length);
				conn.commit();
			} 
			catch (SQLException ex) {
				ex.printStackTrace();
				conn.rollback();
			}
		}
		// Step 5: Close the resources - Done automatically by try-with-resources
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

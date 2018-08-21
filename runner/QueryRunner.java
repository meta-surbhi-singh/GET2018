package runner;
import query.*;

public class QueryRunner {

	public static void main(String[] args) {
		new Query1("\r\n" + 
				"SELECT O.ID, O.Orders_Date, O.bill\r\n" + 
				"FROM ORDERS O\r\n" + 
				"JOIN USER U\r\n" + 
				"ON O.Shopper_ID = U.ShopperID \r\n" + 
				"WHERE O.Status = 'PLACED';\r\n" + 
				"\r\n;").executeQuery();
		System.out.println("**********************************************");
		
		new Query2("\r\n" + "INSERT INTO PRODUCT_IMAGE VALUES(?,?,?)").executeQuery();
		System.out.println("**********************************************");
		
		new Query3("UPDATE PRODUCT\r\n" + 
				"SET Product_status = 'INACTIVE'\r\n" + 
				"WHERE ID \r\n" + 
				"NOT IN (\r\n" + 
				"SELECT PO.Product_ID\r\n" + 
				" FROM  PRODUCT_ORDERS PO\r\n" + 
				" JOIN ORDERS O\r\n" + 
				" ON PO.Order_ID = O.ID\r\n" + 
				" WHERE YEAR(O.Orders_Date) >= YEAR(CURDATE()))").executeQuery();
		System.out.println("\n**********************************************");
		
		new Query4("SELECT t.Parent_Name, COUNT(t.Child_Id) AS Total_Childs\r\n" + 
				"FROM (SELECT c1.ID AS Child_Id, c1.Title AS Child_Name, c2.ID AS Parent_Id, c2.Title as Parent_Name\r\n" + 
				"      FROM CATEGORY c1\r\n" + 
				"      JOIN CATEGORY c2 \r\n" + 
				"      ON c1.Parent_ID = c2.ID) as t\r\n" + 
				"      WHERE t.Parent_Id IN (Select ID\r\n" + 
				"                            FROM CATEGORY\r\n" + 
				"                            WHERE Parent_ID IS NULL)\r\n" + 
				"                        \r\n" + 
				"GROUP BY t.Parent_ID\r\n" + 
				"ORDER BY t.Parent_Name;").executeQuery();
		System.out.println("**********************************************");
		
	}
}

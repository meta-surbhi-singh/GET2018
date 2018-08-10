package testClasses;
import employeeCollection.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class EmployeeCollectionTest {

	@Test
	public void testAddEmployee() {
		EmployeeCollection ec = new EmployeeCollection();
		boolean actual = ec.addEmployee(new Employee(1,"John", "Jaipur"));
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testNegativeAddEmployee() {
		EmployeeCollection ec = new EmployeeCollection();
		ec.addEmployee(new Employee(1,"John", "Jaipur"));
		boolean actual = ec.addEmployee(new Employee(1,"Robert", "Udaipur"));
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSortByID() {
		EmployeeCollection ec = new EmployeeCollection();
		ec.addEmployee(new Employee(1,"John", "Jaipur"));
		ec.addEmployee(new Employee(10,"Robert", "Udaipur"));
		ec.addEmployee(new Employee(2,"Susan", "Lucknow"));
		ec.addEmployee(new Employee(34,"Neelam", "Delhi"));
		ec.addEmployee(new Employee(6,"Sundar", "Jodhpur"));
		ec.addEmployee(new Employee(5,"Jagat", "Dubai"));
		ec.sortByID();
		String[] expected = {("ID : 1, NAME : John, ADDRESS : Jaipur"),("ID : 2, NAME : Susan, ADDRESS : Lucknow"),("ID : 5, NAME : Jagat, ADDRESS : Dubai"),("ID : 6, NAME : Sundar, ADDRESS : Jodhpur"),("ID : 10, NAME : Robert, ADDRESS : Udaipur"),("ID : 34, NAME : Neelam, ADDRESS : Delhi")};
		String[] actual = ec.getAllEmployeeInfo();
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testSortByName() {
		EmployeeCollection ec = new EmployeeCollection();
		ec.addEmployee(new Employee(1,"John", "Jaipur"));
		ec.addEmployee(new Employee(10,"Robert", "Udaipur"));
		ec.addEmployee(new Employee(2,"Susan", "Lucknow"));
		ec.addEmployee(new Employee(34,"Neelam", "Delhi"));
		ec.addEmployee(new Employee(6,"Sundar", "Jodhpur"));
		ec.addEmployee(new Employee(5,"Jagat", "Dubai"));
		ec.sortByName();
		String[] expected = {("ID : 5, NAME : Jagat, ADDRESS : Dubai"),("ID : 1, NAME : John, ADDRESS : Jaipur"),("ID : 34, NAME : Neelam, ADDRESS : Delhi"),("ID : 10, NAME : Robert, ADDRESS : Udaipur"),("ID : 6, NAME : Sundar, ADDRESS : Jodhpur"),("ID : 2, NAME : Susan, ADDRESS : Lucknow")};
		String[] actual = ec.getAllEmployeeInfo();
		assertArrayEquals(expected, actual);
		}

}
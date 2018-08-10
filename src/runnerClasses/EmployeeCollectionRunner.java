package runnerClasses;
import employeeCollection.*;

public class EmployeeCollectionRunner {
	static EmployeeCollection ec = new EmployeeCollection();
	 
	public static void main(String args[]) {
		ec.addEmployee(new Employee(1,"John", "Jaipur"));
		ec.addEmployee(new Employee(10,"Robert", "Udaipur"));
		ec.addEmployee(new Employee(2,"Susan", "Lucknow"));
		ec.addEmployee(new Employee(34,"Neelam", "Delhi"));
		ec.addEmployee(new Employee(6,"Sundar", "Jodhpur"));
		ec.addEmployee(new Employee(5,"Jagat", "Dubai"));
		ec.display();
		ec.sortByName();
		System.out.println("");
		System.out.println("****Sorted By NAME*****");
		ec.display();
		System.out.println("");
		ec.sortByID();
		System.out.println("*****Sorted By ID*****");
		ec.display();
	}

}

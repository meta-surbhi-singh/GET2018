package employeeCollection;
import java.util.*;
/**
 * collection of employees
 * @author Surbhi singh
 *
 */
public class EmployeeCollection {
	public List<Employee> employeeList = new ArrayList<Employee>();
	
	/**
	 * add employee in the employeeList
	 * @param emp is the Employee type object to be added
	 * @return true if element is added in the list, else false.
	 */
	public boolean addEmployee(Employee emp) {
		for (Employee employee : employeeList) {
			if(employee.getEmpId() == emp.getEmpId()) {
				return false; //duplicate empID
			}
		}
		employeeList.add(emp);
		return true;
	}
	
	/**
	 * sorts the employee collection according to their ID
	 */
	public void sortByID() {
		Collections.sort(employeeList);
	}
	
	/**
	 * sorts the employee collection according to their Name
	 */
	public void sortByName() {
		Collections.sort(employeeList,new EmployeeNameComparator());
	}
	
	/**
	 * display the employee 
	 * @return 
	 */
	public String[] getAllEmployeeInfo() {
		String[] employeeInfo = new String[employeeList.size()];
		
		for (int index = 0; index < employeeList.size(); index++) {
			employeeInfo [index] = employeeList.get(index).toString();
		}
		return employeeInfo;
		}

	public void display() {
		for(Employee employee : employeeList) {
			System.out.println(employee);
			System.out.println("");
		}
	}
}

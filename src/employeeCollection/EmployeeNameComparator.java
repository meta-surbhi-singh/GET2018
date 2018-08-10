package employeeCollection;

import java.util.Comparator;
/**
 * This is Comparator class which is used to compare list of comparable objects , i.e., Employee here.
 * @author Surbhi Singh
 *
 */
public class EmployeeNameComparator implements Comparator<Employee>{
	
	/**
	 * overriden compare method so as to compare two employee based on their names.
	 */
	@Override
	public int compare(Employee emp1, Employee emp2) {	
		return emp1.getName().compareTo(emp2.getName());
	}
}

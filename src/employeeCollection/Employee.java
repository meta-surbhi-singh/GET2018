package employeeCollection;

/**
 * class to hold information of an employee.
 * Employee Object is an Comparable type object.
 * @author Surbhi singh
 *
 */
public class Employee implements Comparable<Employee>{
	private final int empId;
	private static int noOfEmployee;
	private String name;
	private String address;

	/**
	 * Constructor to initialise Employee information
	 * @param empId : ID of employee
	 * @param name : name of employee
	 * @param address : address of employee
	 */
	public Employee(int empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
		noOfEmployee++;
	}
	
    /**
     * Getter for employee ID
     */
	public int getEmpId() {
		return empId;
	}
	
	 /**
     * Getter for employee name
     */
	public String getName() {
		return name;
	}
	
	 /**
     * Getter for employee address
     */
	public String getAddress() {
		return address;
	}

	/**
     * Setter for employee address
     */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * overridden method toString() to customised the information of an employee
	 * @return information of the employee
	 */
	@Override
	public String toString() {
		return "ID : " + empId+ ", NAME : " + name  + ", ADDRESS : " + address;	
	}

	/**
	 * overridden method compareTo() so as to compare two employees according to their Id
	 * @return 1, if this employee ID is greater than the parameter employee , -1 if smaller and 0 if equal.
	 */
	@Override
	public int compareTo(Employee emp) {
		if(empId > emp.empId) {
			return 1;
		}
		else if (empId < emp.empId) {
			return -1;
		}
		else {
			return 0;
		}
	}


}

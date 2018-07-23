import java.util.InputMismatchException;
import java.util.Scanner;

public class Marksheet {
Scanner sc;
int noOfStudents;
float studentGrades[];
static float passingMarks=40;
/*
 * Constructor takes input from user for no of students and creates a grade array to store grades of students 
 */
public Marksheet() throws MarksInvalidException
{   
	sc=new Scanner(System.in);
	System.out.println("Enter no of students whose grades will be entered");
	noOfStudents=sc.nextInt();
    studentGrades= new float[noOfStudents];
	getGrades();
}
/*
 * Assume noOfStudents as a positive integer
 * Assume studentGrade value between 0 to 100 and in floating point upto two decimal points
 * Takes user input for the grades of all student
 * @throws InputMismatchException if any other type than float is entered
 * @throws MarksInvalidException if marks less than 0 or more than 100 is entered
 */
public void getGrades() throws InputMismatchException,MarksInvalidException
{   float marks;
	System.out.println("Enter Grades (Between 0 to 100 inclusive)of "+ noOfStudents +" Students in floating point upto two decimal points..");
	for (int i = 0; i < studentGrades.length; i++)
	{
	System.out.print("Student "+ (i+1) + " : " );
	marks=sc.nextFloat();
	if(marks>=0 && marks<=100)
	{
		studentGrades[i]=marks;
	}
	else
		throw new MarksInvalidException("Enter Grades (Between 0 to 100 inclusive) ");
	}
}
/*
 * Display the stored grades of all students which were entered by user
 */
public void displayGrades()
{   System.out.println("Grades of "+ noOfStudents +" Students");
	for (int i = 0; i < studentGrades.length; i++)
	{
		System.out.print(" Grades of Student "+ (i+1) + " : " );
		System.out.println(studentGrades[i]);	
	}
}

/*
 * Calculates the average of grades of all student grades
 * @return a float variable that is average of all grades
 */
public float averageOfGrades() throws ArithmeticException
{   float sumOfGrades=0.0f;
	for(int i=0;i<noOfStudents;i++)
	{  
		sumOfGrades+= studentGrades[i];
	}
	return sumOfGrades/noOfStudents;
}

/*
 *  Calculates maximum grade out of all grade 
 * @return a float variable that is maximum of all grades
 */
public float maximumOfGrades() throws ArithmeticException
{
	float maximum=0;
	for(int i=0;i<noOfStudents;i++)
	{
		if(studentGrades[i]>maximum)
		{
			maximum=studentGrades[i];
		}
	}
    return maximum;	
}

/*
 * Calculates minimum grade out of all grades 
 * @return a float variable that is minimum of all grades
 */
public float minimumOfGrades() throws ArithmeticException
{
	float minimum=100;
	for(int i=0;i<noOfStudents;i++)
	{
		if(studentGrades[i]<minimum)
		{
			minimum=studentGrades[i];
		}
	}
    return minimum;
}

/*
 * percentagePassStudent() method calculates the percentage of students passed
 * @return a float variable that represents the percentage of students passed
 */
public float percentagePassStudent() throws ArithmeticException
{   float noOfPassStudents=0;
	for (int i=0; i<noOfStudents;i++)
	{
		if(studentGrades[i]>=passingMarks)
		{
			noOfPassStudents++;
		}
	}
	return (noOfPassStudents/noOfStudents)*100;
}

public static void main(String args[])
{   try {
	      Marksheet marksheet=new Marksheet();
	      System.out.println("The Average grades of students is " + marksheet.averageOfGrades());
	      System.out.println("The minimum grade scored is " + marksheet.minimumOfGrades());
	      System.out.println("The maximum grade scored is " + marksheet.maximumOfGrades());
	      System.out.println("The percentage of students who passed is " + marksheet.percentagePassStudent() + " % ");
         }
    catch(MarksInvalidException mie)
        { 
    	  System.out.println("INVALID MARKS ENTERED!");
        }
    catch(InputMismatchException imm)
        {
    	  System.out.println("Please enter floating point value");
        }
    catch(ArithmeticException ae)
        {
    	  System.out.println("Arithmetic exception has occured");
        }
    	
}

}


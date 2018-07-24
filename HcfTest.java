import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import java.util.InputMismatchException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class HcfTest {
	private Mathematical tester; 
    private int firstNumber;
    private int secondNumber;
    private int expectedResult;
    
    @Before
    public void initialize()
    {
    	  tester = new Mathematical(); 
    }
    public HcfTest(int expectedResult,int firstNumber,int secondNumber)
    {   super();
    	this.expectedResult=expectedResult;
    	this.firstNumber=firstNumber;
    	this.secondNumber=secondNumber;
    }
    
    @Parameterized.Parameters
    public static Collection linearTest() {
      
       return Arrays.asList(new Object[][] {
    	 {2,10,12},
		 {5,10,15} 
       });
    }
   

	@Test
    public void test_HCFOperation() 
	{
		System.out.println("HCF of " + firstNumber + " and " + secondNumber + " is " + expectedResult);
	    assertEquals(expectedResult, tester.computeHCF(firstNumber,secondNumber));
    }
    

	
}   
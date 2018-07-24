import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MaxMirrorTest {
	private ArrOperation  tester; 
    private int []array;
    private int expectedResult;
    @Before
    public void initialize()
    {
    	  tester = new ArrOperation(); 
    }
    public MaxMirrorTest(int expectedResult,int []array)
    {   super();
    	this.array=array;
    	this.expectedResult=expectedResult;
    }
    
    @Parameterized.Parameters
    public static Collection countClumpsOperationTest() {
        
       return Arrays.asList(new Object[][] {
    	 {2, new int [] {7, 1, 4, 9, 7, 4, 1}},
		 {3, new int [] {1, 2, 3, 8, 9, 3, 2, 1}},
		 {3, new int [] {1, 2, 1, 4}},
		 {7, new int [] {1, 4, 5, 3, 5, 4, 1}}
		 
       });
    }
    
	@Test
    public void test_maxMirrorOperation() 
	{   System.out.println("The length of maximum mirror section : " + expectedResult);
	    assertEquals(expectedResult, tester.maxMirror(array));
    }
    
	@Test(expected=AssertionError.class)
	public void expectionTest_countClumpsOperation() 
	{
		tester.maxMirror(new int[] {});
	}
}   

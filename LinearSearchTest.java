import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LinearSearchTest {
	private Search tester; 
    private int []array;
    private int expectedResult;
    private int element;
    
    @Before
    public void initialize()
    {
    	  tester = new Search(); 
    }
    public LinearSearchTest(int expectedResult,int []array,int element)
    {   super();
        this.element=element;
    	this.array=array;
    	this.expectedResult=expectedResult;
    }
    
    @Parameterized.Parameters
    public static Collection linearTest() {
        
       return Arrays.asList(new Object[][] {
    	 {3, new int [] {34,55,4,10,32,23},10},
		 {0, new int [] {2,6,9,8,4,5,8},2},
		 {4, new int [] {1,1,1,1,1},1},
		 {5, new int [] {3,6,7,9,4,8},8}
		 
       });
    }
   

	@Test
    public void test_linearSearchOperation() 
	{
		System.out.println("The element is find at the index " + expectedResult);
	    assertEquals(expectedResult, tester.linearSearch(array,0,array.length-1,element));
    }
    
	@Test(expected=AssertionError.class)
	public void expectionTest_LinearSearchOperation() 
	{
		tester.linearSearch(new int[] {},0,0,element);
	}
}   
import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BinarySearchTest {
	private Search tester; 
    private int []array;
    private int expectedResult;
    private int element;
    
    @Before
    public void initialize()
    {
    	  tester = new Search(); 
    }
    public BinarySearchTest(int expectedResult,int []array,int element)
    {   super();
        this.element=element;
    	this.array=array;
    	this.expectedResult=expectedResult;
    }
    
    @Parameterized.Parameters
    public static Collection linearTest() {
        
       return Arrays.asList(new Object[][] {
    	 {3, new int [] {3,4,5,10,13,15,18,22},10},
		 {0, new int [] {2,6,7,8,9},2},
		 {4, new int [] {25,76,77,88,90,94},90},
		 {5, new int [] {1,2,3,5,7,8,10},8}
		 
       });
    }
   

	@Test
    public void test_binarySearchOperation() 
	{
		System.out.println("The element is find at the index " + expectedResult);
	    assertEquals(expectedResult, tester.linearSearch(array,0,array.length-1,element));
    }
    
	@Test(expected=AssertionError.class)
	public void expectionTest_binarySearchOperation() 
	{
		tester.binarySearch(new int[] {},0,0,element);
	}
}   
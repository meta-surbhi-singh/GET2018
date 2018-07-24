import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SplitArrayTest {
	private ArrOperation  tester; 
    private int []array;
    private int expectedResult;
    @Before
    public void initialize()
    {
    	  tester = new ArrOperation(); 
    }
    public SplitArrayTest(int expectedResult,int []array)
    {   super();
    	this.array=array;
    	this.expectedResult=expectedResult;
    }
    
    @Parameterized.Parameters
    public static Collection splitArrayOperationTest() {
        
       return Arrays.asList(new Object[][] {
    	   {3,new int[] {1,1,1,2,1}},
    	   {-1,new int[] {2,1,1,2,1}},
    	   {1,new int[] {10,10}}
       });
    }
    
	@Test
    public void test_splitArrayOperation() 
	{   System.out.println("split is at index : "+ expectedResult);
	    assertEquals(expectedResult, tester.splitArray(array));
    }
	
	@Test(expected=AssertionError.class)
	public void expectionTest_countClumpsOperation() 
	{
		tester.splitArray(new int[] {});
	}
}

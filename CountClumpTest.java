import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CountClumpTest {
    private ArrOperation  tester; 
    private int []array;
    private int expectedResult;
    @Before
    public void initialize()
    {
    	  tester = new ArrOperation(); 
    }
    public CountClumpTest(int expectedResult,int []array)
    {   super();
    	this.array=array;
    	this.expectedResult=expectedResult;
    }
    
    @Parameterized.Parameters
    public static Collection countClumpsOperationTest() {
        
       return Arrays.asList(new Object[][] {
    	   {2,new int[] {1,2,2,3,4,4}},
    	   {3,new int[] {1,1,2,2,3,3}},
    	   {1,new int[] {1,1,1,1,1}},
    	   {2,new int[] {1,1,2,1,1}},
    	   {0,new int[] {1,2,3,4}}
       });
    
    }
	
	@Test
   public void test_countClumpsOperation() 
   {
	System.out.println("No. of Clumps : "+ expectedResult);
	assertEquals(expectedResult,tester.countClumps(array));
   }
   
	@Test(expected=AssertionError.class)
	public void expectionTest_countClumpsOperation() 
	{
		tester.countClumps(new int[] {});
	}
}	
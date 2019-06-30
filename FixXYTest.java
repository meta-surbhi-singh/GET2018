import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FixXYTest {
	private ArrOperation  tester; 
    private int []array;
    private int []expectedArray;
    @Before
    public void initialize()
    {
    	  tester = new ArrOperation(); 
    }
    public FixXYTest(int []expectedArray,int []array)
    {   super();
    	this.array=array;
    	this.expectedArray=expectedArray;
    }
    
    @Parameterized.Parameters
    public static Collection countClumpsOperationTest() {
        
       return Arrays.asList(new Object[][] {
    	   {new int []{9, 4, 5, 4, 5, 9},new int [] {5, 4, 9, 4, 9, 5}},
    	   {new int[] {1, 4, 5, 1}, new int [] {1, 4, 1, 5}},
    	   {new int[] {1, 4, 5, 1, 1, 4, 5}, new int [] {1, 4, 1, 5, 5, 4, 1}}
       });
    }
    
	@Test
    public void test_fixXYOperation() {
		   System.out.println("The Fixed XY array");
		   for (int k = 0; k < array.length; k++) {
		   System.out.println(array[k]);
			}
		   System.out.println("  ");
		   assertArrayEquals(expectedArray, tester.fixXY(array));
    }
	@Test(expected=AssertionError.class)
	public void expectionTest_countClumpsOperation() 
	{
		tester.fixXY(new int[] {});
	} 
}


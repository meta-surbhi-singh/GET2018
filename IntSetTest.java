import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class IntSetTest {
    
    	IntSet intSet=new IntSet(new int[] {400,543,678,900});
    	IntSet intSet1=new IntSet(new int[] {220,566,343,323,666,529,900});
    	IntSet intSet2=new IntSet(new int[] {566,343,323,666,529,900});
    	
	@Test
	public void isMember_test() 
	{
		assertEquals(true,intSet.isMember(400));
		assertEquals(true,intSet1.isMember(900));
		assertEquals(false,intSet2.isMember(342));
	
	}
    
	@Test
	public void isSubSet_test()
	{
		assertEquals(false,intSet.isSubSet(intSet1));
		assertEquals(true,intSet2.isSubSet(intSet2));
		assertEquals(false,intSet.isSubSet(intSet2));
	}
	@Test
	public void getComplement_test()
	{
		 assertArrayEquals(new int[] {220,435,554,409,435,863,564,598,553},intSet.getComplement());
	     assertArrayEquals(new int[] {435,554,678,409,435,863,564,598,553 },intSet1.getComplement());
		
	}
	
	public void union()
	{
		assertArrayEquals(new int[] {220,566,343,323,666,529,900,666,529,900},intSet.union(intSet1,intSet2));
		assertArrayEquals(new int[] {400,543,678,900},intSet1.union(intSet,intSet2));
		assertArrayEquals(new int[] {400,543,678,900},intSet2.union(intSet,intSet1));
		
	}
}

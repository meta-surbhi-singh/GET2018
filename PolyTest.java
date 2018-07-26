import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PolyTest {

    	Poly p=new Poly(new int[]{1,1}, new int[]{1,0});;
    	Poly p1=new Poly(new int[]{2,-1,1}, new int[]{2,1,0});		
    	Poly p2=new Poly(new int[] {5,6,9,2},new int[] {8,3,2,1});		
	
	@Test
	public void evaluate_test() 
	{
		assertEquals(4.0, p.evaluate(3), 0.00);
		assertEquals(7.0, p1.evaluate(2), 0.00);
		assertEquals(22.0, p2.evaluate(1), 0.00);
	}

	@Test
	public void  addPoly_test() 
	{  
		assertArrayEquals(new int[] {5,6,9,2,2,-1,1}, p1.addPoly(p1, p2).getCoefficients());
		assertArrayEquals(new int[] {8,3,2,2,1,1,0}, p1.addPoly(p1, p2).getPowers());
		assertArrayEquals(new int[] {2,-1,1,1,1}, p.addPoly(p, p1).getCoefficients());
		assertArrayEquals(new int[] {2,1,1,0,0}, p.addPoly(p, p1).getPowers());
	}
	
	@Test
	public void multiplyPoly()
	{
		assertArrayEquals(new int[] {10,12,18,4,-5,-6,-9,-2,5,6,9,2}, p1.multiplyPoly(p1, p2).getCoefficients());
		assertArrayEquals(new int[] {10,5,4,3,9,4,3,2,8,3,2,1}, p1.multiplyPoly(p1, p2).getPowers());
		assertArrayEquals(new int[] {2,-1,1,2,-1,1}, p.multiplyPoly(p, p1).getCoefficients());
		assertArrayEquals(new int[] {3,2,1,2,1,0}, p.multiplyPoly(p, p1).getPowers());
	}
	
}

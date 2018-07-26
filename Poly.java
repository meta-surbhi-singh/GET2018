
public final class Poly {
private final int[] coefficients;
private final int[] power;

/*Initializes Polynomial with its coefficients and power
 *@param coefficient array containing non-zero values only
 *@param power array containing only positive values
 */
public Poly(int[]cf, int[]p)
{   if(cf.length!=p.length) 
    {
	  throw new AssertionError();
    }
    for (int index = 0; index < p.length; index++) 
    {
    	if(p[index] < 0 ||cf[index]==0)
    	{
    		throw new AssertionError();
    	}
    }
    
	this.coefficients=cf;
	this.power=p;
}

/*
 * @return the coefficient array of a polynomial
 */
 public int[] getCoefficients()
 {   int [] coefficientsArray =new int [coefficients.length];
     for(int index = 0; index < coefficients.length ; index++)
     {
    	coefficientsArray[index] = coefficients[index]; 
     }
	 return coefficientsArray;
 }

 /*
  * @returns the power array of a polynomial
  */
 public int[] getPowers()
 {   int [] powersArray =new int [power.length];
     for(int index = 0; index < power.length ; index++)
     {
    	powersArray[index] = power[index]; 
     }
	 return powersArray;
 }

 /*
  * evaluates the value of the polynomial for a given variable value
  * @param float value is the variable value
  * @return float evaluated result
  */
public float evaluate(float value) 
{
	float result=0f;
	for (int index = 0; index < coefficients.length; index++) {
		result+=coefficients[index]*powerOf(value,power[index]);
	}
	return result;
}

/* 
 * it is a helper method
 * @param value of variable in polynomial 
 * @param power- the expontential power of variable
 * @return the calculated value to the power in float
 */
private float powerOf(float value,int power)
{
	return (float)Math.pow(value, power);
}

/*
 * degree of a polynomial is the highest power of the variable in it.
 * @return the degree of polynomial
*/
public int degree()
{
    int maxPower=0;
    for(int index = 0; index < power.length; index++)
    {
    	if( power[index] > maxPower)
    	{
    		maxPower=power[index];
    	}
    }
	return maxPower;
}

/*
 * add two polynomials
 * @param first polynomial Poly type
 * @param second polynomial Poly type
 * @return the sumPoly addition polynomial - Poly type
 */
public Poly addPoly(Poly p1, Poly p2) 
{   
	Poly sumPoly;
    int []sumCoefficients=new int [p1.coefficients.length+p2.coefficients.length];
    int []sumPower=new int[p1.power.length+p2.power.length];
  
    for (int index_p1 = 0 ,k = 0, index_p2 = 0 ; index_p1 < p1.power.length || index_p2 < p2.power.length && k < sumPower.length; k++) 
    {    if(index_p1>=p1.power.length )
         {
    	  sumPower[k]=p2.power[index_p2];
    	  sumCoefficients[k]=p2.coefficients[index_p2];
       	  index_p2++;
         }
         else if(index_p2>=p2.power.length )
         {   
        	 sumPower[k]=p1.power[index_p1];
             sumCoefficients[k]=p1.coefficients[index_p1];
        	 index_p1++; 
         }
         else if(p2.power[index_p2]>=p1.power[index_p1])
         {
        	 sumPower[k]=p2.power[index_p2];
       	      sumCoefficients[k]=p2.coefficients[index_p2];
          	  index_p2++;
         }
         else if( p1.power[index_p1]>=p2.power[index_p2])
         {
          sumPower[k]=p1.power[index_p1];
          sumCoefficients[k]=p1.coefficients[index_p1];
     	  index_p1++;
         }
          else
          {
        	   sumPower[k]=p1.power[index_p1];
        	   sumCoefficients[k]=p1.coefficients[index_p1]+p2.coefficients[index_p2];
        	   index_p1++;
        	   index_p2++;
          }
    }

    sumPoly=new Poly(sumCoefficients, sumPower);
    
	return sumPoly;
}

public void display(Poly p)
{
  for (int index = 0; index < p.coefficients.length; index++) {
	System.out.print(p.coefficients[index] + "x^" + p.power[index] + " + ");
}	
  System.out.println("\n");
}

/*
 * multiply two polynomials
 * @param first polynomial Poly type
 * @param second polynomial Poly type
 * @return the product Poly addition polynomial - Poly type
 */
public Poly multiplyPoly(Poly p1, Poly p2)
{   Poly productPoly;
    int []productCoefficients=new int [p1.coefficients.length *p2.coefficients.length];
    int []productPower=new int[p1.power.length*p2.power.length];
    
    for (int index_p1 = 0, index_mult = 0; index_p1 < p1.power.length; index_p1++) {
		for (int index_p2 = 0 ; index_p2 < p2.power.length; index_p2++) {
		productPower[index_mult]=p1.power[index_p1]+p2.power[index_p2];
		productCoefficients[index_mult]=p1.coefficients[index_p1]*p2.coefficients[index_p2];
		index_mult++;
		}
	}  
    productPoly=new Poly(productCoefficients, productPower);
	return productPoly;
}

public static void main(String args[])
{
	Poly p=new Poly(new int[]{1,1}, new int[]{1,0});
	Poly p1=new Poly(new int[]{2,-1,1}, new int[]{2,1,0});
	Poly p2=new Poly(new int[]{5,6,9,2}, new int[]{8,3,2,1});
	System.out.println("p matrix");
	p.display(p);
	System.out.println("\np1 matrix");
	p1.display(p1);
	System.out.println("\np2 matrix");
	p2.display(p2);
	System.out.println(" ");
	System.out.println("VALUE OF P when x is 3 is " + p.evaluate(3));
	System.out.println("Value of p1 when x is 2 is " + p1.evaluate(2));
	System.out.println("Value of p2 when x is 1 is " + p2.evaluate(1));
	System.out.println("\nMultiplication value of p1 and p2 ");
	p.display(p.multiplyPoly(p1, p2));
	System.out.println("\nMultiplication value of p and p1 ");
	p.display(p.multiplyPoly(p, p1));
	System.out.println("\nAddition value of p1 and p2 ");
	p.display(p.addPoly(p1, p2));
	System.out.println("\nAddition value of p and p1 ");
	p.display(p.addPoly(p, p1));
}

}
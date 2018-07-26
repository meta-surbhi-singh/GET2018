
public final class Poly {
private final int[] coefficients;
private final int[] power;

public Poly() {
	this.coefficients=new int[] {};
	this.power=new int[] {};
}

public Poly(int[]cf, int[]p)
{   if(cf.length!=p.length) 
    {
	  throw new AssertionError();
    }
    for (int index = 0; index < p.length; index++) 
    {
    	if(p[index] < 0)
    	{
    		throw new AssertionError();
    	}
    }
    
	this.coefficients=cf;
	this.power=p;
}
 public int[] getCoefficients()
 {   int [] coefficientsArray =new int [coefficients.length];
     for(int index = 0; index < coefficients.length ; index++)
     {
    	coefficientsArray[index] = coefficients[index]; 
     }
	 return coefficientsArray;
 }

 public int[] getPowers()
 {   int [] powersArray =new int [power.length];
     for(int index = 0; index < power.length ; index++)
     {
    	powersArray[index] = power[index]; 
     }
	 return powersArray;
 }
 
public float evaluate(float value) 
{
	float result=0f;
	for (int i = 0; i < coefficients.length; i++) {
		result+=coefficients[i]*powerOf(value,power[i]);
	}
	return result;
}

public float powerOf(float value,int power)
{
	return (float)Math.pow(value, power);
}
public int degree()
{   int degree=power[0];
	return degree;
}


public Poly addPoly(Poly p1, Poly p2) 
{   
	Poly sumPoly;
    int []sumCoefficients=new int [p1.coefficients.length+p2.coefficients.length];
    int []sumPower=new int[p1.power.length+p2.power.length];
  
    for (int i = 0 ,k = 0, j = 0 ; i < p1.power.length || j < p2.power.length && k < sumPower.length; k++) 
    {    if(i>=p1.power.length )
         {
    	  sumPower[k]=p2.power[j];
    	  sumCoefficients[k]=p2.coefficients[j];
       	  j++;
         }
         else if(j>=p2.power.length )
         {   
        	 sumPower[k]=p1.power[i];
             sumCoefficients[k]=p1.coefficients[i];
        	 i++; 
         }
         else if(p2.power[j]>=p1.power[i])
         {
        	 sumPower[k]=p2.power[j];
       	      sumCoefficients[k]=p2.coefficients[j];
          	  j++;
         }
         else if( p1.power[i]>=p2.power[j])
         {
          sumPower[k]=p1.power[i];
          sumCoefficients[k]=p1.coefficients[i];
     	  i++;
         }
          else
          {
        	   sumPower[k]=p1.power[i];
        	   sumCoefficients[k]=p1.coefficients[i]+p2.coefficients[j];
        	   i++;
        	   j++;
          }
    }

    sumPoly=new Poly(sumCoefficients, sumPower);
    
	return sumPoly;
}

public void display(Poly p)
{
  for (int i = 0; i < p.coefficients.length; i++) {
	System.out.print(p.coefficients[i] + "x^" + p.power[i] + " + ");
}	
  System.out.println("\n");
}


public Poly multiplyPoly(Poly p1, Poly p2)
{   Poly productPoly;
    int []productCoefficients=new int [p1.coefficients.length *p2.coefficients.length];
    int []productPower=new int[p1.power.length*p2.power.length];
    //System.out.println(productCoefficients.length);
    //System.out.println(productPower.length);
    
    for (int i = 0, k = 0; i < p1.power.length; i++) {
		for (int j = 0 ; j < p2.power.length; j++) {
		productPower[k]=p1.power[i]+p2.power[j];
		productCoefficients[k]=p1.coefficients[i]*p2.coefficients[j];
		k++;
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
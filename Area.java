import java.util.InputMismatchException;
import java.util.Scanner;

public class Area {
    double area;
    Scanner sc=new Scanner(System.in);
    /*
     * calculates area of triangle
     */
	public double triangleArea(double base,double height) throws ArithmeticException,NegativeValueException
	{   if(base<0 || height<0)
	    {
		throw new NegativeValueException();
	    }
		area=0.5*base*height;	
		return area;
	}
	
	public double rectangleArea(double length, double width) throws ArithmeticException,NegativeValueException
	{   if(length<0 || width<0)
        {
	     throw new NegativeValueException();
        }
		area=length*width;	
	    return area;
	}
	 
	public double squareArea(double sideLength) throws ArithmeticException,NegativeValueException
	{    if(sideLength<0)
         {
	      throw new NegativeValueException();
         }
		area=sideLength*sideLength;
	    return area;
	}
	
	/*
	 * calculates area of circle
	 */
	public double circleArea(double radius) throws ArithmeticException,NegativeValueException
	{    if(radius<0)
         {
	     throw new NegativeValueException();
         }
		area=3.14*radius*radius;
		return area;
	}
	
	public void userInput() throws InputMismatchException, ArithmeticException, NegativeValueException
	{   double ar;
		int choice;
		while(true)
		{
			System.out.println("\n\n\n ENTER THE CHOICE (AS INTEGER VALUE) OF SHAPE WHOSE AREA YOU WANT TO ENTER..");
			System.out.println("For Triangle.. enter 1");
			System.out.println("For Rectangle.. enter 2");
			System.out.println("For Square.. enter 3");
			System.out.println("For Circle.. enter 4");
			System.out.println("To exit.. enter 5");
			choice=sc.nextInt();
			
			switch(choice)
			{
				case 1:
					{
					System.out.println("Enter base of triangle : ");
					double base=sc.nextFloat();
					System.out.println("Enter height of triangle : ");
					double height=sc.nextFloat();
					ar=triangleArea(base,height);
					System.out.println("Area of Triangle with base as " + base + " units and height as" + height+ " units is " + ar);
					break;
					}
				case 2:
				   {
					System.out.println("Enter width of rectangle : ");
					double length=sc.nextFloat();
					System.out.println("Enter length of rectangle : ");
					double width=sc.nextFloat();
					ar=rectangleArea(length,width);
					System.out.println("Area of rectangle with base as " + length + " units and height as " + width + " units is " + rectangleArea(length,width) + ar);
					break;
				   }
				case 3:
					{
					System.out.println("Enter length of side for square : ");
					float sideLength=sc.nextFloat();
					ar=squareArea(sideLength);
					System.out.println("Area of square with length of side as "+ sideLength +" units is " + ar );
					break;
					}
				case 4:
				   {
					System.out.println("Enter radius of circle : ");
					double radius=sc.nextFloat();
					ar=circleArea(radius);
					System.out.println("Area of circle is with length of side as "+ radius + " units is " +  ar);	
					break;
				   }
				case 5:
					{
						System.exit(0);
					}
				default:
					System.out.println("please enter a valid choice..");
					
	        }//end of switch
       }//end of while
     }  
			
			
	public static void main(String args[])
	{   try {
		Area area=new Area();
		area.userInput();
	    }
	    catch (InputMismatchException ime)
	    {
	    	System.out.println("Please enter integer choice");
	    }
	   catch(NegativeValueException nve)
	   {
		    System.out.println("Negative values not allowed..!!"); 
	   }
	}//end of main method
}//end class area

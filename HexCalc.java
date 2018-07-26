import java.util.Scanner;

public class HexCalc {
	int dec1,dec2;
	static Scanner sc;
	String hexaValue1, hexaValue2;
	/*
	 * constructor HexCalc gets hexadecimal input from user
	 * calls isHexadecimal() method to check if input string is hexadecimal or not
	 * @throws NotHexaDecimaleException if the input is not a hexadcimal value
	 */
	public HexCalc() throws NotHexaDecimalException
	    {
	    	System.out.println("Enter hexadecimal value1 :");
	 	    hexaValue1=sc.next().toUpperCase();
	 	    if(!isHexadecimal(hexaValue1))
	 	    {
	 	    	throw new NotHexaDecimalException();
	 	    }
	   
	 	    System.out.println("Enter hexadecimal value2 :");
	 	    hexaValue2=sc.next().toUpperCase();	 
	 	    if(!isHexadecimal(hexaValue1))
	 	    {
	 	    	throw new NotHexaDecimalException();
	 	    }
	    }
	
	/*
	 * checks if the String hexaValue is hexadecimal or not
	 * Uses java regex to do so
	 * @param String hexaValue ,a string 
	 * @return boolean true if hexaValue is hexadecimal.. and returns false if it is not
	 */
	public boolean isHexadecimal(String hexaValue)
	{   
		String pattern="^[0-9A-Fa-f]+$";
		if(hexaValue.matches(pattern))
		return true;
		else
		return false;
	}
	
	/*
	 * addition of two hexadecimal values by converting them into decimal values and converting the result back into hexadecial
	 * @return the calculated hexadecimal value  
	 */
	public String add()
	{    dec1=toDecimal(hexaValue1);
	     dec2=toDecimal(hexaValue2);
	     return toHexaDecimal(dec1+dec2);
	}
	
	/*
	 * subtracting of two hexadecimal values by converting them into decimal values and converting the result back into hexadecial
	 * @return the calculated hexadecimal value  
	 */
	public String subtract()
	{    dec1=toDecimal(hexaValue1);
         dec2=toDecimal(hexaValue2);
         if(dec1>=dec2)
	 	 return toHexaDecimal(dec1-dec2);
	     else
	     return toHexaDecimal(dec2-dec1);		
	}
	
	/*
	 * multiplying of two hexadecimal values by converting them into decimal values and converting the result back into hexadecial
	 * @return the calculated hexadecimal value  
	 */
	public String multiply()
	{    dec1=toDecimal(hexaValue1);
         dec2=toDecimal(hexaValue2);
		 return toHexaDecimal(dec1*dec2);
	}
	
	/*
	 *dividing of two hexadecimal values by converting them into decimal values and converting the result back into hexadecial
	 * @return the calculated hexadecimal value  
	 */
	public String divide()
	{   dec1=toDecimal(hexaValue1);
        dec2=toDecimal(hexaValue2);
	    return toHexaDecimal(dec1/dec2);
	}
	
	/*
	 * converts decimal values into hexadecimal values
	 * @param int dec is a decimal value
	 * @return converted String hexaDecimal values
	 */
	public String toHexaDecimal(int dec)
	{   int remainder=0;
	    String hexaValue=" ";
	    char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
	    while(dec>0)  
	     {  
	       remainder=dec%16;   
	       hexaValue=hexchars[remainder]+hexaValue;   
	       dec=dec/16;  
	     }  
	    
	    return hexaValue;
	}
	
	/*
	 * converts decimal values into hexadecimal values
	 * @param String hexaDecimal values
	 * @return converted converted String hexaDecimal values
	 */
	public int toDecimal(String hexaValue)
	{  
        int dec=0;
        String digits = "0123456789ABCDEF";  
        hexaValue = hexaValue.toUpperCase();    
        for (int i = 0; i < hexaValue.length(); i++)  
        {  
            char c = hexaValue.charAt(i);  
            int d = digits.indexOf(c);  
            dec = 16*dec + d;  
        }  
        return dec;
	}
	
	/*
	 * checks if two string are equals
	 * @return true, if equal and false, if not equal.
	 */
    public boolean areEqual() 
    {
       if(hexaValue1.equals(hexaValue2))
    	{
           return true;       
    	}
       else
    	{
    	   return false;
    	}
    }
    
    /*
	 * checks for greater string in two strings
	 * @return true, if hexaValue1 is greater than hexavalue2 otherwise, false.
	 */
    public boolean isGreaterThan() 
    {    int compare=hexaValue1.compareTo(hexaValue2);
         if(compare>0)
          {
             return true;       
      	}
         else
      	{
      	   return false;
      	}
    }
    
    /*
	 * checks for lesser string in two strings
	 * @return true, if hexaValue1 is lesser than hexaValue2 otherwise, false.
	 */
    public boolean isLessThan() 
    {  int compare=hexaValue1.compareTo(hexaValue2);
       if(compare<0)
        {
           return true;       
    	}
       else
    	{
    	   return false;
    	}
    }
   
    public static void main(String args[])
    {  try
        {
          sc=new Scanner(System.in);       
          HexCalc hC= new HexCalc();
          System.out.println("\n\nAddition of these hexadecimal no. is " + hC.add());
          System.out.println("Subtraction of these hexadecimal no. is " + hC.subtract());
          System.out.println("Multiplication of these hexadecimal no. is " + hC.multiply());
          System.out.println("Division of these hexadecimal no. is " + hC.divide());
          System.out.println("Stating that these hexadecimal no. are equal to each other is " + hC.areEqual());
          System.out.println("Stating that " + hC.hexaValue1 + " is greater than " + hC.hexaValue2 + " is " + hC.isGreaterThan());
          System.out.println("Stating that " + hC.hexaValue1 + " is less than " + hC.hexaValue2 + " is " + hC.isLessThan());
        }
       catch(NotHexaDecimalException imm)
        {
    	   System.out.println(imm); 	
        }
       
   }
    
}
   
class NotHexaDecimalException extends Exception {
	private static final long serialVersionUID = 1L;
	public NotHexaDecimalException()
	{  System.out.println("Please enter Hexadecimal value");	
	}
}


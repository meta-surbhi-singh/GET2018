
import java.util.Scanner;

public class HexCalc {
	int dec1,dec2;
	static Scanner sc;
	String hexaValue1, hexaValue2;
	public HexCalc() throws NotHexaDecimalException
	    {
	    	System.out.println("Enter hexadecimal value1 :");
	 	    hexaValue1=sc.next();
	 	    System.out.println("Enter hexadecimal value2 :");
	 	    hexaValue2=sc.next();	
	 	   
	 	    
	    }
	public boolean isHexadecimal(String hexaValue)
	{   char hex[]=hexaValue.toCharArray();
	    char charValue;
	    for(int i=0;i<hex.length;i++)
	    {  charValue=Character.forDigit(hex[i],16);
	       if(charValue=='\u0000')
	    	 {
	    	  return false; 
	    	 }
	    } 
		return true;
	}
	public String add()
	{    dec1=toDecimal(hexaValue1);
	     dec2=toDecimal(hexaValue2);
	     return toHexaDecimal(dec1+dec2);
	}
	
	public String subtract()
	{    dec1=toDecimal(hexaValue1);
         dec2=toDecimal(hexaValue2);
         if(dec1>=dec2)
	 	 return toHexaDecimal(dec1-dec2);
	     else
	     return toHexaDecimal(dec2-dec1);		
	}
	
	public String multiply()
	{    dec1=toDecimal(hexaValue1);
         dec2=toDecimal(hexaValue2);
		 return toHexaDecimal(dec1*dec2);
	}
	
	public String divide()
	{   dec1=toDecimal(hexaValue1);
        dec2=toDecimal(hexaValue2);
	    return toHexaDecimal(dec1/dec2);
	}
	
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
	{  System.out.println("Please enter string values consisting of alphanumeric values with alphabets from A to F only");	
	}
}



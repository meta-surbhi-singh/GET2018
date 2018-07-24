import java.util.InputMismatchException;

public class Mathematical 
{  
	public int computeHCF(int firstNumber, int secondNumber)throws AssertionError
	{   int hcf=0;
        int f=firstNumber;
        int s=secondNumber;
        int hold;
        while(s!=0)
        {
        	hold=s;
        	s=f%s;
        	f=hold;
        }
        
        hcf=f;
		return hcf;
	}
	
	public int computeLCM(int firstNumber, int secondNumber) throws AssertionError
	{
		int lcm=(firstNumber*secondNumber)/computeHCF(firstNumber, secondNumber);
		return lcm;
	}
}


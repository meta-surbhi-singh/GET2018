import java.util.InputMismatchException;

public class Mathematical 
{  
	public int computeHCF(int firstNumber, int secondNumber)throws AssertionError
	{   
        int hcf;
		if (secondNumber != 0)
            hcf=computeHCF(secondNumber, firstNumber % secondNumber);
        else
            hcf=firstNumber;
		
        return hcf;
	}
	
	public int computeLCM(int firstNumber, int secondNumber) throws AssertionError
	{
		int lcm=(firstNumber*secondNumber)/computeHCF(firstNumber, secondNumber);
		return lcm;
	}
}


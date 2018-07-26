import java.util.InputMismatchException;
import java.util.Scanner;

public class StringOperations {
static Scanner sc=new Scanner(System.in);

/*
 * Compares two string and check if they are equal or not
 * @param String str1 and String str2 are the two strings to be compared, they are assume to be non-null and case-sensitive   
 * @return int value,1 if they are equal, 0 if they are not
 */
	public int compareEquals(String str1,String str2)
	{   int result=0;
		if(str1.length()==str2.length())
		{
			for(int i=0;i<str1.length();i++)
			{
				if(str1.charAt(i)==str2.charAt(i))
				{
					result++;
				}
			}
		  if(result == str1.length())
		  {
			result=1;
		  }
		}
	return result;
	}

/*
 * Produces a new String which is the reverse of the parameterized String
 * @param String str is the string which to be reversed, it is assumed to be non-null and case-sensititive
 * @return String revstr is the reverse string
 */
public String reverseString(String str)
{   String revStr="";
    for(int i=str.length()-1;i>=0;i--)
    {
    	revStr+=str.charAt(i);
    }
	return revStr;
}
/*
 * Produces new string by replacing its lowercase characters with its corresponding uppercase characters and vice-versa
 * @param the String to be modified
 * @return the modified String
 */
public String lowerUpperCaseSwapped(String str)
{   int upperLowerCaseDiff=32;
    int asciiValue;
    String newStr="";
	for(int i=0;i<str.length();i++)
    {     asciiValue=(int)str.charAt(i);
		if((str.charAt(i)>='A')&&(str.charAt(i)<='Z'))
		   {
			  newStr+=(char)(asciiValue + upperLowerCaseDiff);
		   }
		else if((str.charAt(i)>='a')&&(str.charAt(i)<='z'))
			{
			  newStr+=(char)(asciiValue - upperLowerCaseDiff);
			}
		else
			    newStr+=str.charAt(i);
    }	
return newStr;
}

/*
 * finds out the largest word in the string 
 * @param the String str in which the largest word is to be found
 * @return the String largestWord ,the largest word in the string
 */
public String largestWord(String str )
{ String largestWord = " ";
  int maxLengthWord = 0;
  int lengthOfword;
  int endIndex = str.length();
  int maxEndString = 0;
  int maxStartString = endIndex;

  for(int i=0,startIndex=i; i<str.length(); i++)
	 {   
		  if(str.charAt(i) == ' ' )
		  {   endIndex = i;
			  lengthOfword = endIndex-startIndex;
			  if(lengthOfword>maxLengthWord)
			  {
				  maxLengthWord = lengthOfword;
				  maxStartString = startIndex;
				  maxEndString = endIndex;
				  //System.out.println(maxEndString + "  " + maxStartString);
			  }
			 startIndex=i+1; 
		  }
		  else if(i==str.length()-1)
		  {   //System.out.println(str.charAt(i));
			  endIndex = i;
			  lengthOfword = endIndex-startIndex+1;
			  if(lengthOfword>maxLengthWord)
			  {
				  maxLengthWord = lengthOfword;
				  maxStartString = startIndex;
				  maxEndString = endIndex+1;
				  //System.out.println(maxEndString + "  " + maxStartString);
			  }
		  }
		  else
		  {
			  continue;
		  }
	 }
  
largestWord=str.substring(maxStartString,maxEndString);	
return largestWord;

}
/*
 * Get input from user and validates if it is not null
 * @return non-null String str 
 */
public void validate(String str) throws NullPointerException
{ 
	if(str==null)
    {
    	throw new NullPointerException();
    }
}

/*
 * Interacts with user and call the StringOperation class methods according to choice they entered
 */
public void userInput() throws NullPointerException, InputMismatchException
{
	int choice;
	while(true)
	{
		System.out.println("\n\n\n ENTER YOUR CHOICE OF STRING OPERATIONS..");
		System.out.println("Equality comparison.. enter 1");
		System.out.println("Reversing a String.. enter 2");
		System.out.println("Update lowercase characters into uppercase characters and vice-versa in String.. enter 3");
		System.out.println("Get the largest word in the string.. enter 4");
		System.out.println("To exit.. enter 5");
		choice=sc.nextInt();
		sc.nextLine();
		
		switch(choice)
		{
			case 1:
			{   System.out.println("Enter String 1 : ");
		        String str1=sc.nextLine().trim();
		        validate(str1);
		        System.out.println("Enter String 2 : ");
		        String str2=sc.nextLine().trim();
		        validate(str2);
				if(compareEquals(str1, str2)==1)
					System.out.println("They are equal..!!");
				else
					System.out.println("They are not equal");	
				break;
			}
			
			case 2:
			{    System.out.println("Enter String : ");
	             String str=sc.nextLine().trim();
	             validate(str);
				 System.out.println(reverseString(str));
				 break;
			}
			case 3:
			{   System.out.println("Enter String : ");
                String str=sc .nextLine().trim();
                validate(str);
				System.out.println(lowerUpperCaseSwapped(str));
				break;
			} 
			case 4:
			{   System.out.println("Enter String : ");
			    String str=sc .nextLine().trim(); 
			    validate(str);
			    System.out.println("The largest string in the array is " + largestWord(str));
				break;
			}
			case 5:
			{
				System.exit(0);
			}
			default:
			{
				System.out.println("Please enter valid choice..");
			}
		}//end of switch
	}//end of while
}

public static void main(String args[])
 {  try{
	StringOperations stringOperations=new StringOperations();
	stringOperations.userInput();
 }
 catch(InputMismatchException ime)
 {
	 System.out.println("please enter a valid value.. ");
 }
 }

}
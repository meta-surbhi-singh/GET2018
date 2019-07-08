import java.util.*;
public class Palindrome
{
boolean checkIfPalindrome(String str)
{    Stack<Character> s=new Stack<Character>();
     String reverse= new String();
	
	 
	 for(int i=0;i<str.length(); i++)
		 s.push(str.charAt(i));
	 
	while(!s.isEmpty())
     reverse+=s.pop();

    if(str.equals(reverse))
		return true;
	else
	    return false;
	 
}

public static void main(String args[])
{  Scanner sc=new Scanner(System.in);
   Palindrome p=new Palindrome();
   System.out.println("Enter the string you want to check palindrome or not");
   String st=sc.nextLine();
   if(p.checkIfPalindrome(st))
   System.out.println("The Entered string is palindrome");
   else
   System.out.println("The Entered string is not a palindrome");
}


}

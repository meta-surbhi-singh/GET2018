//import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * class Search is used to search an element from an array
 */
public class Search {
    
    static Scanner sc=new Scanner(System.in);
	/*
	 * linearSearch() method searches sequentially in the array for an element
	 * @param integer array to be searched
	 * @param startIndex is the index at the start of the array
	 * @param endIndex is the index at the end of the array
	 * @param element is the element to be searched in the array
	 * @return the index at which the element is found
	 */
	public int linearSearch(int[] array, int startIndex,int endIndex, int element) throws AssertionError
	{   if(array.length==0) {
		throw new AssertionError();
	     }
		if(endIndex==-1)
		{
	      return -1;
		}
		else if(array[endIndex]!=element)
		{
			return linearSearch(array, startIndex, endIndex-1, element);
		}
		else
			return endIndex;
	}
	
	/*
	 * Array should be sorted
	 * binarySearch() method searches using divide and rule method in the array for an element
	 * if the element to be searched is less than the middle index value,then the first half is searched for, else the other half is searched.
	 * @param integer array to be searched
	 * @param startIndex is the index at the start of the array
	 * @param endIndex is the index at the end of the array
	 * @param element is the element to be searched in the array
	 * @return the index at which the element is found
	 */

	public int binarySearch(int[] array, int startIndex,int endIndex, int element) throws AssertionError
   {   if(array.length==0) {
		throw new AssertionError();
        }
	   int middle=(startIndex+endIndex)/2;
	   
	   if(element==array[middle])
		{
	      return middle;
		}
		else if(element>array[middle])
		{
			return binarySearch(array, middle+1 , endIndex, element);
		}
		else if (element<array[middle])
		{   
			return binarySearch(array, startIndex, middle-1, element);
		}
		else 
			return -1;
		
		
   }

}





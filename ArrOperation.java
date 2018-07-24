/*
 * 
 */
public class ArrOperation {
	
	
	/*
	 * Return an array that contains exactly the same numbers as the input array
	 *  but rearranged so that every X is immediately followed by a Y. 
	 *  X is not moved within array, but every other number may.
	 *  @param the integer array a
	 *  @return integer array with fixed position of XY 
	 *  @throws AssertionError if array is empty,if X is at last index,if two adjacent X values are there and if there unequal of X and Y.
	 */
	public int[] fixXY(int[] a) throws AssertionError
	{  
		int X=4;
		int Y=5;
		
		if(isArrayEmpty(a)||a[a.length-1]==X||twoAdjacent(a,X)||noOf(X,a)!=noOf(Y,a))
	   {
		 throw new AssertionError();
	   }
	   
		int i,j,l;
			
		for( int k=0; k < a.length ; k++)
		{
			if(a[k]==Y)
			{ j=k;
			  for(l=j+1; l<a.length; l++)
			    {if(a[l]==X) 
			      {
				  i=l;//i will store index of X
				  int hold;
					hold=a[i+1];
					a[i+1]=a[j];
					a[j]=hold;
				  break;
			      }
			    }
			}//end of if
			else if(a[k]==X)
			{  i=k;
			   if(a[k+1]==Y)
			   {
				   k++;
				   continue;
			   }
			   else
			   {
				   for(l=i+1; l<a.length; l++)
				   {   if(a[l]==Y) 
				       {
					   j=l;//j will store index of Y
					    int hold;
						hold=a[i+1];
						a[i+1]=a[j];
						a[j]=hold;
					   k++;
					   break;
				       }
				   }
			   }
			}//end of else if
		}//end of for loop
		
		return a;
	}//end of operation


	 private int noOf(int X, int[] a) {
		 int count=0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]==X)
			{
				count++;
			}
		}
		return count;
	}


	private boolean twoAdjacent(int []a, int X) {
			for (int i = 0; i < a.length; i++) {
			    if(a[i]==X && a[i+1]==X)
			    {
			    	return true;
			    }
			}
			return false;
		}
/*
  * Clump in an array is a series of 2 or more adjacent elements of the same value.
  * @param an integer array
  * @return number of clumps in the array
  * @throws AssertionError if array is empty.
  */
	
	public int countClumps(int[] a) throws AssertionError
	{   if(isArrayEmpty(a))
	   {
		 throw new AssertionError();
	   }
		int countClump=0; 
	    int j;
		for (int i = 0; i < a.length-1; i++) 
		{
			if(a[i]==a[i+1])
			{
	         countClump++;
	         for (j = i+1;  j<a.length ; j++)
	         { if(j==a.length-1)
	        	{
	        	 break;
	        	}
	          else if(a[j]==a[j+1])
			    {
	        	   i=j;
			    }
	           else 
	        	{
	        	   i=j;
	        	   break;
	        	}
			  } //end of inner for loop
	        } //end of if 
		}//end of for loop
	 return countClump;	
	}//end of operation method

	
	/*
	 * Splits the input array so that the sum of the numbers on one-side is equal to the sum of the numbers on the other side.
	 * @param an integer array
	 * @return the index if there is a place to split the array else return -1.
	 * @throws assertion error if array is empty
	 */
	public int splitArray(int[] a) throws AssertionError
	{   if(isArrayEmpty(a))
	   {
		 throw new AssertionError();
	   }
		int sum1=0;
	    int sum2=0;
		int index=-1;
		for (int i = 0; i < a.length; i++) 
		{
			sum1+=a[i];
			sum2=0;
			for (int j = i+1; j < a.length; j++) 
			{
				sum2+=a[j];
			}
			if(sum1==sum2)
			{
				index=i+1;
			}
			else
			{
				continue;
			}
		}

		return index;
	}
	
	/*
	 * Mirror section in an array is a group of contiguous elements such that somewhere in the array, the same group appears in reverse order.
	 * @param integer array
	 * @return length of largest mirror section (if any) in the integer array
	 */
	public int maxMirror(int[] a) throws AssertionError
	{ if(isArrayEmpty(a))
	   {
		 throw new AssertionError();
	   }
	  int maxLengthMirror=0;
	  int k,length;
	  for (int i = 0; i < a.length; i++) {
		k=i;
		length=0;
		boolean flag=false;
		for (int j = a.length-1 ; j >= 0 && k<a.length;j--) {
			 if(a[k]==a[j])
			 {   length++;
			     k++;
			     flag=true;
			     if(length>maxLengthMirror)
			     {
			    	 maxLengthMirror=length;
			     }
			     continue;
			  }
			if(!(a[k]==a[j]) && flag==true)
		    {
			    k=i;
			    length=0;
			    flag=false;
			    j++;
				continue;
		    }
			if(k==j || (k-j)==i)
			{
				break;
			}
		}//end of inner for loop
	}// end of outer for loop
	return maxLengthMirror;	
	}

   public void display(int[] a)
    {
	for( int k=0; k < a.length ; k++)
	  {
		System.out.println(a[k]);
	  }
    }
   public boolean isArrayEmpty(int[] a)
   {
	   if(a.length==0)
		   return true;
	  return false;
	   
   }

}

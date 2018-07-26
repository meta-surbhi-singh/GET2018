/*
 * This is an immutable class IntSet which uses an array to represent a set of integers in the range 1-1000
 */
final public class IntSet {
private static final int[] universalSet = new int[] { 220, 435, 554, 678, 409, 435, 900, 863, 564, 598, 553};	
private final int [] set;

/*
 * initializes final field set 
 * @param integer array set
 * @throws AssertionError if the range of integers in @param set exceeds 1-1000
 */
public IntSet(int []set) throws AssertionError
{   
	for (int index = 0; index < set.length; index++) {
		if(set[index]<0 || set[index]>1000)
			throw new AssertionError();
	}
	this.set=set;
}


/*
 * checks if the integer x is a member of integer array set
 * @param integer value x which  is checked if member of array or not
 * @return boolean value, true if the integer array set contain @param x, else return false 
 */
public boolean isMember(int x) 
{   boolean result=false;
	for (int index = 0; index < set.length; index++) {
		if(set[index]==x)
			result=true;
	}
	return result;
}

/*
 * @return size of integer array set
 */
public int size()
{   //System.out.println(set.length);
	return set.length;
}


/*
 * checks if an array is subset of the array
 * @param IntSet s which is to be checked for subset or not
 * @return boolean value true if it @param s is subset, else return false
 */
public boolean isSubSet(IntSet s) 
{   boolean result=false;
    int countEqual=0;
	for (int index_subSet = 0 ; index_subSet < s.size(); index_subSet++) {
		   for (int index = 0; index< this.size(); index++) {
		      if(s.set[index_subSet]==this.set[index])
		      {   
		    	  countEqual++;
		      }
		   }
	}
    if(countEqual==s.size())
    {
    	result=true;
    }

	return result;
}

/*
 * produces a complement set,  Assume that 1..1000 between is the universal set
 * @return complement set
 */

public int[] getComplement() 
{  
	
    int[] complementTemp=new int[universalSet.length];
    int k=0;
    int complementSize=0;
    
    for (int index_universal = 0 ; index_universal < universalSet.length  && k < complementTemp.length ; index_universal++) 
    {
    	for(int index = 0; index < this.size()  ; index++)
    	{
		if( this.set[index] != universalSet[index_universal])
	       { if(index == this.size()-1)
	         { complementTemp[k] = universalSet[index_universal];
			   k++;
			   complementSize++;
			 break;
	         }
	       else 
	    	   {
	    	   continue;
	    	   }
		   }
		else
		   {
		   break;
		   }
	     }
     }
    int complement[]= new int[complementSize];
    for (int index = 0; index < complement.length; index++) {
		complement[index]=complementTemp[index];
	}

	for (int index = 0; index < complement.length; index++) 
		{System.out.println(complement[index] );
		}
	return complement;
}

/*
 * produces a union of two sets
 * @return integer array union set
 */


public int[] union(IntSet s1, IntSet s2) 
{   int unionIndex = 0;
    int unionSize = 0;
    int[] unionTemp=new int[s1.size()+s2.size()];
    
	for( int index1 = 0 ; index1 < s1.size() && unionIndex < unionTemp.length ; index1++)
	{
		unionTemp[unionIndex]=s1.set[index1];
		unionSize++;
		unionIndex++;
	}
	
	for( int index2 = 0 ; index2 < s2.size()  && unionIndex < unionTemp.length; index2++)
	{   for(int index1 = 0 ; index1 < s1.size() && unionIndex < unionTemp.length ; index1++)
	   {
		if( s2.set[index2] != s1.set[index1])
	       { if(index1 == this.size()-1)
	         { unionTemp[unionIndex]=s2.set[index2];
	           unionIndex++;
	           unionSize++;
			 break;
	         }
	       else 
	    	 {
	    	   continue;
	    	 }
		   }
		else
		   {
		   break;
		   }
	     }
		
		//if(s2.set[index2] == s1.set[index1])
		//unionTemp[unionIndex]=s2.set[index2];
	}
	 int union[]= new int[unionSize];
	  for (int index = 0; index < union.length; index++) {
			union[index]=unionTemp[index];
	  }

	for (int i = 0; i < union.length; i++) 
	{System.out.print(union[i]+ ",");
	}
	return union;
}


public void display()
{
	for (int index = 0; index < set.length; index++) {
		{System.out.print(set[index] + ", ");
		}
	}
}
public static void main(String args[])
{
	IntSet intSet=new IntSet(new int[] {400,543,678,900});
	intSet.display();
	//System.out.println(intSet.size());
	//System.out.println(intSet.isMember(500));
	System.out.println(" ");
	IntSet intSet1=new IntSet(new int[] {220,566,343,323,666,529,900});
	IntSet intSet2=new IntSet(new int[] {566,343,323,666,529,900});
	intSet1.display();
	//System.out.println(intSet1.size());
	System.out.println(" ");
	intSet2.display();
	//System.out.println(intSet2.size());
	System.out.println(" ");
	//intSet.isSubSet(intSet2);
    //intSet2.getComplement();
	System.out.println(" ");
	//IntSet intSet3=intSet.union(intSet1,intSet2);
	//intSet3.display();
	intSet.union(intSet1, intSet2);
	System.out.println(" ");
	intSet1.union(intSet, intSet2);
	System.out.println(" ");
	intSet2.union(intSet, intSet1);
	System.out.println(" ");

}

}

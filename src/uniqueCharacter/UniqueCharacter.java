package uniqueCharacter;
import java.util.HashMap;

public class UniqueCharacter {
	HashMap<String,Integer> memoizedTable = new HashMap<String,Integer>();
	
	public int countUniqueCharacter(String str) {
		int count = 0;
		if(!memoizedTable.containsKey(str)) {
			count = getUniqueCharacterCount(str);
			memoizedTable.put(str, count);	
		}
		else {
			count = memoizedTable.get(str);
		}
		return count;
	}

	private int getUniqueCharacterCount(String str) {
		return removeDuplicates(str).length();
	}
	
	 private String removeDuplicates(String str) {
		 
	      // Store encountered letters in this string.
	      char[] chrArray = str.toCharArray();
	      String targetStr = "";
	 
	       // Loop over each character.
	       for (char value : chrArray) {
	          // See if character is in the target
	          if (targetStr.indexOf(value) == -1) {
	                targetStr += value; // Use StringBuilder as shown below
	            }
	        }
	        return targetStr;
	    }
}

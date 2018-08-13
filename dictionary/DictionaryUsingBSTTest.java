package dictionary;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class DictionaryUsingBSTTest {
    IDictionary dictionary;

    //test cases for addToDictionary()
    @Test
    public void testAddToDictionary() {
        dictionary=new DictionaryUsingBST();
        dictionary.addToDictionary(8, "sam");
        List<Node> sortedList=dictionary.getSortedList();
        int[] expectedList={1,2,4,7,8,10};
        for(int i=0;i<expectedList.length;i++)
        {
            int actualKey=sortedList.get(i).getKey();
            assertEquals(expectedList[i], actualKey);
        }
    }
    
    //test cases for deleteFromDictionary()
    @Test
    public void testDeleteFromDictionary() {
        dictionary=new DictionaryUsingBST();
        dictionary.deleteFromDictionary(7);
        List<Node> sortedList=dictionary.getSortedList();
        int[] expectedList={1,2,4,10};
        for(int i=0;i<expectedList.length;i++)
        {
            int actualKey=sortedList.get(i).getKey();
            assertEquals(expectedList[i], actualKey);
        }
    }
    
    //test cases for getValue()
    @Test
    public void testGetValue() {
        dictionary=new DictionaryUsingBST();
        String value=dictionary.getValue(10);
        assertEquals("ankit",value);
    }
    
    @Test(expected=AssertionError.class)
    public void testGetValueE() {
        dictionary=new DictionaryUsingBST();
        dictionary.getValue(5);
    }
    
    //test cases for getSortedList()
    @Test
    public void testGetSortedList() {
        dictionary=new DictionaryUsingBST();
        List<Node> actualSortedList=dictionary.getSortedList();
        int[] expectedList={1,2,4,7,10};
        for(int i=0;i<expectedList.length;i++)
        {
            int actualKey=actualSortedList.get(i).getKey();
            assertEquals(expectedList[i], actualKey);
        }
    }
    
    //test cases for getSortedListInRangeOfKey()
    @Test
    public void testGetSortedListRange() {
        dictionary=new DictionaryUsingBST();
        List<Node> actualSortedList=dictionary.getSortedListInRangeOfKey(5, 8);
        int[] expectedList={7};
        for(int i=0;i<expectedList.length;i++)
        {
            int actualKey=actualSortedList.get(i).getKey();
            assertEquals(expectedList[i], actualKey);
        }
    }
    
    
    @Test
    public void testGetSortedListShouldReturnEmptyListWhenNoneKeysInRange() {
        dictionary=new DictionaryUsingBST();
        List<Node> actualSortedList=dictionary.getSortedListInRangeOfKey(-5,-1);
        assertEquals(0,actualSortedList.size());
    }

}

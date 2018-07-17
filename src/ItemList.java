import java.util.ArrayList;

public class ItemList {
	ArrayList<Item> itemList;
	Item item1,item2,item3,item4,item5,item6,item7,item8,item9,item10;
	public void createItems()
	{       itemList=new ArrayList<Item>();
		    item1=new Item("hat",300);
		    item2=new Item("belt",500);
		    item3=new Item("jacket",4000);
		    item4=new Item("shirt",1500);
		    item5=new Item("trousers",2000);
		    item6=new Item("jeans",2000);
		    item7=new Item("top",1000);
		    item8=new Item("pyjamas",1000);
		    item9=new Item("shoes",3000);
		    item10=new Item("watch",4000);
		   
	}
	public void addItems()
	{
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);
		itemList.add(item5);
		itemList.add(item6);
		itemList.add(item7);
		itemList.add(item8);
		itemList.add(item9);
		itemList.add(item10);
	}
public void displayAllItems()
{
	System.out.println("AVAILABLE IN STOCK");
	for(int i=0;i<itemList.size();i++)
	System.out.println("S.NO." + (i+1) + "ITEM NAME: " + itemList.get(i).itemName + "\n ITEM PRICE" + itemList.get(i).itemPrice );

	
}
}

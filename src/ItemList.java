import java.util.ArrayList;

public class ItemList {
	public ArrayList<Item> itemList;
	public Item item1,item2,item3,item4,item5,item6,item7,item8,item9,item10;
	public void createItems()
	{       itemList=new ArrayList<Item>();
		    item1=new Item(1,"hat",300);
		    item2=new Item(2,"belt",500);
		    item3=new Item(3,"jacket",4000);
		    item4=new Item(4,"shirt",1500);
		    item5=new Item(5,"trousers",2000);
		    item6=new Item(6,"jeans",2000);
		    item7=new Item(7,"top",1000);
		    item8=new Item(8,"pyjamas",1000);
		    item9=new Item(9,"shoes",3000);
		    item10=new Item(10,"watch",4000);
		   
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
	System.out.println("S.NO. " + (i+1) + ".  ITEM NAME: " + itemList.get(i).itemName + "\n ITEM PRICE" + itemList.get(i).itemPrice );

	
}
}

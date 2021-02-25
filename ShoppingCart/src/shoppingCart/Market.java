package shoppingCart;
import java.util.ArrayList;


public class Market {

	private ArrayList<Item> items = new ArrayList<>();
	final int totalItem = 5;
	final int[] dummyIds ={1,2,3,4,5};
	final String[] dummyItems = {"Milk","Biscuit","Bread","Pulse","Wheat_Flour"};
	final double[] dummyPrice = {56.0,20.0,12.0,98.0,450.0};
	final int[] dummyQuant = {10,10,10,10,10};
	final String[] dummyDesc = {"1L gold","Parle-G","Brown_Bread","Arhar Daal","10kg pack."};
	
	//creating a fake products list
	Market(){
		for(int i=0;i<totalItem;i++){
			Item item = new Item();
			item.setItemId(dummyIds[i]);
			item.setItemName(dummyItems[i]);
			item.setItemPrice(dummyPrice[i]);
			item.setItemQuantity(dummyQuant[i]);
			item.setItemDesc(dummyDesc[i]);
			items.add(item);
		}
	}
	
	void displayItems(){
		System.out.println("Id\tname\t\tprice\tIn Stock\tDescription");
		for(Item item:items){
			System.out.println(item.getItemId()+"\t"+item.getItemName()+"\t\t"+item.getItemPrice()+"\t"+item.getItemQuantity()+"\t"+item.getItemDesc());
		}
	}
	
	Item getItem(int itemId,int quantity){
		Item selectedItem = null;
		for(Item item:items){
			if(item.getItemId()==itemId){
				selectedItem = item;
				break;
			}
		}
		int current_stock = selectedItem.getItemQuantity();
		if(current_stock==0)
			return null;
		if(quantity>current_stock){
			System.out.println("Sorry only "+current_stock+" pieces are available");
			quantity = current_stock;
		}
		Item item = new Item();
		
		selectedItem.setItemQuantity(current_stock-quantity);
		item.setItemId(itemId);
		item.setItemName(selectedItem.getItemName());
		item.setItemPrice(selectedItem.getItemPrice());
		item.setItemQuantity(quantity);
		return item;
	}
	
}
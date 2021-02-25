package shoppingCart;
import java.util.ArrayList;


public class Market {

	private ArrayList<Item> items = new ArrayList<>();
	final int total_item = 5;
	final String[] dummy_items = {"Milk","Biscuit","Bread","Pulse","Wheat_Flour"};
	final double[] dummy_price = {56.0,20.0,12.0,98.0,450.0};
	final int[] dummy_quant = {10,10,10,10,10};
	final String[] dummy_desc = {"1L gold","Parle-G","Brown_Bread","Arhar Daal","10kg pack."};
	
	//creating a fake products list
	Market(){
		for(int i=0;i<total_item;i++){
			Item item = new Item();
			item.setItemName(dummy_items[i]);
			item.setItemPrice(dummy_price[i]);
			item.setItemQuantity(dummy_quant[i]);
			item.setItemDesc(dummy_desc[i]);
			items.add(item);
		}
	}
	
	void displayItems(){
		int sno=1;
		System.out.println("S.no\tname\t\tprice\tIn Stock\tDescription");
		for(Item item:items){
			System.out.println(sno+++"\t"+item.getItemName()+"\t\t"+item.getItemPrice()+"\t"+item.getItemQuantity()+"\t"+item.getItemDesc());
		}
	}
	
	Item getItem(int itemNo,int quantity){
		Item selected_item = items.get(itemNo-1);
		int current_stock = selected_item.getItemQuantity();
		if(current_stock==0)
			return null;
		if(quantity>current_stock){
			System.out.println("Sorry only "+current_stock+" pieces are available");
			quantity = current_stock;
		}
		Item item = new Item();
		
		selected_item.setItemQuantity(current_stock-quantity);
		item.setItemName(selected_item.getItemName());
		item.setItemPrice(selected_item.getItemPrice());
		item.setItemQuantity(quantity);
		return item;
	}
	
}
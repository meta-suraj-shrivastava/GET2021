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
			item.set_item_name(dummy_items[i]);
			item.set_item_price(dummy_price[i]);
			item.set_item_quantity(dummy_quant[i]);
			item.set_item_desc(dummy_desc[i]);
			items.add(item);
		}
	}
	
	void display_Items(){
		int sno=1;
		System.out.println("S.no\tname\t\tprice\tIn Stock\tDescription");
		for(Item I:items){
			System.out.println(sno+++"\t"+I.get_item_name()+"\t\t"+I.get_item_price()+"\t"+I.get_item_quantity()+"\t"+I.get_item_desc());
		}
	}
	
	Item get_item(int item_no,int no_of_packs){
		Item selected_item = items.get(item_no-1);
		int current_stock = selected_item.get_item_quantity();
		if(current_stock==0)
			return null;
		if(no_of_packs>current_stock){
			System.out.println("Sorry only "+current_stock+" pieces are available");
			no_of_packs = current_stock;
		}
		Item item = new Item();
		
		selected_item.set_item_quantity(current_stock-no_of_packs);
		item.set_item_name(selected_item.get_item_name());
		item.set_item_price(selected_item.get_item_price());
		item.set_item_quantity(no_of_packs);
		return item;
	}
	
}
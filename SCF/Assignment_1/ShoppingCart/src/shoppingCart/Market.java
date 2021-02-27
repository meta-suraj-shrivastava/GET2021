package shoppingCart;
import java.util.ArrayList;

/*Market Class contains following method :-
1. Market(Constructor) :- It will initialize a market with some dummy Items
2. getItem :- parms(itemId)
3. displayItems :- Display all market Items
4. updateStockAfterRemove  :- parms(itemId, quamtity)
5. addToCart :-params(itemId,quantity,cart) pass the selected item to cart with given quantity
*/

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
	
	Item getItem(int itemId){
		//finding item from market
		for(Item item:items){
			if(item.getItemId()==itemId){
				return item;
			}
		}
		return null;
	}
	
	void displayItems(){
		System.out.println("Id\tname\t\tprice\tIn Stock\tDescription");
		for(Item item:items){
			System.out.println(item.getItemId()+"\t"+item.getItemName()+"\t\t"+item.getItemPrice()+"\t"+item.getItemQuantity()+"\t"+item.getItemDesc());
		}
	}
	//will update the stocks after remove from cart
	void updateStockAfterRemove(int itemId,int quantity){
		Item item = getItem(itemId);
		int currentQuant = item.getItemQuantity();
		item.setItemQuantity(currentQuant+quantity);
		}
	//adding item to cart
	String addToCart(int itemId,int quantity,Cart cart){
		Item selectedItem = getItem(itemId);
		if(selectedItem==null){
			return "Inavlid Product id";
		}
		int currentStock = selectedItem.getItemQuantity();
		if(currentStock==0){
			System.out.println("Currently this product is out of stock");
		}
		if(quantity>currentStock){
			System.out.println("Sorry only "+currentStock+" pieces are available");
			quantity = currentStock;
		}
		Item item = new Item(); //creating new item for cart with given quantity
		selectedItem.setItemQuantity(currentStock-quantity); // subtracting quantity from market item
		item.setItemId(itemId);
		item.setItemName(selectedItem.getItemName());
		item.setItemPrice(selectedItem.getItemPrice());
		item.setItemQuantity(quantity);
		if(cart.addItem(item)==null){
			selectedItem.setItemQuantity(currentStock);
			return "Fail to Add";
		}
		return "Success";
	}
	
}
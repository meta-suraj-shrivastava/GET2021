package shoppingCart;
import java.util.ArrayList;


/*Cart Class contains following method :-
1. displayCart :- Display the cart items
2. getItemFromCart :- params(itemId) return Item of given id
3. addItem :- params(item) return "success" on successFull added to cart
4. Remove from cart :- params(itemId,Quantity,market) return "Sucess" on successFull removal of item
*/
public class Cart {
private ArrayList<Item> items = new ArrayList<>();
static final int MAX_ITEMS = 10;
int currentItems=0;

double displayCart(){
	double billTotal=0;
	if(items.size()==0){
		System.out.println("Cart is Empty");
		return 0;
	}
	System.out.println("Id\tname\tprice\tQuantity\ttotal");
	for(Item item:items){
		double totalPrice = item.getItemPrice()*item.getItemQuantity();
		System.out.println(item.getItemId()+"\t"+item.getItemName()+"\t"+item.getItemPrice()+"\t"+item.getItemQuantity()+"\t\t"+totalPrice);
		billTotal+=totalPrice;
	}
	return billTotal;
}

Item getItemFromCart(int id){
	//Finding an item is already present in cart or not
	for(Item item:items){
		if(item.getItemId()==id)
			return item;
	}
	return null;
}

//Will add an item to cart
String addItem(Item item){
	int newQuantity = item.getItemQuantity();
	if(currentItems+newQuantity>MAX_ITEMS){
		System.out.println("Can't add more than "+MAX_ITEMS+" items");
		return null;
	}
	Item selectedItem = getItemFromCart(item.getItemId());
	if(selectedItem==null){
		currentItems+=item.getItemQuantity();
		items.add(item);
	}
	else{
		int currentQuantity = selectedItem.getItemQuantity();
		selectedItem.setItemQuantity(currentQuantity+newQuantity);
		currentItems+=newQuantity;
		}
	return "Success";
}

//Will Remove an item from cart
String removeFromCart(int itemId,int quantity,Market market){
	Item selectedItem = getItemFromCart(itemId);
	if(selectedItem==null)
		return "This Item is not in cart";
	int itemQuantity = selectedItem.getItemQuantity();
	if(itemQuantity<=quantity){
		items.remove(selectedItem);
	}
	else{
		selectedItem.setItemQuantity(itemQuantity-quantity);
	}
	currentItems-=quantity;
	market.updateStockAfterRemove(itemId, quantity);
	return "Success";
}
}

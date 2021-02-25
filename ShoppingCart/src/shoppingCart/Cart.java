package shoppingCart;
import java.util.ArrayList;
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
		double t_price = item.getItemPrice()*item.getItemQuantity();
		System.out.println(item.getItemId()+"\t"+item.getItemName()+"\t"+item.getItemPrice()+"\t"+item.getItemQuantity()+"\t\t"+t_price);
		billTotal+=t_price;
	}
	return billTotal;
}

Item getItemFromCart(int id){
	for(Item item:items){
		if(item.getItemId()==id)
			return item;
	}
	return null;
}


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
	System.out.println("CI "+currentItems);
	return "Success";
}
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
	System.out.println("CI "+currentItems);
	market.updateStockAfterRemove(itemId, quantity);
	return "Success";
}
}

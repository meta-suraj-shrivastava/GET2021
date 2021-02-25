package shoppingCart;
import java.util.ArrayList;
public class Cart {
private ArrayList<Item> items = new ArrayList<>();
static final int MAX_ITEMS = 10;


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


String addToCart(Item item){
	int totalItems = items.size();
	if(totalItems>MAX_ITEMS)
		return "Can't add More than 10";
	if(item==null)
		return "Sorry!Item is out of stock";
	items.add(item);
	return "Success";
}
String removeFromCart(int itemId,int quantity){
	Item selectedItem = getItemFromCart(itemId);
	if(selectedItem==null)
		return "This Item is not in cart";
	int itemQuantity = selectedItem.getItemQuantity();
	if(itemQuantity<=quantity)
		items.remove(selectedItem);
	else
		selectedItem.setItemQuantity(itemQuantity-quantity);
	return "Success";
}
}

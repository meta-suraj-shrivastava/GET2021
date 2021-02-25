package shoppingCart;
import java.util.ArrayList;
public class Cart {
private ArrayList<Item> items = new ArrayList<>();
static final int MAX_ITEMS = 10;


double displayCart(){
	int sno=1;
	double bill_total=0;
	if(items.size()==0){
		System.out.println("Cart is Empty");
		return 0;
	}
	System.out.println("S.no\tname\tprice\tQuantity\ttotal");
	for(Item item:items){
		double t_price = item.getItemPrice()*item.getItemQuantity();
		System.out.println(sno+++"\t"+item.getItemName()+"\t"+item.getItemPrice()+"\t"+item.getItemQuantity()+"\t\t"+t_price);
		bill_total+=t_price;
	}
	return bill_total;
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
String removeFromCart(int item_no,int quantity){
	int totalItems = items.size();
	if(totalItems==0)
		return "Cart is already Empty";
	Item selected_item =items.get(item_no-1);
	int itemQuantity = selected_item.getItemQuantity();
	if(itemQuantity<=quantity)
		items.remove(selected_item);
	else
		selected_item.setItemQuantity(itemQuantity-quantity);
	return "Success";
}
}

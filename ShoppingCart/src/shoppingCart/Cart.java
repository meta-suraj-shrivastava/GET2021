package shoppingCart;
import java.util.ArrayList;
public class Cart {
private ArrayList<Item> items = new ArrayList<>();


double display_cart(){
	int sno=1;
	double bill_total=0;
	if(items.size()==0){
		System.out.println("Cart is Empty");
		return 0;
	}
	System.out.println("S.no\tname\tprice\tQuantity\ttotal");
	for(Item I:items){
		double t_price = I.get_item_price()*I.get_item_quantity();
		System.out.println(sno+++"\t"+I.get_item_name()+"\t"+I.get_item_price()+"\t"+I.get_item_quantity()+"\t\t"+t_price);
		bill_total+=t_price;
	}
	return bill_total;
}

String add_to_cart(Item item){
	int total_items = items.size();
	if(total_items>10)
		return "Can't add More than 10";
	if(item==null)
		return "Sorry!Item is out of stock";
	items.add(item);
	return "Success";
}
String remove_from_cart(int item_no,int quantity){
	int total_items = items.size();
	if(total_items==0)
		return "Cart is already Empty";
	Item selected_item =items.get(item_no-1);
	if(selected_item.get_item_quantity()==quantity)
		items.remove(selected_item);
	else{
		selected_item.set_item_quantity(selected_item.get_item_quantity()-quantity);
	}
	return "Success";
}
}

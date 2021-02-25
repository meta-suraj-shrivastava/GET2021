package shoppingCart;

public class Item {
private String item_name;
private String item_desc;
private int item_quantity;
private double item_price;


void setItemName(String name){
	item_name = name;
}
void setItemPrice(double price){
	item_price = price;
}
void setItemDesc(String desc){
	item_desc = desc;
}
void setItemQuantity(int quantity){
	item_quantity = quantity;
}

String getItemName(){
	return item_name;
}
double getItemPrice(){
	return item_price;
}
int getItemQuantity(){
	return item_quantity;
}

String getItemDesc(){
	return item_desc;
}
}
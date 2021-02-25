package shoppingCart;

public class Item {
private String item_name;
private String item_desc;
private int item_quantity;
private double item_price;


void set_item_name(String name){
	item_name = name;
}
void set_item_price(double price){
	item_price = price;
}
void set_item_desc(String desc){
	item_desc = desc;
}
void set_item_quantity(int quantity){
	item_quantity = quantity;
}

String get_item_name(){
	return item_name;
}
double get_item_price(){
	return item_price;
}
int get_item_quantity(){
	return item_quantity;
}

String get_item_desc(){
	return item_desc;
}
}
package shoppingCart;

public class Item {
private int itemId;
private String itemName;
private String itemDesc;
private int itemQuantity;
private double itemPrice;

//-----------setters----------------------
void setItemId(int id){
	itemId = id;
}

void setItemName(String name){
	itemName = name;
}
void setItemPrice(double price){
	itemPrice = price;
}
void setItemDesc(String desc){
	itemDesc = desc;
}
void setItemQuantity(int quantity){
	itemQuantity = quantity;
}
//-----------getters----------------------
String getItemName(){
	return itemName;
}
double getItemPrice(){
	return itemPrice;
}
int getItemQuantity(){
	return itemQuantity;
}

String getItemDesc(){
	return itemDesc;
}
int getItemId(){
	return itemId;
}
}
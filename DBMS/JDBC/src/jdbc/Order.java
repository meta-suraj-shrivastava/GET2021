package jdbc;

public class Order {

	private int orderId,orderTotal;
	private String orderDate;
	
	Order(int orderId,int orderToal,String orderDate){
		this.orderDate = orderDate;
		this.orderId = orderId;
		this.orderTotal = orderToal;
	}
	
	int getTotal(){
		return this.orderTotal;
	}
	int getOrderId(){
		return this.orderId;
	}
	String getOrderDate(){
		return this.orderDate;
	}
	
}

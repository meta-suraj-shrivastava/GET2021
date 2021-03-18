package jdbc;


//POJO for Orders query
public class Order {

	private int orderId,orderTotal;
	private String orderDate;
	
	
	//parametrized constructor
	//@param-orderId:int,orderTotal:int,orderDate:String
	Order(int orderId,int orderToal,String orderDate){
		this.orderDate = orderDate;
		this.orderId = orderId;
		this.orderTotal = orderToal;
	}
	
	
	//return the total amount of order
	int getTotal(){
		return this.orderTotal;
	}
	
	//return orderId
	int getOrderId(){
		return this.orderId;
	}
	
	//return the order date
	String getOrderDate(){
		return this.orderDate;
	}
	
}

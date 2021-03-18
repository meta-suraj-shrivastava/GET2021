package jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) throws SQLException{
		Jdbc jdbc = new Jdbc();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("\n\n1.Get all the orders of given userId");
			System.out.println("2.Insert multiple images");
			System.out.println("3.Delete unorderd product from last 1 year");
			System.out.println("4.get all parentCategories and the count of their child categories");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter user Id");
				int userId = sc.nextInt();
				ArrayList<Order> orders = jdbc.getOrders(userId);
				printOrders(orders);
				break;
			case 2:
				System.out.println("Insert number of images");
				int totalImages = sc.nextInt();
				HashMap<String,Integer> imagePaths = new HashMap<>();
				for(int index = 0;index<totalImages;index++){
					System.out.println("Enter path for image "+(index+1));
					String path = sc.next();
					System.out.println("Enter Product Id for image "+(index+1));
					int id = sc.nextInt();
					imagePaths.put(path, id);
					}
				jdbc.insertImages(imagePaths);
				break;
			case 3:
				System.out.println("Deleted "+jdbc.deletUnorderdProd()+" products");
			default:
				sc.close();
				return;
			}
		}
	}
	
	static void printOrders(ArrayList<Order> orders){
		if(orders.size()==0) return;
		System.out.println("OrderId\tOrderTotal \t OrderDate");
		for(Order order:orders){
			System.out.println(order.getOrderId()+" \t "+order.getTotal()+" \t "+order.getOrderDate());
			
		}
	}
}

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Jdbc  {
	private Connection connection;
	private Statement stmt;
	Jdbc() throws SQLException{
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "123");
		stmt = connection.createStatement();
	}
	public ArrayList<Order> getOrders(int userId) throws SQLException {
		ArrayList<Order> orders = new ArrayList<Order>();
		ResultSet rs =stmt.executeQuery(
				"select orderId,orderTotal,orderDate from orders where userId="+userId);
		while(rs.next()){
			Order newOrder = new Order(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3).toString());
			orders.add(newOrder);
		}
	return orders;
	}
	
	public void insertImages(HashMap<String, Integer> imagePaths) throws SQLException {
		connection.setAutoCommit(false);
		System.out.println("Inserting images....");
		for(String path:imagePaths.keySet()){
			System.out.println(path+"   "+imagePaths.get(path));
			stmt.addBatch(
			"Insert Into images values("+
					imagePaths.get(path)+",LOAD_FILE('"+path+"'));");
		}
		stmt.executeBatch();
		connection.commit();
		connection.setAutoCommit(true);
	}
	public int deletUnorderdProd() throws SQLException {
		stmt.executeQuery("set FOREIGN_KEY_CHECKS=0");
		ResultSet rs = stmt.executeQuery(
				"delete from products p "
				+ "innner join "
				+ "(select od.productId from orderdetails od inner join orders o"
				+ "where od.orderId=o.orderIdId and DATEDIFF(o.orderDate,now())>365) as r "
				+ "where r.productId = p.productId;"
				);
		stmt.executeQuery("set FOREIGN_KEY_CHECKS=1");
		return 0;
	}

	
	
}

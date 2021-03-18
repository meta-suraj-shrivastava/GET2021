package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


//this class handle all the CURD operations Insert,Select,Delete etc
public class Jdbc  {
	private Connection connection;
	private Statement stmt;
	
	//initializing the connection to the database  
	Jdbc() throws SQLException{
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "123");
		stmt = connection.createStatement();
	}
	
	
	//return the list of POJOs of orders which contains the order details of the give userID
	//@param - userId:int
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
	
	//Insert the given images with product id using the batch insertion technique
	//@param-path:productId(Map)
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
	
	//return the no of deleted unorderd product from the last 1 year
	public int deletUnorderdProd() throws SQLException {
		int deletedRows = stmt.executeUpdate(
				"delete p from products p "
				+ "inner join "
				+ "(select od.productId from orderdetails od inner join orders o "
				+ "where od.orderId=o.orderId and DATEDIFF(now(),o.orderDate)>365) as r "
				+ "where r.productId = p.productId;"
				);
		return deletedRows;
	}

	//return the list of the POJOs of Category Details contains the name of the parent category name and count of its child
	public ArrayList<CategoryDetails> getChildCategoryCount() throws SQLException{
		ArrayList<CategoryDetails> catDetails = new ArrayList<>();
		ResultSet rs = stmt.executeQuery("select pc.categoryName, count(c.categoryName) "
				+ "as chid_category_Count from"
				+ " (select categoryName, categoryId from"
				+ " categories where parentCatId is null) as pc"
				+ " left join categories c "
				+ "ON pc.categoryId = c.parentCatId group by pc.categoryName order by pc.categoryName;");
		
		while(rs.next()){
			CategoryDetails catDetail = new CategoryDetails(rs.getString(1), rs.getInt(2));
			catDetails.add(catDetail);
		}
		return catDetails;
	}
	
}

package factoryPattern;

public interface Shape {
	double PI = 3.14;
	enum shapeTypes {
	 CIRCLE,
	 RECTANNGLE,
	 SQUARE,
	 TRIANGLE,
	} 
	
	void setId(int shapeId); //assign the id to the shape
	double getArea(); //return the area of the shape
	double getParameter();  //return parameter of the shape
	int getId(); //return the id of the shape
	Point getOrigin(); //return the origin of the shape
	String getTimestamp(); //return the timestamp of the shape
	boolean isPointEnclosed(Point point);  //check weather the point is inside the shape of not
}

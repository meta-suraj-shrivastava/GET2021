package factoryPattern;

public interface Shape {
	double PI = 3.14;
	enum shapeTypes {
	 CIRCLE,
	 RECTANNGLE,
	 SQUARE,
	 TRIANGLE,
	} 
	
	void setId(int shapeId);
	double getArea();
	double getParameter();
	int getId();
	Point getOrigin();
	String getTimestamp();
	boolean isPointClosed(Point point);
}

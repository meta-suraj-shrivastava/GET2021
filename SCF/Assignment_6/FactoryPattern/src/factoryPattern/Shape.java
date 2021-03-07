package factoryPattern;

public interface Shape {
	double PI = 3.14;
	enum shapeTypes {
	 CIRCLE,
	 RECTANNGLE,
	 SQUARE,
	 TRIANGLE,
	} 
	double getArea();
	double getParameter();
	Point getOrigin();
	String getTimestamp();
	boolean isPointClosed();
	int getId();
	void setId(int shapeId);
}

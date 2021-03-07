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
	boolean isPointClosed();
}

package factoryPattern;

import java.util.Date;
import java.util.List;

public class Circle implements Shape {
	double radius;
	Point coordinates;
	String timestamp;
	int id;
	
	
	//Constructor takes two parameter point object(Screen coordinates) 
	//and list object(Parameter of shapes)
	Circle(Point point, List<Integer> list) {
		coordinates = new Point(point.getX(),point.getY());
		radius = list.get(0);
		timestamp = new Date().toString();
	}
	
	//***************setters*****************
	@Override
	public void setId(int shapeId) {
		id = shapeId;
	}
	
	//**************getters*****************

	@Override
	public Point getOrigin() {
		return coordinates;
	}
	@Override
	public String getTimestamp() {
		return timestamp;
	}

	@Override
	public int getId() {
		return id;
	}
	
	
	@Override
	public boolean isPointEnclosed(Point point) {
		if(point.getX()<coordinates.getX()+radius && 
				point.getX()>coordinates.getX()-radius &&
				point.getY()<coordinates.getY()+radius &&
				point.getY()>coordinates.getY()-radius)
			return true;
		return false;
	}
	//return area of Circle
	@Override
	public double getArea() {
		return PI*radius*radius;
	}
	//return parameter of circle
	@Override
	public double getParameter() {
		return 2*PI*radius;
	}

}

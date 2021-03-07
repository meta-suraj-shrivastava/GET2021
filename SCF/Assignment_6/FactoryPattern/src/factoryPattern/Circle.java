package factoryPattern;

import java.util.Date;
import java.util.List;

public class Circle implements Shape {
	double radius;
	Point coordinates;
	String timestamp;
	int id;
	Circle(Point point, List<Integer> list) {
		coordinates = new Point(point.getX(),point.getY());
		radius = list.get(0);
		timestamp = new Date().toString();
	}
	
	@Override
	public void setId(int shapeId) {
		id = shapeId;
	}
	@Override
	public double getArea() {
		return PI*radius*radius;
	}

	@Override
	public double getParameter() {
		return 2*PI*radius;
	}

	@Override
	public Point getOrigin() {
		return coordinates;
	}

	@Override
	public boolean isPointClosed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getTimestamp() {
		return timestamp;
	}

	@Override
	public int getId() {
		return id;
	}

}

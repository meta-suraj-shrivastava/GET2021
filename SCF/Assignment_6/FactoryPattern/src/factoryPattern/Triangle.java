package factoryPattern;

import java.util.Date;
import java.util.List;

public class Triangle implements Shape {
	int base,height;
	Point coordinates;
	String timestamp;
	int id;
	Triangle(Point point, List<Integer> list) {
		base = list.get(0);
		height = list.get(1);
		coordinates = new Point(point.getX(),point.getY());
		timestamp = new Date().toString();
	}

	@Override
	public double getArea() {
		return 0.5*base*height;
	}

	@Override
	public double getParameter() {
		double hypo = Math.sqrt((base*base) + (height*height));
		return hypo+base+height;
	}

	@Override
	public Point getOrigin() {
		// TODO Auto-generated method stub
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

	@Override
	public void setId(int shapeId) {
		id = shapeId;
		
	}

}

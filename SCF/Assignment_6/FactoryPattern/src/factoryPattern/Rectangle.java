package factoryPattern;

import java.util.Date;
import java.util.List;

public class Rectangle implements Shape {
	int width,height;
	Point coordinates;
	String timestamp;
	int id;
	public Rectangle(Point point, List<Integer> list) {
		coordinates = new Point(point.getX(),point.getY());
		width = list.get(0);
		height = list.get(1);
		timestamp = new Date().toString();
	}

	@Override
	public double getArea() {
		return width*height;
	}

	@Override
	public double getParameter() {
		return 2*(width+height);
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

	@Override
	public void setId(int shapeId) {
		id = shapeId;
		
	}

}

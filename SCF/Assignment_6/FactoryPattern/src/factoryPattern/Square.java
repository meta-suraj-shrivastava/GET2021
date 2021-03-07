package factoryPattern;

import java.util.Date;
import java.util.List;

public class Square implements Shape {
	int side;
	Point coordinates;
	String timestamp;
	int id;
	public Square(Point point, List<Integer> list) {
		coordinates = new Point(point.getX(),point.getY());
		side = list.get(0);
		timestamp = new Date().toString();
	}

	@Override
	public double getArea() {
		return side*side;
	}

	@Override
	public double getParameter() {
		return 4*side;
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

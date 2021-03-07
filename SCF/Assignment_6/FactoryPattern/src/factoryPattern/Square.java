package factoryPattern;

import java.util.List;

public class Square implements Shape {
	int side;
	Point coordinates;
	public Square(Point point, List<Integer> list) {
		coordinates = new Point(point.getX(),point.getY());
		side = list.get(0);
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

}

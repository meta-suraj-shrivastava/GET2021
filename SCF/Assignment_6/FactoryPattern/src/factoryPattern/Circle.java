package factoryPattern;

import java.util.List;

public class Circle implements Shape {
	double radius;
	Point coordinates;
	
	Circle(Point point, List<Integer> list) {
		coordinates = new Point(point.getX(),point.getY());
		radius = list.get(0);
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

}

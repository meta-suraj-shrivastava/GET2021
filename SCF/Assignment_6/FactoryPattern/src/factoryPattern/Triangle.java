package factoryPattern;

import java.util.Date;
import java.util.List;

public class Triangle implements Shape {
	int base,height;
	Point coordinates;
	String timestamp;
	int id;
	
	
	/*
	 * Constructor takes two argument point object(Screen coordinates)
	 * and list object(Parameter of shapes) 
	 */
	Triangle(Point point, List<Integer> list) {
		base = list.get(0);
		height = list.get(1);
		coordinates = new Point(point.getX(),point.getY());
		timestamp = new Date().toString();
	}
	//***********setters***************
	@Override
	public void setId(int shapeId) {
		id = shapeId;
		
	}
	
	//*************getters************
	@Override
	public Point getOrigin() {
		// TODO Auto-generated method stub
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

	//return area of Triangle
	@Override
	public double getArea() {
		return 0.5*base*height;
	}

	//return parameter of triangle
	@Override
	public double getParameter() {
		double hypo = Math.sqrt((base*base) + (height*height));
		return hypo+base+height;
	}
	@Override
	public boolean isPointClosed() {
		// TODO Auto-generated method stub
		return false;
	}

}

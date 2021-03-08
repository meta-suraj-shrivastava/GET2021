package factoryPattern;

import java.util.Date;
import java.util.List;

public class Square implements Shape {
	int side;
	Point coordinates;
	String timestamp;
	int id;
	
	
	/*
	 * Constructor takes two argument point object(Screen coordinates)
	 * and list object(Parameter of shapes) 
	 */
	public Square(Point point, List<Integer> list) {
		coordinates = new Point(point.getX(),point.getY());
		side = list.get(0);
		timestamp = new Date().toString();
	}
	
	//****************setters***************
	@Override
	public void setId(int shapeId) {
		id = shapeId;
		
	}
	//**************getters**************
	@Override
	public String getTimestamp() {
		return timestamp;
	}
	@Override
	public int getId() {
		return id;
	}

	@Override
	public Point getOrigin() {
		// TODO Auto-generated method stub
		return coordinates;
	}

	@Override
	public boolean isPointClosed(Point point) {
		if(point.getX()>coordinates.getX() &&
				point.getX()<coordinates.getX()+side &&
				point.getY()>coordinates.getY() &&
				point.getY()<coordinates.getY()+side)
				return true;
			return false;
	}

	//return area of square
	@Override
	public double getArea() {
		return side*side;
	}
	//return paramter of square
	@Override
	public double getParameter() {
		return 4*side;
	}
}

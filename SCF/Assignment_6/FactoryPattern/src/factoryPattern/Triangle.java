package factoryPattern;

import java.util.Date;
import java.util.List;

public class Triangle implements Shape {
	int base,height;
	int x1,x2,x3,y1,y2,y3;
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
		x1 = coordinates.getX();
		y1 = coordinates.getY();
		x2 = coordinates.getX()+base;
		y2 = coordinates.getY()+base;
		x3 = coordinates.getX()+height;
		y3 = coordinates.getY()+height;
	}
	//***********setters***************
	@Override
	public void setId(int shapeId) {
		id = shapeId;
		
	}
	
	//*************getters************
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

	//return area of Triangle
	@Override
	public double getArea() 
	{ 
	   return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0); 
	} 

	//return parameter of triangle
	@Override
	public double getParameter() {
		double hypo = Math.sqrt((base*base) + (height*height));
		return hypo+base+height;
	}
	
	//return true if point is inside the triangle and false if not
	@Override
	public boolean isPointEnclosed(Point point) {
		int x = point.getX();
		int y = point.getY();
		double A = area (x1, y1, x2, y2, x3, y3); 
		  
		   /* Calculate area of triangle PBC */   
		double A1 = area (x, y, x2, y2, x3, y3); 
		  
		   /* Calculate area of triangle PAC */   
		double A2 = area (x1, y1, x, y, x3, y3); 
		  
		   /* Calculate area of triangle PAB */    
		double A3 = area (x1, y1, x2, y2, x, y); 
		    
		   /* Check if sum of A1, A2 and A3 is same as A */ 
		return (A == A1 + A2 + A3);
	}
	
	private double area(int x1, int y1, int x2, int y2, int x3, int y3) {
		return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0); 
	}

}

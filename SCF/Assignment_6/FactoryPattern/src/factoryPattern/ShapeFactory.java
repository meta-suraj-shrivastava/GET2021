package factoryPattern;

import java.util.List;

public class ShapeFactory {
	
	
	//factory method that return desired shape object and taking three arguments
	//1.shapeType of string type
	//2.point object contains coordinates of screen
	//3.list object contains all the parameter of the desired shape
	Shape careateShape(String shapeType,Point point,List<Integer> list){
		if(shapeType.equalsIgnoreCase("circle"))
			return new Circle(point,list);
		if(shapeType.equalsIgnoreCase("triangle"))
			return new Triangle(point,list);
		if(shapeType.equalsIgnoreCase("square"))
			return new Square(point,list);
		if(shapeType.equalsIgnoreCase("rectangle"))
			return new Rectangle(point,list);
		return null;
	}
}

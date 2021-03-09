package factoryPattern;

import java.util.List;

public class ShapeFactory {
	//factory method that return desired shape object and taking three arguments
	//1.shapeType of string type
	//2.point object contains coordinates of screen
	//3.list object contains all the parameter of the desired shape
	Shape careateShape(String shapeType,Point point,List<Integer> list){
		if(Shape.shapeTypes.valueOf(shapeType.toUpperCase()) == Shape.shapeTypes.CIRCLE)
			return new Circle(point,list);
		if(Shape.shapeTypes.valueOf(shapeType.toUpperCase()) == Shape.shapeTypes.TRIANGLE)
			return new Triangle(point,list);
		if(Shape.shapeTypes.valueOf(shapeType.toUpperCase()) == Shape.shapeTypes.SQUARE)
			return new Square(point,list);
		if(Shape.shapeTypes.valueOf(shapeType.toUpperCase()) == Shape.shapeTypes.RECTANNGLE)
			return new Rectangle(point,list);
		return null;
	}
}

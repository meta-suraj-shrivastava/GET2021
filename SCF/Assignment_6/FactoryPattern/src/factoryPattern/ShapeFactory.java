package factoryPattern;

import java.util.List;

public class ShapeFactory {

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

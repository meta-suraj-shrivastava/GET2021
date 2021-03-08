package factoryPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Screen {
	int X_MIN = 0;
	int Y_MIN = 0;
	int X_MAX = 100;
	int Y_MAX = 100;
	static int shapeId = 0;
	static ShapeFactory shapeFactory = new ShapeFactory();
	static List<Shape> shapes = new ArrayList<>();
	static List<Integer> list = new ArrayList<>();
	
	//Add the shape to the screen and takes Scanner object as argument
	static void addShape(Scanner sc){
		System.out.println("Enter shape name :");
		String shapeType = sc.next();
		System.out.println("Enter "+shapeType+" coordinate x");
		int xCord = sc.nextInt();
		System.out.println("Enter "+shapeType+" coordinate y");
		int yCord = sc.nextInt();
		Point point = new Point(xCord,yCord);
		getParameter(shapeType,sc);
		Shape shape = shapeFactory.careateShape(shapeType, point, list);
		shape.setId(shapeId++);
		shapes.add(shape);
		
	}
	
	//takes the input of the parameter of a particular shape type and take 
	// two arguments shapeType of string type and Scanner object
	private static void getParameter(String shapeType,Scanner sc) {
		if(shapeType.equalsIgnoreCase("circle")){
			System.out.println("Enter radius");
			list.add(sc.nextInt());
			
		}
		else if(shapeType.equalsIgnoreCase("triangle")){
			System.out.println("Enter base");
			list.add(sc.nextInt());
			System.out.println("Enter height");
			list.add(sc.nextInt());
		}
		else if(shapeType.equalsIgnoreCase("rectangle")){
			System.out.println("Enter width");
			list.add(sc.nextInt());
			System.out.println("Enter height");
			list.add(sc.nextInt());
		}
		else{
			System.out.println("Enter square side");
			list.add(sc.nextInt());
		}
		
	}
	
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("1.Add shape");
			System.out.println("2.Remove shape");
			System.out.println("3.Display shapes");
			System.out.println("4.Check weather given point is enclosed or not");
			System.out.println("5.Sort acc. to timestamp latest to old");
			int option = sc.nextInt();
			switch(option){
			case 1:
				addShape(sc);
				break;
			case 2:
				removeShape(sc);
				break;
			case 3:
				displayShapes();
				break;
			case 4:
				isEnclosed(sc);
				break;
			case 5:
				sortAndDisplay();
				break;
			}
			
			
		}
	}
	
	
	//display the latest added shape first and first at bottom
	private static void sortAndDisplay() {
		for(int index=shapes.size()-1;index>=0;index--){
			System.out.println(shapes.get(index).getId()+"\t"+shapes.get(index).getClass().getSimpleName()+
					"\t ("+shapes.get(index).getOrigin().getX()+","+shapes.get(index).getOrigin().getY()+") \t"+shapes.get(index).getTimestamp());
		}
		
	}

	//takes the scanner Object and print all the shapes that enclosed the given points
	private static void isEnclosed(Scanner sc) {
		System.out.println("Enter x Coordinate");
		int x = sc.nextInt();
		System.out.println("Enter Y coordinate");
		int y = sc.nextInt();
		Point point = new Point(x,y);
		System.out.println("Given point is enclosed in follwing shapes :");
		for(Shape shape:shapes){
			if(shape.isPointClosed(point)){
				System.out.println(shape.getClass().getSimpleName()+"\t"+shape.getTimestamp());
			}
		}
		System.out.println("\n");
		
		
	}

	//Remove shapes from the screen and takes Scanner object as argument
	private static void removeShape(Scanner sc) {
		System.out.println("1.Remove a shape from screen");
		System.out.println("2.Remove all shape from screen of a specific type");
		int choice  = sc.nextInt();
		switch(choice){
		case 1:
			System.out.println("Enter shape Id");
			int id = sc.nextInt();
			for(int index = 0;index<shapes.size();index++){
				if(shapes.get(index).getId()==id){
					shapes.remove(index);
					break;
				}
			}
			break;
		case 2:
			System.out.println("Enter shape Type");
			String shapeType = sc.next();
			ArrayList<Shape> objectsToBeRemove = new ArrayList<>();
			for(Shape shape:shapes){
				if(shapeType.equalsIgnoreCase(shape.getClass().getSimpleName())){
					objectsToBeRemove.add(shape);
				}
			}
			for(Shape shape:objectsToBeRemove){
				shapes.remove(shape);
				
			}
			break;
		}		
		
	}
	
	//display all the shapes present on the screen
	private static void displayShapes() {
		if(shapes.size()==0){
			System.out.println("Screen is Empty");
		}
		else{
			System.out.println("id\tshape\t\tscreen Coordinate\ttimestamp");
			for(Shape shape:shapes){
				System.out.println(shape.getId()+"\t"+shape.getClass().getSimpleName()+
				"\t ("+shape.getOrigin().getX()+","+shape.getOrigin().getY()+") \t"+shape.getTimestamp());
			}
		}
		
	}

}

package factoryPattern;

public class Point {
private int xCoordinate;
private int yCoordinate;
	Point(int x,int y){
		xCoordinate = x;
		yCoordinate = y;
	}
	
	int getX(){
		return xCoordinate;
	}
	int getY(){
		return yCoordinate;
	}
}

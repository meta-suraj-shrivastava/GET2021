package areaCalc;

public class Area {
	
	/*
	 * Params :- radius
	 * return :- area of circle
	 */
	double circle(double radius){
		double PI = 3.14;
		
		return PI*radius*radius;
	}
	/*
	 * Params :- height,width
	 * return :- area of triangle
	 */
	double triangle(double height,double width){
		return 0.5*width*height;
	}
	
	/*
	 * Params :- height,width
	 * return :- area of rectangle
	 */
	double rectangle(double height,double width){
		return height*width;
	}
	/*
	 * Params :- width
	 * return :- area of square
	 */
	double square(double width){
		return width*width;
	}
}

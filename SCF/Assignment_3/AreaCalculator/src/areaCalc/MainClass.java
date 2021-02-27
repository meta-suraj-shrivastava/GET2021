package areaCalc;
import java.util.Scanner;
public class MainClass {

	public static void main(String[] args){
		Area area = new Area();
		double width,height;
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------Area Calculator-----------");
		while(true){
			System.out.println("1.Circle");
			System.out.println("2.Square");
			System.out.println("3.Rectangle");
			System.out.println("4.Triangle");
			System.out.println("5.Exit");
			System.out.println("\nEnter option number :");
			int option = sc.nextInt();
			switch(option){
			case 1:
				System.out.println("Enter radius :");
				double radius  = sc.nextDouble();
				System.out.println(area.circle(radius));  //Calling circle function
				break;
			case 2:
				System.out.println("Enter width :");
				width  = sc.nextDouble();
				System.out.println(area.square(width)); //Calling square function
				break;
			case 3:
				System.out.println("Enter width :");
				width  = sc.nextDouble();
				System.out.println("Enter height :");
				height  = sc.nextDouble();
				System.out.println(area.rectangle(height, width));
				break;
			case 4:
				System.out.println("Enter width :");
				width  = sc.nextDouble();
				System.out.println("Enter height :");
				height  = sc.nextDouble();
				System.out.println(area.triangle(height, width));
				break;
			default:
				return;
				
			}
		}
	}
}

package areaCalc;
import java.util.Scanner;
public class MainClass {
	static double width,height,radius;
	
	//this function take user Input argument scanner object and inputType
	static void input(Scanner sc,int inputType){
		// inputType 0 for taking radius input
		if(inputType==0){ 			
			System.out.println("Enter radius :");
			radius  = sc.nextDouble();
		}
		
		// inputType 1 for taking width input
		else if(inputType==1){ 
			System.out.println("Enter width :");
			width  = sc.nextDouble();
		}
		// inputType 2 or any other number for taking width & height input
		else{ 
			System.out.println("Enter width :");
			width  = sc.nextDouble();
			System.out.println("Enter height :");
			height  = sc.nextDouble();
		}
	}
	
	
	public static void main(String[] args){
		Area area = new Area();
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
				input(sc,0);
				System.out.println(area.circle(radius));  //Calling circle function
				break;
			case 2:
				input(sc,1);
				System.out.println(area.square(width)); //Calling square function
				break;
			case 3:
				input(sc,2);
				System.out.println(area.rectangle(height, width));
				break;
			case 4:
				input(sc,2);
				System.out.println(area.triangle(height, width));
				break;
			default:
				return;
				
			}
		}
	}
}

package polynomial;
import java.util.Scanner;
import java.util.ArrayList;
public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter degree of Polynomial");
		int deg =  sc.nextInt();
		int []  pol = new int[deg+1];
		for(int i=0;i<deg+1;i++)
			pol[i]=sc.nextInt();
		Polynomial poly = new Polynomial(pol);
		while(true){
			System.out.println("1.Evaluate");
			System.out.println("2.Degree");
			System.out.println("3.Add two poly");
			System.out.println("4.multiply Polynomial");
			System.out.println("\nEnter option :");
			int option = sc.nextInt();
			switch(option){
			case 1:
				System.out.println("Enter a value");
				float value = sc.nextFloat();
				System.out.println(poly.evaluate(value));
				break;
			case 2:
				System.out.println(poly.degree());
				break;
			case 3:
				addTwoPoly(sc,poly);
				break;
			default:
				return;
			}
		}

	}
	
	static void printPoly(int[] poly){
		for(int data:poly)
			System.out.print(data+" ");
		System.out.println();
		
	}

	private static void addTwoPoly(Scanner sc, Polynomial poly) {
		System.out.println("Enter degree of first Polynomial ");
		int deg =  sc.nextInt();
		int []  polOne = new int[deg+1];
		System.out.println("Enter Coff. :");
		for(int i=0;i<deg+1;i++)
			polOne[i]=sc.nextInt();
		System.out.println("Enter degree of second Polynomial ");
		deg =  sc.nextInt();
		int []  polTwo = new int[deg+1];
		System.out.println("Enter Coff. :");
		for(int i=0;i<deg+1;i++)
			polTwo[i]=sc.nextInt();
		Polynomial polyOne = new Polynomial(polOne);
		Polynomial polyTwo = new Polynomial(polTwo);
		printPoly(poly.addPoly(polyOne, polyTwo));
		
		
	}

}

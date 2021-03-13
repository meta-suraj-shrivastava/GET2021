package linkedList;
import java.util.Scanner;
public class MainClass {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		MyLinkedList list = new MyLinkedList();
		while(true){
		System.out.println("1.Add data to list");
		System.out.println("2.Display List");
		System.out.println("3.Rotate SubList");
		System.out.println("4.Detect Loop");
		System.out.println("5.create multivariable polyNomial");
		System.out.println("6.Exit");
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			System.out.println("Enter total number of data");
			int totalData = sc.nextInt();
			for(int index = 0;index < totalData;index++){
				list.add(sc.nextInt());
			}
			break;
		case 2:
			list.displayList();
			break;
		case 3:
			System.out.println("Enter Left");
			int left = sc.nextInt();
			System.out.println("Enter right");
			int right = sc.nextInt();
			System.out.println("Enter number of Rotation");
			int numberOfRotation = sc.nextInt();
			list.rotateSubList(left, right, numberOfRotation);
			break;
		case 4:
			System.out.println(list.detectLoop());
			break;
		case 5:
			multiVariablePoly();
		default:
			return;
		}
		}
		
	}

	//handle the multivariable polynomail operation like getDegree or displayPolyNomail
	private static void multiVariablePoly() {
		MultiVariablePolynomial poly = new MultiVariablePolynomial();
		while(true){
			System.out.println("1.Add polynomial term");
			System.out.println("2.Display Polynomial");
			System.out.println("3.get polynomial degree");
			System.out.println("4.exit");
			int choice  = sc.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter number of variable of "+poly.len+" term");
				int var = sc.nextInt();
				int [] expo = new int[var];
				System.out.println("Enter coeff. of "+poly.len+" term");
				int coeff = sc.nextInt();
				for(int index=0;index<var;index++){
					System.out.println("Enter exponent of "+poly.availableVar[index]);
					expo[index] = sc.nextInt();
				}
				poly.addterm(coeff,expo);
			break;
			case 2:
				System.out.println(poly.displayPoly());
				break;
			case 3:
				System.out.println("\nDegree :"+poly.getDegree()+"\n");
				break;
			default:
				return;
				
				
			}
			
		}
		
	}
}

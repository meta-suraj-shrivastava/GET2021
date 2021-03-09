package arrayOperation;

import java.util.Scanner;

public class MainClass {
	
	static int [] array;
	
	//takes the array Input from the user
	static void getArrayInput(Scanner sc){
		System.out.println("Enter size of Array");
		int size = sc.nextInt();
		array = new int[size];
		System.out.println("Enter elements of Array");
		for(int index=0;index<size;index++){
			array[index] = sc.nextInt();
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayOperation arrayOp = new ArrayOperation();
		while(true){
			System.out.println("1.largest mirror in array is of length :");
			System.out.println("2.Number of clumps in array");
			System.out.println("3.fixXY");
			System.out.println("4.Find split Array Index");
			System.out.println("5.Exit");
			int choice =  sc.nextInt();
			switch(choice){
			case 1:
				getArrayInput(sc);
				System.out.println("\nAns :"+arrayOp.largestMirror(array)+"\n");
				break;
			case 2:
				getArrayInput(sc);
				System.out.println("\nAns :"+arrayOp.countClump(array)+"\n");
				break;
			
			case 3:
				getArrayInput(sc);
				System.out.println("Enter x");
				int x = sc.nextInt();
				System.out.println("Enter y");
				int y = sc.nextInt();
				displayArray();
				break;
			case 4:
				getArrayInput(sc);
				System.out.println("\nAns :"+arrayOp.getSplitIndex(array)+"\n");
				break;
			default:
				return;
				}
		}
	}

	//display the array
	private static void displayArray() {
		int index = -1;
		while(++index<array.length){
			System.out.print(array[index]+" ");
		}
		System.out.println();
		
	}
}

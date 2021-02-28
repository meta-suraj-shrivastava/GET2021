package immutableSet;

import java.util.Scanner;
import java.util.ArrayList;
public class MainClass {

	static boolean isSubset(IntSet immutableSet,Scanner sc ){
		ArrayList<Integer> subset = new ArrayList<>();
		System.out.println("Enter number of elements");
		int totalElement = sc.nextInt();
		System.out.println("Enter the set elements :");
		for(int i=0;i<totalElement;i++)
			subset.add(sc.nextInt());
		IntSet immutableSubset = new IntSet(subset);
		return immutableSet.isSubset(immutableSubset);
	}
	static void union(IntSet immutableSet,Scanner sc){
		ArrayList<Integer> setOne = new ArrayList<>();
		ArrayList<Integer> setTwo = new ArrayList<>();
		System.out.println("Enter number of elements for first set");
		int totalElement = sc.nextInt();
		System.out.println("Enter the elements of first set :");
		for(int i=0;i<totalElement;i++)
			setOne.add(sc.nextInt());
		System.out.println("Enter number of elements for second set");
		totalElement = sc.nextInt();
		System.out.println("Enter the elements of second set :");
		for(int i=0;i<totalElement;i++)
			setTwo.add(sc.nextInt());
		IntSet immutableSetOne= new IntSet(setOne);
		IntSet immutableSetTwo= new IntSet(setTwo);
		printArray(immutableSet.union(immutableSetOne, immutableSetTwo));
	}
	
	static void printArray(ArrayList<Integer> array){
		for(int data:array)
			System.out.print(data+" ");
		System.out.println();
	}
	
	
	
	public static void main(String[] args){
		ArrayList<Integer> set = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of element :");
		int totalElement = sc.nextInt();
		System.out.println("Enter the set elements :");
		for(int i=0;i<totalElement;i++)
			set.add(sc.nextInt());
		IntSet immutableSet = new IntSet(set);
		while(true){
			System.out.println("1.is member");
			System.out.println("2.Size");
			System.out.println("3.is Subset");
			System.out.println("4.Complement");
			System.out.println("5.Union of two set");
			System.out.println("6.Exit");
			System.out.println("\nEnter option :");
			int option = sc.nextInt();
			switch(option){
			case 1:
				System.out.println("Enter your element");
				int input = sc.nextInt();
				System.out.println(immutableSet.isMember(input));
				break;
			case 2:
				System.out.println(immutableSet.size());
				break;
			case 3:
				System.out.println(isSubset(immutableSet,sc));
				break;
			case 4:
				printArray(immutableSet.getComplement());
				break;
			case 5:
				union(immutableSet,sc);
				break;
			default:
				return;
			}
		}
	}
}

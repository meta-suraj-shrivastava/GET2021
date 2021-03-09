package clump;

import java.util.Scanner;

public class MainClass {

	
	
	public static void main(String[] args){
		Clump clump = new Clump();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int arraySize = sc.nextInt();
		System.out.println("Enter array elements");
		int[] array = new int[arraySize];
		
		//taking array input
		for(int index=0;index<arraySize;index++){
			array[index] = sc.nextInt();
		}
		System.out.println("Total number of clumps :"+clump.countClump(array,arraySize));
		
	}
}

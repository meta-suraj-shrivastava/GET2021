package splitArray;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SplitArray splitArray = new SplitArray();
		System.out.println("Enter size of Array");
		int size = sc.nextInt();
		int [] array = new int[size];
		System.out.println("Enter elements of Array");
		for(int index=0;index<size;index++){
			array[index] = sc.nextInt();
		}
		System.out.println(splitArray.getSplitIndex(array, size));
	}
}

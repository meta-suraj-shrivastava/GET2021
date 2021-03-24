package collections;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("1.Add employee");
			System.out.println("2.natural Order sort");
			System.out.println("3.Sort acc. to name");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter");
				break;

			default:
				break;
			}
		}
	}
}

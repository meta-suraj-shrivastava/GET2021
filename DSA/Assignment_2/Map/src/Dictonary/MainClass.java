package Dictonary;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args){
		BinMap map = new BinMap();
		int key;
		Scanner sc = new Scanner(System.in);
		while(true){
		System.out.println("1.Enter data and key");
		System.out.println("2.Delete Node");
		System.out.println("3.find");
		System.out.println("4.display");
		int choice = sc.nextInt();
		switch(choice){
			case 1:
				key = sc.nextInt();
				String value = sc.next();
				map.insert(key, value);
				break;
			case 2:
				System.out.println("Enter key to be deleted");
				key = sc.nextInt();
				Node deletedNode = map.delete(key);
				System.out.println(deletedNode.key+":"+deletedNode.value);
				break;
			case 3:
				key  = sc.nextInt();
				System.out.println(map.getValue(key));
				break;
			case 4:
				map.display();
				break;
			default:
				return;
				}
		}
	}
}

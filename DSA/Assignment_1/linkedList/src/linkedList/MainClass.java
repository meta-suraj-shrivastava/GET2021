package linkedList;
import java.util.Scanner;
public class MainClass {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		MyLinkedList list = new MyLinkedList();
		while(true){
		System.out.println("1.Add data to list");
		System.out.println("2.Display List");
		System.out.println("3.Rotate SubList");
		System.out.println("4.Detect Loop");
		System.out.println("5.Exit");
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
		default:
			return;
		}
		}
		
	}
}

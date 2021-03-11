package linkedList;
import java.util.Scanner;
public class MainClass {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		MyLinkedList list = new MyLinkedList();
		while(true){
		System.out.println("1.Add data to list");
		System.out.println("2.Display List");
		System.out.println("3.Exit");
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
		default:
			return;
		}
		}
		
	}
}

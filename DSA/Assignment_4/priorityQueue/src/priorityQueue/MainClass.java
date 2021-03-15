package priorityQueue;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		System.out.println("Enter queue total Size");
		int size = sc.nextInt();
		PriorityQueue queue = new PriorityQueue(size);
		while(true){
			System.out.println("1.Add to queue");
			System.out.println("2.Remove from queue");
			System.out.println("3.Peek");
			System.out.println("4.Display");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter element");
				queue.enqueue(sc.nextInt());
				break;
			case 2:
				queue.deQueue();
				break;
			case 3:
				System.out.println(queue.peek());
				break;
			case 4:
				queue.display();
				break;
			default:
				sc.close();
				return;
			}
		}
	}
}

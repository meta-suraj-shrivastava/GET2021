package priorityQueue;

import java.util.Scanner;

public class MainClass {
	static Scanner sc =  new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter queue total Size");
		int size = sc.nextInt();
		PriorityQueue queue = new PriorityQueue(size);
		while(true){
			System.out.println("1.Add to queue");
			System.out.println("2.Remove from queue");
			System.out.println("3.Peek");
			System.out.println("4.Display");
			System.out.println("5.Virat kholi Strategy");
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
			case 5:
				vKohli();
				break;
			default:
				sc.close();
				return;
			}
		}
	}

	//method to solve virat kohli problem using priority Queue
	private static void vKohli() {
		while(true){
			System.out.println("Enter total number of bowlers or negative number to return main Menu");
			int bowlers = sc.nextInt();
			if(bowlers < 0) return;
			PriorityQueue queue = new PriorityQueue(bowlers);
			System.out.println("Total number of bowls virat going to play");
			int totalBowl = sc.nextInt();
			System.out.println("Enter number of bowls remaining for each player");
			while(totalBowl > 0){
				int bowlLeft = sc.nextInt();
				queue.enqueue(bowlLeft);
				totalBowl-=bowlLeft;
			}
			queue.displayForVkohli();
			
		}
		
	}
}

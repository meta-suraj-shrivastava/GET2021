package queueImp;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyQueue queue =  new MyQueue();
		while(true){
			System.out.println("1. Add to queue");
			System.out.println("2. remove from queue");
			System.out.println("3. is Queue full");
			System.out.println("4. is Queue empty");
			System.out.println("5. Display Queue");
			System.out.println("6. Exit");
			int choice = sc.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter number");
				int number = sc.nextInt();
				queue.enqueue(number);
				break;
			case 2:
				System.out.println(queue.deQueue());
				break;
			case 3:
				System.out.println(queue.isFull());
				break;
			case 4:
				System.out.println(queue.isEmpty());
				break;
			case 5:
				queue.display();
				break;
			default:
				return;
				
				
			}
		}

	}

}

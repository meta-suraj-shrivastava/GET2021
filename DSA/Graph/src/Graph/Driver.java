package Graph;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Graph graph = new Graph();
		while(true){
			System.out.println("1.Enter edge");
			System.out.println("2.Is connected");
			System.out.println("3.Is Reacable");
			System.out.println("4.Get total Node");
			System.out.println("5.Display Graph");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Source node name");
				char source = sc.next().charAt(0);
				System.out.println("Enter destination node name");
				char destination = sc.next().charAt(0);
				System.out.println("Enter weight");
				int weight = sc.nextInt();
				graph.addNode(weight, source, destination);
				break;
			case 4:
				System.out.println("Total nodes "+graph.getTotalNode());
				break;
			case 5:
				graph.displayGraph();
				break;
			default:
				sc.close();
				break;
			}
		}
	}
}

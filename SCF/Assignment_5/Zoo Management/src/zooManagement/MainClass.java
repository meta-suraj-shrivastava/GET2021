package zooManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	static ArrayList<Zone> zones = new ArrayList<>();
	
	
	//takes animal Object and add the animal to its type of zone and it also
	//takes the scanner object as second argument
	public static void addAnimal(Animal animal,Scanner sc){
		System.out.println("Enter "+animal.getAnimalName()+" name");
		animal.setName(sc.next());
		System.out.println("Enter "+animal.getAnimalName()+" age");
		animal.setAge(sc.nextDouble());
		System.out.println("Enter "+animal.getAnimalName()+" weight");
		animal.setWeight(sc.nextDouble());
		boolean success = false;
		for(Zone zone:zones){
			if(zone.getCategory()==animal.getType()){
				success = zone.addAnimal(animal);	
			}
		}
		if(!success){
			Zone newZone = new Zone();
			newZone.setCategory(animal.getType());
			newZone.addAnimal(animal);
			zones.add(newZone);
		}
	}
	
	//display all the zones in the zoo
	public static void displayZoo(){
		if(zones.size()==0){
			System.out.println("Zoo is empty");
		}
		for(Zone zone:zones){
			System.out.println("************"+zone.getCategory()+"************");
			zone.dispayCages();
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("1.Add Lion");
			System.out.println("2.Add Monkey");
			System.out.println("3.Add Cow ");
			System.out.println("4.Add Snake");
			System.out.println("5.Add Turtle");
			System.out.println("6.Add Lizard");
			System.out.println("7.Add Crane");
			System.out.println("8.Add Parrot");
			System.out.println("9.Add Owl");
			System.out.println("10.Display Zoo");
			System.out.println("11.Exit");
			int option = sc.nextInt();
			switch(option){
			case 1:
				Animal lion = new Lion();
				addAnimal(lion,sc);
				break;
			case 2:
				Animal monkey = new Monkey();
				addAnimal(monkey,sc);
				break;
			case 3:
				Animal cow = new Cow();
				addAnimal(cow,sc);
				break;
			case 4:
				Animal snake = new Snake();
				addAnimal(snake,sc);
				break;
			case 5:
				Animal turtle = new Turtle();
				addAnimal(turtle,sc);
				break;
			case 6:
				Animal lizard = new Lizard();
				addAnimal(lizard,sc);
				break;
			case 7:
				Animal crane = new Crane();
				addAnimal(crane,sc);
				break;
			case 8:
				Animal parrot = new Parrot();
				addAnimal(parrot,sc);
				break;
			case 9:
				Animal owl = new Owl();
				addAnimal(owl,sc);
				break;
			case 10:
				displayZoo();
				break;
			default:
				return;
			}
		}
	}
}

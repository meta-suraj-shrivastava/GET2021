package zooManagement;

import java.util.ArrayList;

public class Cage {
	private final int MAX_CAP = 3;
	String type;
	private ArrayList<Animal> animals = new ArrayList<>();
	
	
	//***********setter***************
	void setType(String animalType){
		type = animalType;
	}
	//***********getters***************
	String getType(){
		return type;
		
	}
	int getCap(){
		return MAX_CAP;
	}
	
	int getCurrentCap(){
		return animals.size();
	}
	ArrayList<Animal> getAnimals(){
		return animals;
	}
	//takes an animal as an argument and add to the cage
	public void addAnimal(Animal animal) {
		setType(animal.getAnimalName());
		animals.add(animal);
		
	}

	//show all the animals present in the cage
	public void showAnimals() {
		System.out.println("ID\tName\tSound");
		for(Animal animal:animals){
			System.out.println(animal.getId()+"\t"+animal.getName()+"\t"+animal.getSound());
		}
		
	}
	

}

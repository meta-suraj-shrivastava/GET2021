package zooManagement;

import java.util.ArrayList;

public class Cage {
	private final int MAX_CAP = 3;
	private int currentCap = 0;
	String type;
	ArrayList<Animal> animals = new ArrayList<>();
	
	void setType(String animalType){
		type = animalType;
	}
	
	String getType(){
		return type;
		
	}
	int getCap(){
		return MAX_CAP;
	}
	
	int getCurrentCap(){
		return currentCap;
	}

	public void addAnimal(Animal animal) {
		setType(animal.getAnimalName());
		animals.add(animal);
		currentCap++;
		
	}

	public void showAnimals() {
		int count=0;
		for(Animal animal:animals){
			System.out.println(++count+"."+animal.getName());
		}
		
	}
	

}

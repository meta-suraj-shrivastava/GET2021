package zooManagement;

import java.util.ArrayList;

public class Zone {
	private final int MAX_CAGE = 3;
	String category;
	boolean hasPark;
	boolean hasCanteen;
	private ArrayList<Cage> cages = new ArrayList<>();
	
	//setter
	void setCategory(String cat){
		category  = cat;
	}
	//getter
	String getCategory(){
		return category;
	}
	ArrayList<Cage> getCages(){
		return cages;
	}
	
	//takes animal object as an argument and add to the specific type of cage
	//will assign new cage if cage is Full
	boolean addAnimal(Animal animal){
		if(cages.size()==MAX_CAGE){
			return false;
		}
		boolean animalAdded = false;
		for(Cage cage:cages){
			if(cage.getCurrentCap()<cage.getCap() && cage.getType()==animal.getAnimalName()){
				cage.addAnimal(animal);
				animalAdded = true;
				break;
			}
		}
		if(!animalAdded){
			Cage cage = new Cage();
			cage.addAnimal(animal);
			cages.add(cage);
		}
		return true;
	}

	//display all the cages in the zone
	public void dispayCages() {
		for(Cage cage:cages){
			System.out.println("*********CAGE :"+cage.getType()+"*********");
			cage.showAnimals();
		}
		
	}
}

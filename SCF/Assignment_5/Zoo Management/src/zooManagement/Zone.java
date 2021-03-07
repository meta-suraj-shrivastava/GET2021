package zooManagement;

import java.util.ArrayList;

public class Zone {
	private final int MAX_CAGE = 3;
	String category;
	boolean hasPark;
	boolean hasCanteen;
	ArrayList<Cage> cages = new ArrayList<>();
	
	void setCategory(String cat){
		category  = cat;
	}
	
	String getCategory(){
		return category;
	}
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

	public void dispayCages() {
		for(Cage cage:cages){
			System.out.println("CageType---->"+cage.getType());
			cage.showAnimals();
		}
		
	}
}

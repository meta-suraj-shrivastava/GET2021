package zooManagement;

public class Lion extends Mammal {
	Lion(){
		super();
		animalName = "lion";
	}
	@Override
	String getSound() {
		return "Roar";
	}
	void setAge(double inputAge){
		age = inputAge;
	}
	void setWeight(double inputWeight){
		weight = inputWeight;
	}
	
	void setDead(boolean isDead){
		dead = isDead;
	}
	String getName(){
		return name;
	}
	
	String getType(){
		return type;
	}
	@Override
	String getAnimalName() {
		return animalName;
	}
	@Override
	int getId() {
		return 0;
	}
	@Override
	void setName(String nameInp) {
		name = nameInp;
		
	}
}

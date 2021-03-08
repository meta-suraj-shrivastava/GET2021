package zooManagement;

public class Lion extends Mammal {
	
	//Constructor initializing the animalName
	Lion(){
		super();
		animalName = "lion";
	}
	//***********setters******************
	@Override
	void setId(int animalId) {
		id = animalId;
	}
		
	
	@Override
	void setName(String nameInp) {
		name = nameInp;
		
	}
	@Override
	void setAge(double inputAge){
		age = inputAge;
	}
	@Override
	void setWeight(double inputWeight){
		weight = inputWeight;
	}
	@Override
	void setDead(boolean isDead){
		dead = isDead;
	}
	
	//**************getters****************
	@Override
	String getName(){
		return name;
	}
	@Override
	String getType(){
		return type;
	}
	@Override
	String getAnimalName() {
		return animalName;
	}
	@Override
	int getId() {
		return id;
	}
	@Override
	String getSound() {
		return "Roar";
	}
}

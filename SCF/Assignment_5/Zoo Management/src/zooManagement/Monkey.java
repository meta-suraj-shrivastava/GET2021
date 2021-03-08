package zooManagement;

public class Monkey extends Mammal {
	
	//Constructor initializing the animalName
	Monkey(){
		super();
		animalName = "monkey";
	}

	//*************setters****************
	@Override
	void setId(int animalId) {
		id = animalId;
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
	@Override
	void setName(String nameInp){
		name = nameInp;
	}
	//**************getters***************
	@Override
	String getSound() {
		return "Chatter";
	}
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
}

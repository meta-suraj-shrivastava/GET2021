package zooManagement;

public class Parrot extends Bird {
	
	//Constructor initializing the animalName
	Parrot(){
		super();
		animalName = "parrot";
	}
	
	//************setters******************
	@Override
	void setAge(double inputAge){
		age = inputAge;
	}
	
	@Override
	void setWeight(double inputWeight){
		weight = inputWeight;
	}
	
	@Override
	void setName(String nameInp){
		name = nameInp;
	}
	
	@Override
	void setDead(boolean isDead){
		dead = isDead;
	}
	
	
	//**************getters*******************
	@Override
	String getName(){
		return name;
	}
	
	@Override
	String getSound() {
		return "screech";
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
		// TODO Auto-generated method stub
		return 0;
	}
}

package zooManagement;

public class Parrot extends Bird {
	Parrot(){
		super();
		animalName = "parrot";
	}
	@Override
	String getSound() {
		return "screech";
	}
	void setAge(double inputAge){
		age = inputAge;
	}
	void setWeight(double inputWeight){
		weight = inputWeight;
	}
	void setName(String nameInp){
		name = nameInp;
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
		// TODO Auto-generated method stub
		return 0;
	}
}

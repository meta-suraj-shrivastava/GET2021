package zooManagement;

public class Owl extends Bird {
	Owl(){
		super();
		animalName = "owl";
	}
	@Override
	String getSound() {
		return "hoot";
	}
	
	void setName(String nameInp){
		name = nameInp;
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
	String getAnimalName(){
		return animalName;
	}
	
	String getType(){
		return type;
	
}
	@Override
	int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}

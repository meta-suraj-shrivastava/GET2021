package zooManagement;

public class Turtle extends Reptile {
	Turtle(){
		super();
		animalName = "turtle";
	}
	@Override
	String getSound() {
		return "Cluck";
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
	void setName(String nameInp){
		name = nameInp;
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

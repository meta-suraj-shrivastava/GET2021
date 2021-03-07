package zooManagement;

public class Cow extends Mammal {
	Cow(){
		super();
		animalName = "cow";
	}
	@Override
	String getSound() {
		return "Moo";
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
		return 0;
	}
}

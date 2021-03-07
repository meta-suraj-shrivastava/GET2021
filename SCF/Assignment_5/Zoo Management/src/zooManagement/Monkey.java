package zooManagement;

public class Monkey extends Mammal {
	Monkey(){
		super();
		animalName = "monkey";
	}
	@Override
	String getSound() {
		return "Chatter";
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
		// TODO Auto-generated method stub
		return animalName;
	}
	@Override
	int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}

package zooManagement;

public class Snake extends Reptile {
	Snake(){
		super();
		animalName = "sanke";
	}
	@Override
	String getSound() {
		return "Hiss";
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
		// TODO Auto-generated method stub
		return animalName;
	}
	@Override
	int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}

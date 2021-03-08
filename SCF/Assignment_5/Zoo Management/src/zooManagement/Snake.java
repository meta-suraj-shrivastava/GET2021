package zooManagement;

public class Snake extends Reptile {
	
	//Constructor initializing the animalName
	Snake(){
		super();
		animalName = "sanke";
	}

	//**********setters**************
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
	//****************getters*****************
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
		// TODO Auto-generated method stub
		return animalName;
	}
	@Override
	int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	String getSound() {
		return "Hiss";
	}
}

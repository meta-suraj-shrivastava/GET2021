package zooManagement;

public class Crane extends Bird {
	
	//Constructor initializing the animalName
	Crane(){
		super();
		animalName = "crane";
	}	

	//***********setters***************
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
	//**************getters*******************
	@Override
	String getName(){
		return name;
	}
	@Override
	String getType(){
		return type;
	
	}
	@Override
	String getSound() {
		return "moans";
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

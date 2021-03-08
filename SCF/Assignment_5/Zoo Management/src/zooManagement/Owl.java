package zooManagement;

public class Owl extends Bird {
	
	//Constructor initializing the animalName
	Owl(){
		super();
		animalName = "owl";
	}

	//************setters******************
	@Override
	void setId(int animalId) {
		id = animalId;
	}
	@Override
	void setName(String nameInp){
		name = nameInp;
	}
	@Override
	void setAge(double inputAge){
		age = inputAge;
	}
	@Override
	void setWeight(double inputWeight){
		weight = inputWeight;
	}
	
	//**************getters*******************
	@Override
	String getName(){
		return name;
	}
	@Override
	String getAnimalName(){
		return animalName;
	}
	@Override
	String getType(){
		return type;
	
	}
	@Override
	String getSound() {
		return "hoot";
	}
	@Override
	int getId() {
		// TODO Auto-generated method stub
		return id;
	}
}

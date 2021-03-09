package zooManagement;

public abstract class Animal {
protected String animalName;
protected String type;
protected double weight;
protected double age;
protected int id;
protected String name;

abstract String getSound();  //return the sound of animal
abstract String getAnimalName(); //return the name of the animal like lion,snake etc
abstract String getType(); //return the type of the animal like mammal,reptile etc.
abstract String getName(); //return the name of a animal like there will be a name of lion,snake
abstract void setName(String nameInp); //set the name of the animal ,will take string as arg.
abstract void setAge(double age); //set the age of the animal ,will take double as argument
abstract void setWeight(double weight); //set the weight of the animal , will take double value
abstract void setId(int animalId); //set the id of a animal ,will take int argument
abstract int getId(); //return the id of the animal
}

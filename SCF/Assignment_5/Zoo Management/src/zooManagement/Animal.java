package zooManagement;

public abstract class Animal {
protected String animalName;
protected String type;
protected double weight;
protected double age;
protected int id;
protected String name;
protected boolean dead = false;

abstract String getSound();
abstract String getAnimalName();
abstract String getType();
abstract String getName();
abstract void setName(String nameInp);
abstract void setAge(double age);
abstract void setWeight(double weight);
abstract int getId();
}
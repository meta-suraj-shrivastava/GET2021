package Dictonary;


import java.util.Iterator;
import java.util.Scanner;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import linkedList.EmployeeList;
public class MainClass {

	//initializing the Scanner object to take input
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		final String JSON_FILE="json.txt"; //JSON file name
		InputStream file = new FileInputStream(JSON_FILE);  //creating object of that file
		JsonReader jsonReader = Json.createReader(file); //initializing the JSON reader to read the json file
		JsonObject jsonObject = jsonReader.readObject(); //reading the json object
		jsonReader.close();
		file.close();
		Iterator<String> keys = jsonObject.keySet().iterator();  //get the set of the keys in JSON file
		Iterator<JsonValue> values = jsonObject.values().iterator(); //get the values of the keys in JSON file
		BinMap map = new BinMap(keys,values);  // initializing the BST
		String key;
		while(true){
		System.out.println("1.Enter data");
		System.out.println("2.Delete Node");
		System.out.println("3.find");
		System.out.println("4.display");
		System.out.println("5.Get all key pairs Key>=k1 and <=K2");
		System.out.println("6.Employee Linked List");
		System.out.println("7.Exit");
		int choice = sc.nextInt();
		switch(choice){
			case 1:
				System.out.println("1.Enter key");
				key = sc.next();
				System.out.println("1.Enter value");
				String value = sc.next();
				map.insert(key, value);
				break;
			case 2:
				System.out.println("Enter key to be deleted");
				key = sc.next();
				map.delete(key);
				break;
			case 3:
				key  = sc.next();
				System.out.println(map.getValue(key));
				break;
			case 4:
				map.display();
				break;
			case 5:
				System.out.println("Enter lower bound");
				String lowerBound = sc.next();
				System.out.println("Enter upper bound");
				String upperBound = sc.next();
				map.getKeyPairsBetween(lowerBound,upperBound);
				break;
			case 6:
				employeeLinkedList();
				break;
			default:
				return;
				}
		}
	}

	//Handle the Employee linked list related task
	private static void employeeLinkedList() {
		EmployeeList list = new EmployeeList();
		while(true){
			System.out.println("1.Enter Employee node");
			System.out.println("2.Sort");
			System.out.println("3.display list");
			System.out.println("4.Exit");
			int choice = sc.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter Employee salary");
				int salary = sc.nextInt();
				System.out.println("Enter Employee age");
				int age = sc.nextInt();
				list.insert(salary,age);
				break;
			case 2:
				list.sort();
				list.display();
				break;
			case 3:
				list.display();
				break;
			default:
				return;
				
			}
		}
		
	}
}

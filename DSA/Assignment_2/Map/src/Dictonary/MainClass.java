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

public class MainClass {

	public static void main(String[] args) throws IOException {
		final String JSON_FILE="json.txt";
		InputStream fis = new FileInputStream(JSON_FILE);
		JsonReader jsonReader = Json.createReader(fis);
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		fis.close();
		
		Iterator<String> keys = jsonObject.keySet().iterator();
		Iterator<JsonValue> values = jsonObject.values().iterator();
		BinMap map = new BinMap(keys,values);
		String key;
		Scanner sc = new Scanner(System.in);
		while(true){
		System.out.println("1.Enter data");
		System.out.println("2.Delete Node");
		System.out.println("3.find");
		System.out.println("4.display");
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
				Node deletedNode = map.delete(key);
				System.out.println(deletedNode.key+":"+deletedNode.value);
				break;
			case 3:
				key  = sc.next();
				System.out.println(map.getValue(key));
				break;
			case 4:
				map.display();
				break;
			default:
				return;
				}
		}
	}
}

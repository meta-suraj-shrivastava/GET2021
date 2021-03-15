package counselling;

import java.io.IOException;


public class MainClass {

	
	public static void main(String[] args) throws IOException{
		Counselling counselling = new Counselling();
		
		counselling.readFile("student.xlsx", "college.xlsx");
		counselling.intializePrograms();		
		counselling.allocate();
		counselling.save();
		
	}
}

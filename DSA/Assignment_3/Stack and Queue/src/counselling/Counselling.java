package counselling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;


//This class Provide different methods to perform counselling process
public class Counselling {
	private int TOTAL_PROGRAM = 5;
	private XSSFWorkbook studentWb,collegeWb,allocatedSheet;
	private XSSFSheet studentSheet,collegeSheet;
	private int totalStudents,availablePrograms;
	HashMap<String,String> allocated = new HashMap<>();
	HashMap<String,Integer> availableProg = new HashMap<>();
	
	
	
	//read the files of students with their preferences and programs provided by the college and the available seat
	//@params - studentFile:String , programsFileName:String
	void readFile(String studentFileName,String progarmsFileName) throws IOException{
		FileInputStream studentFile=new FileInputStream(new File(studentFileName));  
		FileInputStream collegeFile=new FileInputStream(new File(progarmsFileName)); 
		studentWb=new XSSFWorkbook(studentFile);   
		collegeWb=new XSSFWorkbook(collegeFile);
		studentSheet=studentWb.getSheetAt(0); 
		collegeSheet=collegeWb.getSheetAt(0);
		studentFile.close();
		collegeFile.close();
		totalStudents = studentSheet.getLastRowNum();
		availablePrograms  = collegeSheet.getLastRowNum();
	}
	
	
	//allocate the program to the student based on their preference and merit
	private void allocate(String[] studentQueue,String[][] studentPref){
		for(String student:studentQueue){
			int index = 0;
				for(String prefrence:studentPref[index]){
					int availableSeats = availableProg.get(prefrence);
					if(availableSeats>0){
						allocated.put(student, prefrence);
						availableProg.put(prefrence, availableSeats-1);
						break;
					}
			}
				index++;
		}
	}
	
	
	//read all the available programs and available seats and store them in hash map
	void intializePrograms(){
		for (int rowIndex = 0; rowIndex < availablePrograms ; rowIndex++) {
			  Row row = collegeSheet.getRow(rowIndex+1);
			  if (row != null) {
			    Cell program = row.getCell(0);
			    Cell seats = row.getCell(1);
			    if (program != null && seats != null) {
			    	availableProg.put(program.getStringCellValue(),(int)seats.getNumericCellValue());
			    }
			  }
			}
	}
	
	
	//save the allocation result to an excel file
	void save() throws IOException{ 
		allocatedSheet = new XSSFWorkbook();
		XSSFSheet sheet = allocatedSheet.createSheet("Allocated programs");
		System.out.println(sheet);
		int rowIndex = 0;
		Row row = sheet.createRow(rowIndex++);
		row.createCell(0).setCellValue("Name");  
		row.createCell(1).setCellValue("Allocated"); 
		
		for(String student:allocated.keySet()){
			row = sheet.createRow(rowIndex++);
			Cell studentName = row.createCell(0);
			Cell branchAllocated = row.createCell(1);
			studentName.setCellValue(student);
			branchAllocated.setCellValue(allocated.get(student));
			
		}
		OutputStream fileOut = new FileOutputStream("allocatedPrograms.xlsx");  
		allocatedSheet.write(fileOut);
		fileOut.close();
		allocatedSheet.close();
		
	}


	
	//public method of allocate the progarms to the students
	public void allocate() {
		String[] studentQueue = new String[totalStudents];
		String[][] studentPref = new String[totalStudents][TOTAL_PROGRAM];
		for (int rowIndex = 0; rowIndex < totalStudents-1 ; rowIndex++) {
			
			Row row = studentSheet.getRow(rowIndex+1);
			 if (row != null) {
			   Cell studentName = row.getCell(0);
			   Cell pref = row.getCell(1);
			   if (studentName != null && pref != null) {
			     studentQueue[rowIndex] = studentName.getStringCellValue();
			     studentPref[rowIndex] = pref.getStringCellValue().split(",");
			   }
			  }
			}
		allocate(studentQueue,studentPref);
		
	}
}

package marksheet;
import java.util.Scanner;
public class MainClass {

	public static void main(String[] args) {
		int students;
		GradeCalculation gradeCal = new GradeCalculation();
		Scanner sc =  new Scanner(System.in);
		System.out.println("Enter Number of Students :");
		students = sc.nextInt();
		int [] marks = new int[students];
		System.out.println("Enter Marks of "+students+" Studenst ");
		for(int index=0;index<students;index++)
			marks[index] = sc.nextInt();
		//calling average function and formatting double value upto 2 decimal places
		System.out.format("Average : %.2f\n",gradeCal.average(marks, students));
		System.out.println("Maximum :"+gradeCal.maximum(marks, students));
		System.out.println("Minimum :"+gradeCal.minimum(marks, students));
		System.out.format("Students passed : %.2f",gradeCal.passingPer(marks, students));
		
		

	}

}

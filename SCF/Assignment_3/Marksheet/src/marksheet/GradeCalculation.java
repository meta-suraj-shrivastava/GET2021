package marksheet;

public class GradeCalculation {
/*
 * params :- marks(array),no. of students
 * return :- average of marks of students
 */
	float average(int[] marks,int students){
		float sum=0;
		for(int index=0;index<students;index++){
			sum+=marks[index];
		}
		return sum/(float)students;
	}
	
	/*
	 * params :- marks(array),no. of students
	 * return :- maximum marks
	 */
	
	int maximum(int[] marks,int students){
		int max=marks[0];
		for(int index=1;index<students;index++){
			if(marks[index]>max)
				max = marks[index];
		}
		return max;
	}
	/*
	 * params :- marks(array),no. of students
	 * return :- minimum marks
	 */
	int minimum(int[] marks,int students){
		int min=marks[0];
		for(int index=1;index<students;index++){
			if(marks[index]<min)
				min = marks[index];
		}
		return min;
	}
	/*
	 * params :- marks(array),no. of students
	 * return :- percentage of student passed
	 */
	float passingPer(int[] marks,int students){
		int noOfPassedStudents = 0;
		for(int index=0;index<students;index++){
			if(marks[index]>=40)
				noOfPassedStudents++;
		}
		return ((float)noOfPassedStudents/(float)students)*100;
	}
}

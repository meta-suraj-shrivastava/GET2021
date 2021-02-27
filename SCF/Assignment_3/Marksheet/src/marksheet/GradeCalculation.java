package marksheet;

public class GradeCalculation {
/*
 * params :- marks(array),no. of students
 * return :- average of marks of students
 */
	float average(int[] marks,int students){
		float sum=0;
		for(int i=0;i<students;i++){
			sum+=marks[i];
		}
		return sum/(float)students;
	}
	
	/*
	 * params :- marks(array),no. of students
	 * return :- maximum marks
	 */
	
	int maximum(int[] marks,int students){
		int max=marks[0];
		for(int i=1;i<students;i++){
			if(marks[i]>max)
				max = marks[i];
		}
		return max;
	}
	/*
	 * params :- marks(array),no. of students
	 * return :- minimum marks
	 */
	int minimum(int[] marks,int students){
		int min=marks[0];
		for(int i=1;i<students;i++){
			if(marks[i]<min)
				min = marks[i];
		}
		return min;
	}
	/*
	 * params :- marks(array),no. of students
	 * return :- percentage of student passed
	 */
	float passingPer(int[] marks,int students){
		int noOfPassedStudents = 0;
		for(int i=0;i<students;i++){
			if(marks[i]>=40)
				noOfPassedStudents++;
		}
		return ((float)noOfPassedStudents/(float)students)*100;
	}
}

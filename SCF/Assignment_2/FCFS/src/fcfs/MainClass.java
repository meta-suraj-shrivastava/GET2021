package fcfs;
import java.util.Scanner;
public class MainClass {
	static final int MAX_SIZE = 10;
	static int[][] processData = new int[MAX_SIZE][MAX_SIZE];
	static int[] completionTime = new int[MAX_SIZE];
	static int[] turnaroundTime = new int[MAX_SIZE];
	static int[] waitingTime = new int[MAX_SIZE];
	static String[] inputString = {"arrival time","burst time"};
	static int processes;
	
	
// sort the processes according to arrival time
	static void sortAccArivalTime(){
	//bubble sorting
		for(int row=0;row<processes;row++){
			for(int col=1;col<processes-row;col++){
				if(processData[col][0]<processData[col-1][0]){
					int temp = processData[col-1][0];
					processData[col-1][0] = processData[col][0];
					processData[col][0] = temp;
					temp = processData[col-1][1];
					processData[col-1][1] = processData[col][1];
					processData[col][1] = temp;
				}
			}
		}
	}

//take the array of integer type and print that array
	static void printArray(int[] arr){
		for(int index=0;index<processes;index++ )
			System.out.print(arr[index]+" ");
		System.out.println();
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Processes(Max 10) ");
		processes = sc.nextInt();
		for(int row=0;row<processes;row++){
			for(int col=0;col<2;col++){
				System.out.println("Enter "+inputString[col]);
				processData[row][col] = sc.nextInt();
				
			}
		}
		sortAccArivalTime();
		calculateCompletionTime();
		System.out.print("Completion Time : ");
		printArray(completionTime);
		System.out.print("Turnaround Time : ");
		calculateTurnAroundTime();
		printArray(turnaroundTime);
		calculateWaitingTime();
		System.out.print("Waiting Time : ");
		printArray(waitingTime);
		System.out.println("Avg waiting  Time : "+avgWaitingTime());
		System.out.println("Max. waiting  Time : "+maxWaitingTime());
		
	}
	
	
	// Calculate completion time
	static void calculateCompletionTime(){
		completionTime[0]=processData[0][1];
		for(int row=1;row<processes;row++){
			//condition for non continuous arrival time
			if(processData[row][0]<=completionTime[row-1])
				completionTime[row]=completionTime[row-1]+processData[row][1];
			else
				completionTime[row]=processData[row][0]+processData[row][1];
		}
		
	}
	//Calculate turnaround time
	static void calculateTurnAroundTime(){
		for(int index=0;index<processes;index++){
			turnaroundTime[index]=completionTime[index]-processData[index][0];
		}
		
	}
	
	//Calculate waiting time for all processes
	static void calculateWaitingTime(){
		for(int index=0;index<processes;index++){
			waitingTime[index]=turnaroundTime[index]-processData[index][1];
		}	
	}
	
	//return maximum waiting time
	static int maxWaitingTime(){
		int max = waitingTime[0];
		for(int index=1;index<processes;index++){
			if(max<waitingTime[index])
				max=waitingTime[index];
		}
		return max;
	}
	
	//Return avg. waiting time
	static float avgWaitingTime(){
		int totalTime = 0;
		for(int index=0;index<processes;index++){
				totalTime+=waitingTime[index];
		}
		return totalTime/processes;
	}
}

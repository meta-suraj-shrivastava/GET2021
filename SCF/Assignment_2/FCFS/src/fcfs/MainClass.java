package fcfs;
import java.util.Scanner;
public class MainClass {

	static int[][] processData = new int[10][10];
	static int[] completionTime = new int[10];
	static int[] turnaroundTime = new int[10];
	static int[] waitingTime = new int[10];
	static String[] inputString = {"arrival time","burst time"};
	static int processes;
	
	
// sort the processes according to arrival time
	static void sortAccArivalTime(){
	//bubble sorting
		for(int i=0;i<processes;i++){
			for(int j=1;j<processes-i;j++){
				if(processData[j][0]<processData[j-1][0]){
					int temp = processData[j-1][0];
					processData[j-1][0] = processData[j][0];
					processData[j][0] = temp;
					temp = processData[j-1][1];
					processData[j-1][1] = processData[j][1];
					processData[j][1] = temp;
				}
			}
		}
	}

//take the array of integer type and print that array
	static void printArray(int[] arr){
		for(int i=0;i<processes;i++ )
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Processes(Max 10) ");
		processes = sc.nextInt();
		for(int i=0;i<processes;i++){
			for(int j=0;j<2;j++){
				System.out.println("Enter "+inputString[j]);
				processData[i][j] = sc.nextInt();
				
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
		for(int i=1;i<processes;i++){
			//condition for non continuous arrival time
			if(processData[i][0]<=completionTime[i-1])
				completionTime[i]=completionTime[i-1]+processData[i][1];
			else
				completionTime[i]=processData[i][0]+processData[i][1];
		}
		
	}
	//Calculate turnaround time
	static void calculateTurnAroundTime(){
		for(int i=0;i<processes;i++){
			turnaroundTime[i]=completionTime[i]-processData[i][0];
		}
		
	}
	
	//Calculate waiting time for all processes
	static void calculateWaitingTime(){
		for(int i=0;i<processes;i++){
			waitingTime[i]=turnaroundTime[i]-processData[i][1];
		}	
	}
	
	//return maximum waiting time
	static int maxWaitingTime(){
		int max = waitingTime[0];
		for(int i=1;i<processes;i++){
			if(max<waitingTime[i])
				max=waitingTime[i];
		}
		return max;
	}
	
	//Return avg. waiting time
	static float avgWaitingTime(){
		int totalTime = 0;
		for(int i=0;i<processes;i++){
				totalTime+=waitingTime[i];
		}
		return totalTime/processes;
	}
}

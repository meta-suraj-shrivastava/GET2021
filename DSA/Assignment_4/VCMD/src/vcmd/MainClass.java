package vcmd;

import java.util.Scanner;

public class MainClass {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		VirtualCmd vcmd = new VirtualCmd();
		while(true){
			System.out.print("C:"+vcmd.getPath()+">");
			String[] cmd = sc.nextLine().split(" ");
			if(cmd.length == 2)
				vcmd.run(cmd[0], cmd[1]);
			else
				vcmd.run(cmd[0], null);
			
		}
	}
}

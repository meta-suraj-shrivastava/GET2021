package stringsMethods;
import java.util.Scanner;
public class MainClass {

	public static void  main(String[] args){
		StrMethods str = new StrMethods();
		Scanner sc = new Scanner(System.in);
		String strOne,strTwo;
		while(true){
			//options for the user
			System.out.println("1.Comapre Two Strings ");
			System.out.println("2.Reverse a Strings ");
			System.out.println("3.Interchange Case ");
			System.out.println("4.Find largest Word in String ");
			System.out.println("5.Exit");
			System.out.println("Enter a option :");
			int option = sc.nextInt();
			sc.nextLine();
			switch(option){
				case 1:
					System.out.println("Enter String one ");
					strOne = sc.nextLine();
					System.out.println("Enter String Two ");
					strTwo = sc.nextLine();
					System.out.println(str.equals(strOne,strTwo));
					break;
				case 2:
					System.out.println("Enter String ");
					strOne = sc.nextLine();
					System.out.println(str.reverse(strOne));
					break;
				case 3:
					System.out.println("Enter String ");
					strOne = sc.nextLine();
					System.out.println(str.interChangeCase(strOne));
					break;
				case 4:
					System.out.println("Enter String ");
					strOne = sc.nextLine();
					System.out.println("You Entered ,"+strOne);
					System.out.println(str.largestWord(strOne));
					break;
				default:
					return;
			}
		}
	}
}

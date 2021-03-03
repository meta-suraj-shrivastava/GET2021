package stringsMethods;
import java.util.Scanner;
public class MainClass {
	
	static String strOne,strTwo;
	
	static void singleInput(Scanner sc){
		System.out.println("Enter String ");
		strOne = sc.nextLine();
	}
	static void doubleInput(Scanner sc){
		System.out.println("Enter String one ");
		strOne = sc.nextLine();
		System.out.println("Enter String Two ");
		strTwo = sc.nextLine();
	}

	public static void  main(String[] args){
		StrMethods str = new StrMethods();
		Scanner sc = new Scanner(System.in);
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
					doubleInput(sc);
					System.out.println(str.equals(strOne,strTwo));
					break;
				case 2:
					singleInput(sc);
					System.out.println(str.reverse(strOne));
					break;
				case 3:
					singleInput(sc);
					System.out.println(str.interChangeCase(strOne));
					break;
				case 4:
					singleInput(sc);
					System.out.println(str.largestWord(strOne));
					break;
				default:
					return;
			}
		}
	}
}

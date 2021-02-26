package hexCalc;
import java.util.Scanner;
public class MainClass {

	public static void main(String[] args){
		HexCalc hexCalc = new HexCalc();
		Convertor Con = new Convertor();
		int choice;
		String numOne,numTwo;
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("-------------Hexa Calculator----------");
			System.out.println("1.Add\n2.Multiply\n3.Subtract\n4.Division\n5.Is Equal\n6.Is Greater\n7.Is Less\n8.Convert Decimal To Hex\n9.Convert Hex to Decimal\n10.Exit");
			System.out.println("\n\nEnter Choice ");
			choice = sc.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter Two Hex Number ");
				numOne = sc.next();
				numTwo = sc.next();
				System.out.println(hexCalc.add(numOne, numTwo));
				break;
			case 2:
				System.out.println("Enter Two Hex Number ");
				numOne = sc.next();
				numTwo = sc.next();
				System.out.println(hexCalc.multiply(numOne, numTwo));
				break;
			case 3:
				System.out.println("Enter Two Hex Number ");
				numOne = sc.next();
				numTwo = sc.next();
				System.out.println(hexCalc.subtract(numOne, numTwo));
				break;
			case 4:
				System.out.println("Enter Two Hex Number ");
				numOne = sc.next();
				numTwo = sc.next();
				System.out.println(hexCalc.divide(numOne, numTwo));
				break;
			case 5:
				System.out.println("Enter Two Hex Number ");
				numOne = sc.next();
				numTwo = sc.next();
				System.out.println(hexCalc.equals(numOne, numTwo));
				break;
			case 6:
				System.out.println("Enter Two Hex Number ");
				numOne = sc.next();
				numTwo = sc.next();
				System.out.println(hexCalc.isGreater(numOne, numTwo));
				break;
			case 7:
				System.out.println("Enter Two Hex Number ");
				numOne = sc.next();
				numTwo = sc.next();
				System.out.println(hexCalc.isLesser(numOne, numTwo));
				break;
			case 8:
				System.out.println("Enter Decimal Number ");
				int num = sc.nextInt();
				System.out.println(Con.decimalToHex(num));
				break;
			case 9:
				System.out.println("Enter Hex Number ");
				numOne = sc.next();
				System.out.println(Con.hexToDecimal(numOne));
				break;
			case 10:
			default:
				return ;
			}
		}
	}
	
}

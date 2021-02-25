package shoppingCart;
import java.util.Scanner;

public class MainClass {
	
	private static void display_items(Market market,Cart cart){
		int option_Choice,item_no,quantity;
		Scanner sc = new Scanner(System.in);
		market.display_Items();
		while(true){
			System.out.println("\n1.Add item to cart\n2.Remove Item\n3.Display Cart\n4.Exit");	
			option_Choice = sc.nextInt();
			switch(option_Choice){
			case 1:
				System.out.println("Enter Item no and number of packets respectively :");
				item_no =sc.nextInt();
				quantity = sc.nextInt();
				System.out.println(cart.add_to_cart(market.get_item(item_no,quantity)));
				break;
			case 2:
				System.out.println("Enter Item no and number of packets respectively :");
				item_no = sc.nextInt();
				quantity = sc.nextInt();
				System.out.println(cart.remove_from_cart(item_no, quantity));
				break;
			case 3:
				cart.display_cart();
				break;
			case 4:
			default:
				return;
				
		}
		}
	}
	
	public static void main(String[] args){
		int option_Choice;
		Market market = new Market();
		Cart cart = new Cart();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("\n1.Show Items\n2.Display Cart\n3.Generate Bill\n4.Exit");
			option_Choice = sc.nextInt();
			switch(option_Choice){
				case 1:
					display_items(market,cart);
					break;
				case 2:
					cart.display_cart();
					break;
				case 3:
					generate_bill(cart);
					break;
				case 4:
				default:
					return;
					
			}
		}

		
	}

	private static void generate_bill(Cart cart) {
		double total = cart.display_cart();
		System.out.println("\nTotal "+total);
		
	}

}

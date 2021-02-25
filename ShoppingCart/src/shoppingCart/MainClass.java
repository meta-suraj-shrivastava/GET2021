package shoppingCart;
import java.util.Scanner;

public class MainClass {
	
	private static void displayItems(Market market,Cart cart){
		int optionChoice,itemId,quantity;
		Scanner sc = new Scanner(System.in);
		market.displayItems();
		while(true){
			System.out.println("\n1.Add item to cart\n2.Remove Item\n3.Display Cart\n4.Exit");	
			optionChoice = sc.nextInt();
			switch(optionChoice){
			case 1:
				System.out.println("Enter Item Id and Quantity respectively :");
				itemId =sc.nextInt();
				quantity = sc.nextInt();
				System.out.println(market.addToCart(itemId,quantity,cart));
				break;
			case 2:
				System.out.println("Enter Item Id and Quantity respectively :");
				itemId = sc.nextInt();
				quantity = sc.nextInt();
				System.out.println(cart.removeFromCart(itemId, quantity,market));
				break;
			case 3:
				cart.displayCart();
				break;
			case 4:
			default:
				return;
				
		}
		}
	}
	
	public static void main(String[] args){
		int optionChoice;
		Market market = new Market();
		Cart cart = new Cart();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("\n1.Show Items\n2.Display Cart\n3.Generate Bill\n4.Exit");
			optionChoice = sc.nextInt();
			switch(optionChoice){
				case 1:
					displayItems(market,cart);
					break;
				case 2:
					cart.displayCart();
					break;
				case 3:
					generateBill(cart);
					break;
				case 4:
				default:
					return;
					
			}
		}

		
	}

	private static void generateBill(Cart cart) {
		double total = cart.displayCart();
		System.out.println("\nTotal "+total);
		
	}

}

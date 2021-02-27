package shoppingCart;
import java.util.Scanner;

/*Main Class contains following method :-
 1. displayItems :- parms(market,cart)
 2. generateBill :- params(cart)
 3. main  
 */

public class MainClass {
	
	private static void displayItems(Market market,Cart cart){
		int optionChoice,itemId,quantity;
		Scanner sc = new Scanner(System.in);
		market.displayItems(); //Displaying Market Items
		while(true){
			//Showing all options for the above displayed items
			System.out.println("1.Add item to cart");
			System.out.println("2.Remove Item from cart");
			System.out.println("3.Display Cart");
			System.out.println("4.Exit");	
			optionChoice = sc.nextInt();
			switch(optionChoice){
			case 1:
				System.out.println("Enter Item Id ");
				itemId =sc.nextInt();
				System.out.println("Enter Quantity ");
				quantity = sc.nextInt();
				System.out.println(market.addToCart(itemId,quantity,cart));
				break;
			case 2:
				System.out.println("Enter Item Id ");
				System.out.println("Enter Quantity ");
				itemId = sc.nextInt();
				quantity = sc.nextInt();
				System.out.println(cart.removeFromCart(itemId, quantity,market));
				break;
			case 3:
				cart.displayCart(); //Displaying cart Items
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
			System.out.println("1.Display Store Items");
			System.out.println("2.Display Cart");
			System.out.println("3.Generate Bill");
			System.out.println("4.Exit");
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

	//generate the bill
	private static void generateBill(Cart cart) {
		double total = cart.displayCart();
		System.out.println("\nTotal "+total);
		
	}

}

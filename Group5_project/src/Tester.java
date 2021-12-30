import java.util.Scanner;
import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<meal> menu_in = new ArrayList<>();
		ArrayList<meal> menu_out = new ArrayList<>();
		Orders orders=new Orders();
		menu_out.add(new meal_takeout("hamburger", 200));
		menu_out.add(new meal_takeout("French Fries", 50));
		menu_out.add(new meal_takeout("Coke", 35));
		menu_out.add(new meal_takeout("Sandwich", 120));
		menu_out.add(new meal_takeout("Chicken Nuggets", 60));
		menu_in.add(new meal_DineIn("Chicken Nuggets", 60));
		menu_in.add(new meal_DineIn("hamburger", 200));
		menu_in.add(new meal_DineIn("French Fries", 50));
		menu_in.add(new meal_DineIn("Coke", 35));
		menu_in.add(new meal_DineIn("Sandwich", 120));
		menu_in.add(new meal_DineIn("Corn Soup", 40));

		System.out.print("Press a to use record function\n" + "Press b to use settle function\n"
				+ "Press any other button to quit");
		String function = new String();

		function = scanner.next();
		while (function.equals("a") || function.equals("b")) {

			if (function.equals("a")) {
				System.out.println("Type \"in\" to dine in and type \"out\" to take out. Press any other button to quit");
				String in_out = new String();
				in_out = scanner.next();
				if (in_out.equals("in")) {
					printMenu(menu_in);
					System.out.println("Type in the index and quantity of the meal that you'd like to have in the form of \"index space number\".");
					int index=0;
					int number=0;
					int pos=0;
					ArrayList<meal> order=new ArrayList<>();
					while(scanner.hasNextInt()) {
						index=scanner.nextInt();
						number=scanner.nextInt();
						
						
						order.add(new meal_DineIn(menu_in.get(index-1).getName(), menu_in.get(index-1).getPrice(), number));
						
					}
					
					System.out.println("Set the position of the table");
					
					for(meal meal:order) {
						((meal_DineIn)meal).setPosition(pos);
					}
					orders.add(order);
				} else if (in_out.equals("out")) {
					printMenu(menu_out);
					System.out.println("Type in the index and quantity of the meal that you'd like to have in the form of \"index space number\".");
					int index;
					int number;
					
					ArrayList<meal> order=new ArrayList<>();
					
				}

			} else if (function.equals("b")) {
				String print_or_sheet = new String();
				System.out.println(
						"Type \"Order\" to print out every order and type \"Revenue Sheet\" to take out. Press any other button to quit");
				print_or_sheet = scanner.next();

				function = scanner.next();
			}
		}

	}

	public static void printMenu(ArrayList<meal> menu) {
		for (meal meal : menu) {
			int i=1;
			System.out.print(i+". "+meal.printInfo());

		}

	}
	

}

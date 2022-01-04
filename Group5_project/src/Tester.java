import java.util.Scanner;
import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayList<Meal> menu_in = new ArrayList<>();
		ArrayList<Meal> menu_out = new ArrayList<>();
		Orders orders = new Orders();
		menu_out.add(new Meal_Takeout("Hamburger", 200));
		menu_out.add(new Meal_Takeout("French Fries", 50));
		menu_out.add(new Meal_Takeout("Coke", 35));
		menu_out.add(new Meal_Takeout("Sandwich", 120));
		menu_out.add(new Meal_Takeout("Chicken Nuggets", 60));
		menu_in.add(new Meal_DineIn("Chicken Nuggets", 60));
		menu_in.add(new Meal_DineIn("Hamburger", 200));
		menu_in.add(new Meal_DineIn("French Fries", 50));
		menu_in.add(new Meal_DineIn("Coke", 35));
		menu_in.add(new Meal_DineIn("Sandwich", 120));
		menu_in.add(new Meal_DineIn("Corn Soup", 40));

		System.out.print("Press a to use record function\n" + "Press b to use settle function\n"
				+ "Press any other button to quit\n");
		String function = new String();

		function = scanner.next();
		while (function.equals("a") || function.equals("b")) {

			if (function.equals("a")) {
				System.out
						.println("Type \"in\" to dine in and type \"out\" to take out. Press any other button to quit");
				String in_out = new String();
				in_out = scanner.next();
				if (in_out.equals("in")) {

					System.out.println("Set the position of the table");

					int index = 0;
					int number = 0;
					int pos = 0;
					pos = scanner.nextInt();
					ArrayList<Meal> order = new ArrayList<>();
					printMenu(menu_in);
					System.out.println(
							"Type in the index and quantity of the meal that you'd like to have in the form of \"index space number\".");
					String order_input = new String();
					while ((order_input = scanner.nextLine()).equals(""))
						;

					Scanner parse = new Scanner(order_input);
					while (parse.hasNextInt()) {
						index = parse.nextInt();
						number = parse.nextInt();

						order.add(new Meal_DineIn(menu_in.get(index - 1).getName(), menu_in.get(index - 1).getPrice(),
								number));

					}
					parse.close();

					for (Meal meal : order) {
						((Meal_DineIn) meal).setPosition(pos);
					}

					orders.add(order);
					System.out.print("Press a to use record function\n" + "Press b to use settle function\n"
							+ "Press any other button to quit\n");
					function = scanner.next();
				} else if (in_out.equals("out")) {
					printMenu(menu_out);
					System.out.println(
							"Type in the index and quantity of the meal that you'd like to have and whether you want disposable tableware in the form of \"index space number\"\"yes or no(type 1 or 0)\".");
					int index;
					int number;
					int fork = 0;
					ArrayList<Meal> order = new ArrayList<>();
					String order_input = new String();
					while ((order_input = scanner.nextLine()).equals(""))
						;

					Scanner parse = new Scanner(order_input);

					while (parse.hasNextInt()) {
						index = parse.nextInt();
						number = parse.nextInt();
						fork = parse.nextInt();
						if (!(fork == 1)) {
							order.add(new Meal_Takeout(menu_out.get(index - 1).getName(),
									menu_out.get(index - 1).getPrice(), number, false));
						} else {
							order.add(new Meal_Takeout(menu_out.get(index - 1).getName(),
									menu_out.get(index - 1).getPrice(), number, true));
						}

					}
					parse.close();
					orders.add(order);

					System.out.print("Press a to use record function\n" + "Press b to use settle function\n"
							+ "Press any other button to quit\n");
					function = scanner.next();
				}

			} else if (function.equals("b")) {
				String print_or_sheet = new String();
				System.out.println(
						"Type \"Order\" to print out every order and type \"Revenue\" to print revenue sheet. Press any other button to quit");
				print_or_sheet = scanner.next();
				if (print_or_sheet.equals("Order")) {
					System.out.print(orders.everyOrder());
				} else if (print_or_sheet.equals("Revenue")) {
					System.out.print(orders.sheet());
				}
				System.out.print("Press a to use record function\n" + "Press b to use settle function\n"
						+ "Press any other button to quit\n");
				function = scanner.next();
			}

		}
	}

	public static void printMenu(ArrayList<Meal> menu) {
		int i = 1;
		for (Meal meal : menu) {

			System.out.print(i + ". " + meal.printInfo());
			i++;

		}

	}

}

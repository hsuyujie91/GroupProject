import java.util.ArrayList;

public class Orders {
	ArrayList<ArrayList<Meal>> orders = new ArrayList<>();

	public void add(ArrayList<Meal> order) {
		this.orders.add(order);
	}

	public double total_revenue() {
		double sum = 0;
		for (ArrayList<Meal> order : this.orders) {
			for (Meal meal : order) {
				sum += (meal.getPrice()) * (meal.getQuantity());
			}

		}
		return sum;
	}

	public double order_number() {
		double number = 0;
		for (ArrayList<Meal> order : this.orders) {
			number++;
		}
		return number;
	}

	public double average_spending() {
		double i;
		i = this.total_revenue() / this.order_number();
		return i;
	}

	public int takeout_number() {
		int sum = 0;
		for (ArrayList<Meal> order : this.orders) {
			for (Meal meal : order) {
				if (meal instanceof Meal_Takeout) {
					sum++;
				}
			}
		}
		return sum;

	}

	public int fork_number() {
		int sum = 0;
		for (ArrayList<Meal> order : this.orders) {
			for (Meal meal : order) {
				if (meal instanceof Meal_Takeout) {
					if (((Meal_Takeout) meal).getFork()) {
						sum++;
					}
				}
			}
		}
		return sum;

	}

	public double fork_ratio() {
		double fork_number = this.fork_number();
		double takeout_number = this.takeout_number();
		double ratio = fork_number / takeout_number;
		return ratio;
	}

	public String sheet() {
		String r = String.format("%.2f", this.fork_ratio());

		String string = new String();
		string = "Total Revenue: " + this.total_revenue() + "\n" + "The average price of every order: "
				+ this.average_spending() + "\n" + "The ratio of fork that takeout order needed: " + r + "\n";
		return string;
	}

	public String everyOrder() {
		String everyOrder = new String();
		String out = new String();
		String in = new String();
		for (ArrayList<Meal> order : this.orders) {
			for (Meal meal : order) {
				if (meal instanceof Meal_Takeout) {
					out += meal.getName() + " $" + meal.getPrice() + " quantity:" + meal.getQuantity()
							+ " Need fork or not? " + ((Meal_Takeout) meal).getFork() + "\n";
				} else if (meal instanceof Meal_DineIn) {
					in += meal.getName() + " $" + meal.getPrice() + " quantity:" + meal.getQuantity() + " Position: "
							+ ((Meal_DineIn) meal).getPosition() + "\n";
				}
			}

		}
		everyOrder = "TakeOut Meal:\n" + out + "------------------\n" + "DineIn Meal:\n" + in;
		return everyOrder;
	}

}

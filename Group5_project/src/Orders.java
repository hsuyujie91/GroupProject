import java.util.ArrayList;

public class Orders {
	ArrayList<ArrayList<meal>> orders = new ArrayList<>();

	public void add(ArrayList<meal> order) {
		this.orders.add(order);
	}

	public double total_revenue() {
		double sum = 0;
		for (ArrayList<meal> order : this.orders) {
			for (meal meal : order) {
				sum += (meal.getPrice()) * (meal.getQuantity());
			}

		}
		return sum;
	}

	public double order_number() {
		double number = 0;
		for (ArrayList order : this.orders) {
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
		for (ArrayList<meal> order : this.orders) {
			for (meal meal : order) {
				if (meal instanceof meal_takeout) {
					sum++;
				}
			}
		}
		return sum;

	}

	public int fork_number() {
		int sum = 0;
		for (ArrayList<meal> order : this.orders) {
			for (meal meal : order) {
				if (meal instanceof meal_takeout) {
					if (((meal_takeout) meal).getFork()) {
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

	// public int mealOrder() {}每個餐點被Order的次數

	public String sheet() {
		String r =String.format("%.2f", this.fork_ratio());
		
		String string = new String();
		string = "Total Revenue: " + this.total_revenue() + "\n" + "The average price of every order: " + this.average_spending()
				+ "\n" + "The ratio of fork that takeout order needed: " + r + "\n";
		return string;
	}

}

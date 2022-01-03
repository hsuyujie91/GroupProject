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

}

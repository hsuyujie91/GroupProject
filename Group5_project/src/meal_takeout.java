
public class meal_takeout extends meal {
	private boolean fork;
	static int number;

	public meal_takeout(String name, double price) {
		super(name, price);

	}
	public meal_takeout(String name, double price,int quantity) {
		super(name, price,quantity);

	}

	public void setFork(boolean fork) {
		this.fork = fork;

	}
}

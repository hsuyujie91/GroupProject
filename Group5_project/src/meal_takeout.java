
public class Meal_Takeout extends Meal {
	private boolean fork;
	

	public Meal_Takeout(String name, double price) {
		super(name, price);

	}
	public Meal_Takeout(String name, double price,int quantity,boolean fork) {
		super(name, price,quantity);
		this.fork=fork;
	}
	public boolean getFork() {
		return this.fork;
	}
	public void setFork(boolean fork) {
		this.fork = fork;

	}
}

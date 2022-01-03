
public class meal_takeout extends meal {
	private boolean fork;
	

	public meal_takeout(String name, double price) {
		super(name, price);

	}
	public meal_takeout(String name, double price,int quantity,boolean fork) {
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

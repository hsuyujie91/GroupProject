
public class meal {
	private String name = new String();
	private double price;
	private int quantity = 0;

	public meal(String name, double price) {
		this.price = price;
		this.name = name;
	}
	public meal(String name, double price, int q) {
		this.price = price;
		this.name = name;
		this.quantity = q;
	}


	public double getPrice() {
		return this.price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public String getName() {
		return this.name;
	}

	public void setQuantity(int q) {
		this.quantity = q;
	}

	public String printInfo() {
		String string = new String();
		string = getName() + " " + getPrice() + "$\n";
		return string;
	}
}

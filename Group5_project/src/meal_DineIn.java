
public class Meal_DineIn extends Meal{
	int position;
	public Meal_DineIn(String name,double price) {
		super(name, price);
		
		
	}
	public Meal_DineIn(String name, double price,int quantity) {
		super(name, price,quantity);

	}
	public void setPosition(int i) {
		this.position=i;
	}
	public int getPosition() {
		return this.position;
	}
}


public class meal_DineIn extends meal{
	int position;
	public meal_DineIn(String name,double price) {
		super(name, price);
		
		
	}
	public meal_DineIn(String name, double price,int quantity) {
		super(name, price,quantity);

	}
	public void setPosition(int i) {
		this.position=i;
	}
}

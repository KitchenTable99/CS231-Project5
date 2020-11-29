import java.util.ArrayList;

public abstract class Customer {
	
	private int numItems, timeSteps;
	
	// constructors
	public Customer() {
		numItems = 0;
		timeSteps = 0;
	}
	
	public Customer(int items) {
		numItems = items;
		timeSteps = 0;
	}
	
	public Customer(int items, int steps) {
		numItems = items;
		timeSteps = steps;
	}
	
	// accessors and mutators
	public int getItems() {
		return numItems;
	}
	
	public int getTime() {
		return timeSteps;
	}
	
	public void setTime(int newTime) {
		timeSteps = newTime;
	}
	
	// utility methods
	public void incrementTime() {
		timeSteps++;
	}
	
	public void giveUpItem() {
		numItems--;
	}
	
	// abstraction
	public abstract int chooseLine(ArrayList<CheckoutAgent> checkouts, boolean testing);
	
	public abstract String toString();

}

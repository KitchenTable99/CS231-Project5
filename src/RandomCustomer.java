import java.util.ArrayList;
import java.util.Random;

public class RandomCustomer extends Customer {
	
	// constructors
	public RandomCustomer() {
		super();
	}
	
	public RandomCustomer(int items) {
		super(items, 1);
	}

	// abstract methods 
	/**
	 * @param checkouts: an ArrayList of CheckoutAgents
	 * @param testing: a boolean for use in JUnit tests
	 */
	public int chooseLine(ArrayList<CheckoutAgent> checkouts, boolean testing) {
		Random rand;
		if (testing) {
			rand = new Random(234567890);
		} else {
			rand = new Random();
		}
		return rand.nextInt(checkouts.size());
	}

	public String toString() {
		String toReturn = "random: ";
		toReturn += this.getItems();
		return toReturn;
	}

}
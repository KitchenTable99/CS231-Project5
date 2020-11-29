import java.util.ArrayList;

public class PickyCustomer extends Customer {
	
	// constructors
	public PickyCustomer() {
		super();
	}
	
	public PickyCustomer(int numItems, int numLines) {
		super(numItems, numLines);
	}

	// abstract methods
	/**
	 * @param checkouts: an ArrayList of CheckoutAgents
	 * @param testing: a boolean for use in JUnit
	 */
	public int chooseLine(ArrayList<CheckoutAgent> checkouts, boolean testing) {
		// start at the beginning of the ArrayList
		int index = 0;
		int shortest = checkouts.get(0).getQueueLength();
		// loop over the array list and find the smallest
		for (int i = 0; i < checkouts.size(); i++) {
			// find queue length
			int queueLength = checkouts.get(i).getQueueLength();
			// compare and change if needed
			if (queueLength < shortest) {
				index = i;
				shortest = queueLength;
			}
		}
		return index;
	}

	public String toString() {
		String toReturn = "picky: ";
		toReturn += this.getItems();
		return toReturn;
	}

}

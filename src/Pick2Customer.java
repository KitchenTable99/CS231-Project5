import java.util.ArrayList;
import java.util.Random;

public class Pick2Customer extends Customer {
	
	// constructors
	public Pick2Customer() {
		super();
	}
	
	public Pick2Customer(int numItems) {
		super(numItems);
		this.setTime(2);
	}

	// abstract methods
	/**
	 * @param checkouts: an ArrayList of CheckoutAgents
	 * @param testing: a boolean for use in JUnit
	 */
	public int chooseLine(ArrayList<CheckoutAgent> checkouts, boolean testing) {
		// pick two *different* random lines
		Random rand;
		if (testing) {
			rand = new Random(234567890);
		} else {
			rand = new Random();
		}
		int lineIndex1 = rand.nextInt(checkouts.size());
		int lineIndex2 = rand.nextInt(checkouts.size());
		while (lineIndex1 == lineIndex2) {
			lineIndex2 = rand.nextInt(checkouts.size());
		}
		// compare and return shortest index
		if (checkouts.get(lineIndex1).getQueueLength() <= checkouts.get(lineIndex2).getQueueLength()) {
			return lineIndex1;
		} else {
			return lineIndex2;
		}
	}

	public String toString() {
		String toReturn = "pick2: ";
		toReturn += this.getItems();
		return toReturn;
	}

}

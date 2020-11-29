import java.awt.Graphics;
import java.util.ArrayList;

public class Landscape {
	
	private int width, height;
	private ArrayList<CheckoutAgent> lines;
	private LinkedList<Customer> finishedCustomers;
	
	// constructors
	public Landscape(int w, int h, ArrayList<CheckoutAgent> checkouts) {
		width = w;
		height = h;
		lines = checkouts;
		finishedCustomers = new LinkedList<Customer>();
	}
	
	// accessors and mutators
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public ArrayList<CheckoutAgent> getLines() {
		return lines;
	}

	public LinkedList<Customer> getCustomers() {
		return finishedCustomers;
	}
	
	// utility methods 
	public void addFinishedCustomer(Customer c) {
		finishedCustomers.addLast(c);
	}
	
	public void draw(Graphics g) {
		for (CheckoutAgent agent : lines) {
			agent.draw(g);
		}
	}
	
	public void updateState() {
		for (CheckoutAgent agent : lines) {
			agent.updateState(this);
		}
	}
	
	private double calcMean(ArrayList<Customer> customers) {
		// calculate sum
		int sum = 0;
		for (Customer c : customers) {
			sum += c.getTime();
		}
		// return correct statistic
		if (customers.size() != 0) {
			return sum/customers.size();
		} else {
			return -1;
		}
	}
	
	private double calcStdDev(double mean, ArrayList<Customer> customers) {
		double stdDev = 0;
		for (Customer c : customers) {
			stdDev += Math.pow((c.getTime() - mean), 2);
		}
		stdDev /= (customers.size() - 1);
		return Math.sqrt(stdDev);
	}
	
	public void printCustStats() {
		ArrayList<Customer> customers = finishedCustomers.toArrayList();
		double mean = this.calcMean(customers);
		double foo = this.calcStdDev(mean, customers);
		System.out.println("avg: " + mean);
		System.out.println("std. dev: " + foo);
		System.out.println();
		
	}
	
	public void mixedAnalysis() {
		// separate customers
		ArrayList<Customer> random = new ArrayList<Customer>();
		ArrayList<Customer> picky = new ArrayList<Customer>();
		ArrayList<Customer> pick2 = new ArrayList<Customer>();
		for (Customer c : finishedCustomers) {
			if (c.getClass().equals(RandomCustomer.class)) {
				random.add(c);
			} else if (c.getClass().equals(PickyCustomer.class)) {
				picky.add(c);
			} else if (c.getClass().equals(Pick2Customer.class)) {
				pick2.add(c);
			}
		}
		// print out the statistics
		double randMean = this.calcMean(random);
		System.out.println("Random:\navg: " + randMean + "\nstd. dev: " + this.calcStdDev(randMean, random));
		double pickyMean = this.calcMean(picky);
		System.out.println("\nPicky:\navg: " + pickyMean + "\nstd.dev: " + this.calcStdDev(pickyMean, picky));
		double pick2Mean = this.calcMean(pick2);
		System.out.println("\nPick2:\navg: " + pick2Mean + "\nstd. dev: " + this.calcStdDev(pick2Mean, pick2));
	}

}

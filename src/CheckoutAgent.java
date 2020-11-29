import java.awt.Graphics;

public class CheckoutAgent {
	
	private int x, y;
	private MyQueue<Customer> customers;
	
	// constructors
	public CheckoutAgent() {
		x = 0;
		y = 0;
		customers = new MyQueue<Customer>();
	}
	
	public CheckoutAgent(int x, int y) {
		this.x = x;
		this.y = y;
		customers = new MyQueue<Customer>();
	}
	
	// accessors and mutators
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public MyQueue<Customer> getCustomers() {
		return customers;
	}
	
	public int getQueueLength() {
		return customers.getSize();
	}
	
	// utility methods
	public void addCustomer(Customer c) {
		customers.offer(c);
	}
	
	public void draw(Graphics g) {
		int height = 10*this.getQueueLength();
		g.fillRect(x, y-height, 10, height);
	}
	
	public void updateState(Landscape scape) {
		// increment customers
		for (Customer c : customers) {
			c.incrementTime();
		}
		// deal with front individual
		Customer foo = customers.peak();
		// see if any customers in line
		if (foo != null) {
			// take item
			foo.giveUpItem();
			if (foo.getItems() == 0) {
				// if that was the last item, remove from queue and add to finished customers
				scape.addFinishedCustomer(customers.poll());
			}
		}
	}

}

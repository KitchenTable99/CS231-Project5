import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PickyCustomerTest {

	PickyCustomer basic, customer;
	
	@BeforeEach
	void init() {
		basic = new PickyCustomer();
		customer = new PickyCustomer(10, 5);
	}

	@Test
	void instantiationTest() {
		assertEquals(basic.getItems(), 0);
		assertEquals(basic.getTime(), 0);
		assertEquals(customer.getItems(), 10);
		assertEquals(customer.getTime(), 5);
	}
	
	@Test
	void incrementTest() {
		customer.incrementTime();
		assertEquals(customer.getTime(), 6);
	}
	
	@Test
	void giveItemTest() {
		customer.giveUpItem();
		assertEquals(customer.getItems(), 9);
	}
	
	@Test
	void chooseLine() {
		// initialize the "market place"
		ArrayList<CheckoutAgent> checkouts = new ArrayList<CheckoutAgent>();
		for (int i = 0; i < 5; i++) {
			checkouts.add(new CheckoutAgent());			
		}
		// check to make sure that the customer will pick each line
		for (int i = 0; i < 5; i++) {
			assertEquals(customer.chooseLine(checkouts, true), i);
			checkouts.get(i).addCustomer(new PickyCustomer());
		}
	}
	
	@Test
	void toStringTest() {
		assertEquals(customer.toString(), "picky: 10");
	}

}

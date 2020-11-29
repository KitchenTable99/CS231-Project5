import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomCustomerTest {
	
	RandomCustomer basic, customer;
	
	@BeforeEach
	void init() {
		basic = new RandomCustomer();
		customer = new RandomCustomer(5);
	}

	@Test
	void instantiationTest() {
		assertEquals(basic.getItems(), 0);
		assertEquals(basic.getTime(), 0);
		assertEquals(customer.getItems(), 5);
		assertEquals(customer.getTime(), 1);
	}
	
	@Test
	void incrementTest() {
		customer.incrementTime();
		assertEquals(customer.getTime(), 2);
	}
	
	@Test
	void giveItemTest() {
		customer.giveUpItem();
		assertEquals(customer.getItems(), 4);
	}
	
	@Test
	void chooseLine() {
		ArrayList<CheckoutAgent> lines = new ArrayList<CheckoutAgent>();
		for (int i = 0; i < 3; i++) {
			lines.add(new CheckoutAgent());			
		}
		assertEquals(customer.chooseLine(lines, true), 2);
	}
	
	@Test
	void toStringTest() {
		assertEquals(customer.toString(), "random: 5");
	}

}

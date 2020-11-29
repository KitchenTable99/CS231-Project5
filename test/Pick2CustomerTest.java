import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Pick2CustomerTest {

	Pick2Customer basic, customer;
	
	@BeforeEach
	void init() {
		basic = new Pick2Customer();
		customer = new Pick2Customer(5);
	}

	@Test
	void instantiationTest() {
		assertEquals(basic.getItems(), 0);
		assertEquals(basic.getTime(), 0);
		assertEquals(customer.getItems(), 5);
		assertEquals(customer.getTime(), 2);
	}
	
	@Test
	void incrementTest() {
		customer.incrementTime();
		assertEquals(customer.getTime(), 3);
	}
	
	@Test
	void giveItemTest() {
		customer.giveUpItem();
		assertEquals(customer.getItems(), 4);
	}
	
	@Test
	void chooseLine() {
		// create marketplace
		ArrayList<CheckoutAgent> lines = new ArrayList<CheckoutAgent>();
		for (int i = 0; i < 3; i++) {
			// create differing lengths of agents
			CheckoutAgent foo = new CheckoutAgent();
			for (int j = 0; j < i; j++) {
				foo.addCustomer(new Pick2Customer());
			}
			lines.add(foo);			
		}
		assertEquals(customer.chooseLine(lines, true), 0);
	}
	
	@Test
	void toStringTest() {
		assertEquals(customer.toString(), "pick2: 5");
	}

}

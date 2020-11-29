import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LandscapeTest {
	
	Landscape scape;
	
	@BeforeEach
	void init() {
		scape = new Landscape(500, 600, new ArrayList<CheckoutAgent>());
	}

	@Test
	void instantiationTest() {
		assertEquals(scape.getWidth(), 500);
		assertEquals(scape.getHeight(), 600);
		assertTrue(scape.getCustomers().equals(new LinkedList<Customer>()));
		assertTrue(scape.getLines().equals(new ArrayList<CheckoutAgent>()));
	}
	
	@Test
	void addCustomer() {
		scape.addFinishedCustomer(new RandomCustomer());
		assertEquals(scape.getCustomers().getSize(), 1);
	}

}

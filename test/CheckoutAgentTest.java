import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckoutAgentTest {

	CheckoutAgent basic, agent;
	
	@BeforeEach
	void init() {
		basic = new CheckoutAgent();
		agent = new CheckoutAgent(50, 60);
	}
	
	@Test
	void instantiationTest() {
		MyQueue<Customer> expected = new MyQueue<Customer>();
		assertEquals(basic.getX(), 0);
		assertEquals(basic.getY(), 0);
		assertTrue(basic.getCustomers().equals(expected));
		assertEquals(agent.getX(), 50);
		assertEquals(agent.getY(), 60);
		assertTrue(agent.getCustomers().equals(expected));
		assertEquals(agent.getQueueLength(), 0);
	}
	
	@Test
	void addCustomerTest() {
		for (int i = 0; i < 5; i++) {
			agent.addCustomer(new RandomCustomer());
		}
		assertEquals(agent.getQueueLength(), 5);
	}

}

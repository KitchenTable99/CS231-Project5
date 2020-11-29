import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyQueueTest {
	
	MyQueue<Integer> queue;

	@BeforeEach
	void init() {
		queue = new MyQueue<Integer>();
	}
	
	@Test
	void instantiationTest() {
		assertEquals(queue.getHead(), null);
		assertEquals(queue.getTail(), null);
		assertEquals(queue.getSize(), 0);
	}
	
	@Test
	void offerTest() {
		queue.offer(4);
		queue.offer(1);
		queue.offer(10);
		queue.offer(85);
		assertEquals(queue.getSize(), 4);
	}
	
	@Test
	void pollTest() {
		queue.offer(4);
		queue.offer(5);
		queue.poll();
		assertEquals(queue.getSize(), 1);
	}
	
	@Test
	void peakTest() {
		assertEquals(queue.peak(), null);
		queue.offer(4);
		assertEquals(queue.peak(), 4);
		
	}
	
	@Test
	void toArrayTest() {
		ArrayList<Integer> expected = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			queue.offer(i);
			expected.add(i);
		}
		assertEquals(expected, queue.toArrayList());
	}
	
	@Test
	void equalsTest() {
		MyQueue<Integer> copyQueue = new MyQueue<Integer>();
		for (int i = 0; i < 5; i++) {
			queue.offer(i);
			copyQueue.offer(i);
		}
		assertTrue(queue.equals(copyQueue));
	}

}

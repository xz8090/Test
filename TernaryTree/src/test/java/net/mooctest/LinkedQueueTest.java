package net.mooctest;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LinkedQueueTest {

	/*@Rule
    public ExpectedException expectedException = ExpectedException.none();
	
	@Test(timeout=4000)
	public void test0() {
		LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
		try {
			expectedException.expect(RuntimeException.class);
			expectedException.expectMessage("isEmpty");
			linkedQueue.getFront();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test(timeout=4000)
	public void test1() {
		LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
		linkedQueue.enqueue(1);
		try {
			expectedException.expect(RuntimeException.class);
			expectedException.expectMessage("isEmpty");
			linkedQueue.dequeue();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/
	@Test(timeout=4000)
	public void test() {
		
		LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
		linkedQueue.enqueue(1);
		linkedQueue.enqueue(2);
		linkedQueue.enqueue(3);
		assertEquals(1,linkedQueue.getFront().intValue());
		
		linkedQueue.dequeue();
		assertEquals(2, linkedQueue.getFront().intValue());
		
		linkedQueue.clear();
		assertTrue(linkedQueue.isEmpty());
	}

}

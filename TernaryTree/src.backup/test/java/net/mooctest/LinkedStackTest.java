package net.mooctest;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LinkedStackTest {

	/*@Rule
    public ExpectedException expectedException = ExpectedException.none();
	
	@Test(timeout=4000)
	public void test0() {
		LinkedStack<Integer> linkedStack = new LinkedStack<>();
		try {
			expectedException.expect(EmptyStackException.class);
			expectedException.expectMessage("isEmpty");
			linkedStack.peek();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test(timeout=4000)
	public void test1() {
		LinkedStack<Integer> linkedStack = new LinkedStack<>();
		try {
			expectedException.expect(EmptyStackException.class);
			expectedException.expectMessage("isEmpty");
			linkedStack.pop();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	*/
	@Test(timeout=4000)
	public void test() {
		LinkedStack<Integer> linkedStack=new LinkedStack<>();
		linkedStack.push(1);
		linkedStack.push(2);
		linkedStack.push(3);
		assertEquals(3,linkedStack.peek().intValue());
		linkedStack.pop();
		assertEquals(2,linkedStack.peek().intValue());
		linkedStack.clear();
		assertTrue(linkedStack.isEmpty());
	}

}

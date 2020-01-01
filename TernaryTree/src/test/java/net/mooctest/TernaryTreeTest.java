package net.mooctest;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

public class TernaryTreeTest {

	PrintStream console = null;
	ByteArrayOutputStream out = null;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
    public void setUp() throws Exception {
        out = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(out));
    }

   @After
   public void tearDown() throws IOException {
       out.close();
       System.setOut(console);
   }
   /*
	@Test(timeout=4000)
	public void test0() {
		TernaryTree<Integer> ternaryTree = new TernaryTree<Integer>();
		try {
			expectedException.expect(RuntimeException.class);
			expectedException.expectMessage("isEmpty");
			assertNull(ternaryTree.getRootData());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	*/
	@Test(timeout = 4000)
	public void test() {
		TernaryTree<Integer> ternaryTree = new TernaryTree<Integer>();
		TernaryNode<Integer> leftChild = new TernaryNode<>();
		assertNull(leftChild.getData());
		leftChild.setData(1);
		TernaryNode<Integer> middleChild = new TernaryNode<>(2);
		assertEquals(2, middleChild.getData().intValue());
		TernaryNode<Integer> rightChild = new TernaryNode<>(3);
		TernaryNode<Integer> rootNode = new TernaryNode<>(0);
		rootNode.setLeftChild(leftChild);
		rootNode.setMiddleChild(middleChild);
		rootNode.setRightChild(rightChild);
		assertEquals(1, rootNode.getLeftChild().getData().intValue());
		assertEquals(2, rootNode.getMiddleChild().getData().intValue());
		assertEquals(3, rootNode.getRightChild().getData().intValue());
		assertTrue(rootNode.hasLeftChild());
		assertFalse(leftChild.hasMiddleChild());
		assertTrue(rootNode.hasRightChild());
		assertTrue(rootNode.getRightChild().isLeaf());
		assertEquals(4, rootNode.getNumberOfNodes());
		assertEquals(2, rootNode.getHeight());
		TernaryNode<Integer> rootNode2 = rootNode.copy();
		assertEquals(2, rootNode2.getMiddleChild().getData().intValue());
		ternaryTree.setRootNode(rootNode);
		assertEquals(0, ternaryTree.getRootData().intValue());
		assertEquals(2, ternaryTree.getHeight());
		assertEquals(4, ternaryTree.getNumberOfNodes());
		assertFalse(ternaryTree.isEmpty());
		ternaryTree.clear();
		TernaryTree<Integer> leftTree = new TernaryTree<Integer>(4);
		TernaryTree<Integer> middleTree = new TernaryTree<>();
		middleTree.setTree(5);
		TernaryTree<Integer> rightTree = new TernaryTree<>();

		rightTree.setTree(6, leftTree, middleTree, leftTree);
				
		ternaryTree = new TernaryTree<Integer>(7, null, null, null);
		assertEquals(7,ternaryTree.getPreorderIterator().next().intValue());
		
		ternaryTree = new TernaryTree<Integer>(7, leftTree, middleTree, rightTree);
		assertEquals(7,ternaryTree.getPreorderIterator().next().intValue());
		
		ternaryTree.iterativePreorderTraverse();
		String result=out.toString();
		assertEquals("7 6 4 5 4 ", result);
		
		assertEquals(4,ternaryTree.getPostorderIterator().next().intValue());
		assertEquals(7,ternaryTree.getLevelOrderIterator().next().intValue());
		/*try {
			expectedException.expect(UnsupportedOperationException.class);
			expectedException.expectMessage("UnsupportedOperationException");
			ternaryTree.getInorderIterator();
		} catch (Exception e) {
			// TODO: handle exception
		}*/
	}
}

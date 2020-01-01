package net.mooctest;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import net.mooctest.Graph.CostPathPair;
import net.mooctest.Graph.CostVertexPair;
import net.mooctest.Graph.Edge;
import net.mooctest.Graph.Vertex;

public class GraphTest {

	PrintStream console = null;
	ByteArrayOutputStream out = null;
	Graph<Integer> graph=null;
	
	@Before
	public void setUp() throws Exception {
		out = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(out));
        
	}

	@After
	public void tearDown() throws Exception {
        out.close();
        System.setOut(console);
	}
	
	@Test(timeout=4000)
	public void testGraph() {
		graph=new Graph<>();
		assertEquals(Graph.TYPE.UNDIRECTED, graph.getType());
		
		graph=new Graph<>(Graph.TYPE.DIRECTED);
		assertEquals(Graph.TYPE.DIRECTED, graph.getType());
		
		Vertex<Integer> vertex2=new Vertex<Integer>(1);
		assertEquals(new Integer(1),vertex2.getValue());
		
		vertex2=new Vertex<Integer>(1,2);
		assertEquals(2,vertex2.getWeight());
		
		Vertex<Integer> vertex1=new Vertex<Integer>(2);
		vertex1.setWeight(10);
		vertex2=new Vertex<>(vertex1);
		assertEquals(0,vertex2.getEdges().size());
					
		Edge<Integer> edge=new Edge<>(2,vertex1,vertex2);
		Edge<Integer> edge2=new Edge<>(edge);
		assertEquals(edge2, edge);
		
		edge.setCost(99);
		assertEquals(99,edge.getCost());		
		assertEquals(424700496,edge.hashCode());
		assertEquals(0,edge.compareTo(edge));
		assertEquals(1,edge.compareTo(edge2));
		
		vertex1.addEdge(edge2);
		assertEquals(null,vertex1.getEdge(vertex1));
		assertEquals(10,vertex1.getEdge(vertex2).getFromVertex().getWeight());
		
		assertEquals(10,vertex1.getEdge(vertex2).getToVertex().getWeight());
		
		assertEquals(403,vertex1.hashCode());
		
		assertFalse(vertex1.equals(vertex2));
		
		assertTrue(vertex1.pathTo(vertex2));
		
		assertFalse(vertex1.pathTo(vertex1));
		
		assertEquals(1, vertex1.compareTo(vertex2));
		assertTrue(vertex1.toString().contains("Value=2 weight=10"));
		
		
		CostVertexPair costVertexPair1=new CostVertexPair<>(1, vertex1);
		costVertexPair1.setCost(11);
		assertEquals(11, costVertexPair1.getCost());
		assertEquals(vertex1,costVertexPair1.getVertex());
		assertEquals(137423,costVertexPair1.hashCode());
		assertFalse(costVertexPair1.equals(vertex2));		
		assertTrue(costVertexPair1.toString().contains("cost=11"));
		//System.out.println(costVertexPair1.equals(vertex2));
		CostVertexPair costVertexPair2=new CostVertexPair<>(1, vertex2);
		CostVertexPair costVertexPair3=new CostVertexPair<>(1, vertex2);
		assertEquals(0,costVertexPair2.compareTo(costVertexPair2));
		assertEquals(-1,costVertexPair2.compareTo(costVertexPair1));
		costVertexPair2.setCost(999);
		assertEquals(1,costVertexPair2.compareTo(costVertexPair1));
		
		CostPathPair<Integer> costPathPair1=new CostPathPair<>(1, vertex1.getEdges());
		CostPathPair<Integer> costPathPair2=new CostPathPair<>(2, vertex2.getEdges());
		costPathPair1.setCost(99);
		assertEquals(99,costPathPair1.getCost());
		assertTrue(costPathPair1.getPath().toString().contains("[ 2(10) ] -> [ 2(10) ]"));
		assertTrue(costPathPair1.toString().contains("Cost = 99"));
		assertEquals(6138,costPathPair1.hashCode());
		assertFalse(costPathPair2.equals(vertex2));
	}

	@Test(timeout=4000)
	public void testGraph3() {
		Graph<Integer> graph1=new Graph<Integer>(Graph.TYPE.DIRECTED);
		Graph<Integer> graph2=new Graph<Integer>(graph1);
		assertTrue(graph1.equals(graph2));
		assertTrue(graph1.hashCode()<0);
		Vertex<Integer> vertex1=new Vertex<>(1);
		Vertex<Integer> vertex2=new Vertex<>(2);
		Edge<Integer> edge=new Edge<>(2,vertex1,vertex2);
		List<Vertex<Integer>> vertices=new ArrayList<Graph.Vertex<Integer>>();
		vertices.add(vertex1);
		List<Edge<Integer>> edgeList=new ArrayList<>();
		edgeList.add(edge);
		Graph<Integer> graph3=new Graph<>(Graph.TYPE.DIRECTED, vertices, edgeList);
	}
	
	@Test(timeout=4000)
	public void testCostVertexPair() {
		Vertex<Integer> vertex1=new Vertex<Integer>(2);
		vertex1.setWeight(10);
		CostVertexPair costVertexPair1=new CostVertexPair<>(1, vertex1);
		costVertexPair1.setCost(11);
		assertEquals(11, costVertexPair1.getCost());
		Vertex<Integer> vertex2=new Vertex<Integer>(1,2);
		CostVertexPair costVertexPair2=new CostVertexPair<>(1, vertex2);
	}
	


}

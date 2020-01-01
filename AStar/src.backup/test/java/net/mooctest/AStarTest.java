package net.mooctest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import net.mooctest.Graph.Edge;
import net.mooctest.Graph.Vertex;

public class AStarTest {

	@Test(timeout=4000)
	public void testAStarDirected() {
		AStar<Integer> aStar = new AStar<Integer>();
		assertTrue(aStar.hashCode() > 0);
		Vertex<Integer> vertex1 = new Vertex<>(1);
		Vertex<Integer> vertex2 = new Vertex<>(2);
		Edge<Integer> edge = new Edge<>(2, vertex1, vertex2);
		
		List<Vertex<Integer>> vertices = new ArrayList<Graph.Vertex<Integer>>();
		vertices.add(vertex1);
		List<Edge<Integer>> edgeList = new ArrayList<>();
		edgeList.add(edge);
		Graph<Integer> graph3 = new Graph<>(Graph.TYPE.DIRECTED, vertices, edgeList);
		
		assertEquals(Integer.MAX_VALUE,aStar.distanceBetween(vertex1, vertex2));
		vertex1.addEdge(edge);
		assertEquals(2,aStar.distanceBetween(vertex1, vertex2));
		
		Edge<Integer> edge2 = new Edge<>(edge);
		vertex2.addEdge(edge2);
		List<Graph.Edge<Integer>> astarList = aStar.aStar(graph3, vertex1, vertex2);
		
		assertTrue(astarList.get(0).toString().contains("[ 1(0) ] -> [ 2(0) ] = 2"));
		
	}
	
}

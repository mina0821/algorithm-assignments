package cs2xb3_a3;

import java.io.IOException;


import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.DirectedEdge;

/**
 * Performing SP algorithm on diagraph with weighted
 * edge
 * 
 * @author mina
 *
 */
public class FindShortestPath {
	//get the vertices of Starting point
	static Integer start = DigraphGenerator.cities.indexOf("Boston");
	//get the vertices of Ending point
	static Integer end = DigraphGenerator.cities.indexOf("Minneapolis");
	
	/**
	 * Performing DijkstraSP algorithm on the digraph with
	 * weighted edge
	 * 
	 * @return the path after SP algorithm
	 * @throws IOException
	 */
	public static Iterable<DirectedEdge> pth() throws IOException{
		EdgeWeightedDigraph g = DigraphWeiGener.graph();
		DijkstraSP sp = new DijkstraSP(g, start);
		return sp.pathTo(end);
	}

}

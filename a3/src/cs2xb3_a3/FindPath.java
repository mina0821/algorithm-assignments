package cs2xb3_a3;

import edu.princeton.cs.algs4.Digraph;

/**
 * 3.2 bfs vs dfs
 * find path from Boston to Minneapolis based on the 
 * connected cities dataset given by using bfs and dfs
 * 
 * @author mina
 *
 */
public class FindPath {
	//get the graph of the cities
	static Digraph g = DigraphGenerator.graph();
	//get the vertices of Starting point
	static Integer start = DigraphGenerator.cities.indexOf("Boston");
	//get the vertices of Ending point
	static Integer end = DigraphGenerator.cities.indexOf("Minneapolis");
	
	/**
	 * Performing bfs on the digraph generated
	 * 
	 * @return the path list after bfs
	 */
	public static Iterable<Integer> bfs_path (){	
		BreadthFirstDirectedPaths pth = new BreadthFirstDirectedPaths(g,start);
		return pth.pathTo(end);
	}
	
	/**
	 * Performing dfs on the digraph generated
	 * 
	 * @return the path list after dfs
	 */
	public static Iterable<Integer> dfs_path(){
		DepthFirstDirectedPaths pth = new DepthFirstDirectedPaths(g,start);
		return pth.pathTo(end);
	}

}

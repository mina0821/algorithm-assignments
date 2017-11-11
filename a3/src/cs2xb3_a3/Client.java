package cs2xb3_a3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.*;

/**
 * Find paths from Boston to Minneapoli
 * Run all the modules together
 * write the output to a3_out.txt
 * 
 * @author mina
 *
 */
public class Client {
	
	/**
	 * Main method
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		write2file();
	}
	
	/**
	 * Writes the output to the file a3_out.txt
	 * 
	 * @throws IOException
	 */
	public static void write2file () throws IOException{
		DigraphGenerator.read();
		System.out.println(DigraphGenerator.graph());
		//setting up to write to the file
		PrintWriter wr = new PrintWriter("a3_out.txt");
		
		//3.2 bfs vs dfs
		
		//convert the integers in bfs path into city name
		ArrayList<String> cities = DigraphGenerator.cities;
		//create a list to store the result
		ArrayList<String> bfs_name = new ArrayList<String>();
		Iterable<Integer> bfs = FindPath.bfs_path();
		for (Integer inx: bfs){
			bfs_name.add(cities.get(inx));
		}
		//write to the output file
		String line = "BFS: ";
		for (String city:bfs_name){
			line = line + city +", ";
		}
		line = line.substring(0, line.length()-1);
		wr.println(line);
		
		//convert the integers in dfs path into city name
		//create a list to store the result
		ArrayList<String> dfs_name = new ArrayList<String>();
		Iterable<Integer> dfs = FindPath.dfs_path();
		for (Integer inx: dfs){
			dfs_name.add(cities.get(inx));
		}
		//write to the output file
		line = "DFS: ";
		for (String city:dfs_name){
			line = line + city +", ";
		}
		line = line.substring(0, line.length()-1);
		wr.println(line);
		wr.println();
		
		//3.4 find the shortest path
		
		wr.println(line("City","Meal Choice                  ","Cost of Meal"));
		wr.println(String.format("%68s", " ").replace(" ", "-"));
		wr.println(line("Boston","\\                       ","\\ "));
		//convert the integers in shortest path 
		//	into city name and meal data
		Iterable<DirectedEdge> sp = FindShortestPath.pth();
		//get the stack of menu
		Stack<Menu> menu = DigraphWeiGener.restrt_price();
		for (DirectedEdge e : sp){
			//get the name of destination city
			String city = cities.get(e.to());
			//since we already find that all cities could visit 3 restaurant
			//according to the menu, start from lowest cost food
			Menu entry = menu.peek();
			//pop the selected food
			menu.pop();
			
			//get the meal name
			String meal = entry.meal_name();
			//get the cost of food
			String cost = Double.toString(entry.price());
			
			//write to the file
			wr.println(line(city,meal,cost));
		}

		
		//close the file
		wr.close();
	}
	
	/**
	 * Generate the correct string representation
	 * in the table
	 * 
	 * @param city first column of the table
	 * @param meal second column of table
	 * @param cost third column of the table
	 * @return
	 */
	public static String line (String city, String meal, String cost){
		return String.format("%14s%40s%14s", city+"|",meal+"|",cost+"      ");
	}

}

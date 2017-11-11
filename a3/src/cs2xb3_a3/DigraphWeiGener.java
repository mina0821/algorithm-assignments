package cs2xb3_a3;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.*;

/**
 * This class generates a digraph with weighted edge
 * based on the given dataset
 * and, createa a stack of meals based on the menu given
 * 
 * @author mina
 *
 */
public class DigraphWeiGener {
	
	/**
	 * generated a digraph with weighted edge
	 * 
	 * @return the graph generated
	 * @throws IOException
	 */
	public static EdgeWeightedDigraph graph() throws IOException{
		//clean the data from connected cities first
		DigraphGenerator.read();
		ArrayList<String> clean = DigraphGenerator.cleanData;
		//initialize the graph
		EdgeWeightedDigraph g = new EdgeWeightedDigraph(33);
		
		ArrayList<String> cleanData = DigraphGenerator.cleanData;
		ArrayList<String> cities = DigraphGenerator.cities;
		//read from clean dataset
		for (int i = 0; i < cleanData.size(); i++) {
			//read the current connected city line
			String line = cleanData.get(i);
			//split the line, from first element to second 
			String[] temp = line.split(",");
			Integer from = cities.indexOf(temp[0]);
			Integer to = cities.indexOf(temp[1]);
			
			//get the weight of the edge
			Double weight = WeightCalculator.findrst(temp[1]);
			//add an edge to the graph
			DirectedEdge e = new DirectedEdge(from,to,weight);
			g.addEdge(e);
		}
		
		return g;
	}
	
	/**
	 * Read from menu.csv, create a stack with price
	 * and corresponding restaurant information in ascending order
	 * 
	 */
	public static Stack<Menu> restrt_price() throws IOException{
		// readData data menu
		String fName = "data/menu.csv";
		File file = new File(fName);
		// opens and reads prices
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		//skip the first line
		br.readLine();
		
		//create a variable to store all entries
		Menu[] temp = new Menu[40];
		
		int i = 0;
		String line;
		//load the data into the list
		while ((line = br.readLine()) != null){
			String[] item = line.split(",");
			//get the name of the restaurant
			String rest = item[0];
			//convert string of price to double
			String price = item[2];
			price = price.substring(1, price.length());
			Double pric = Double.parseDouble(price);
			//get the name of the meal
			String meal = item[1];
			
			Menu entry = new Menu(rest,pric,meal);
			temp[i] = entry;
			i++;
		}
		br.close();
		//sort the list from low cost to high cost
		Quick.sort(temp);
		//put all the entry into a stack 
		Stack<Menu> result = new Stack<Menu>();
		for (int j = temp.length-1; j >=0; j--) {
			result.push(temp[j]);
		}
		return result;
	}

}

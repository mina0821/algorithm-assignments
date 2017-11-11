package cs2xb3_a3;

import java.io.*;

import java.util.*;
import edu.princeton.cs.algs4.Digraph;

/**
 * This class reads data from the connectedd cities
 * and, creates a list of cities appears on the graph
 * and, omit unnecessary braces and white space from the dataset
 * and, generates a digraph based on it
 * 
 * @author mina
 *
 */
public class DigraphGenerator {
	//store the cities from dataset
	public static ArrayList<String> cities = new ArrayList<String>();
	//store the data from dataset in clean mode
	public static ArrayList<String> cleanData = new ArrayList<String>();
	
	/**
	 * read data from the connected cities
	 * and, load data in a clean mode into an array
	 * and, load list of nodes in to an array
	 * 
	 * @throws IOException
	 */
	public static void read() throws IOException{
		// readData data from connected cities
		String fName = "data/connectedCities.txt";
		File file = new File(fName);
		// opens and reads cities
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String line;
		
		//read line by line
		while ((line = br.readLine()) != null) {
			//omit two braces in the current line
			line = line.replaceAll("\\(.*?\\) ?", "");
			//split the line now
			String[] temp = line.split(",");
			
			//create a string to store the clean data
			String clean = "";
			for (int i = 0; i<temp.length; i++){
				//omit the spaces at front or at end
				temp[i] = temp[i].trim();
				//if the city does not exist in the vector
				if (!cities.contains(temp[i])){
					cities.add(temp[i]);
				}
				clean += temp[i]+",";
			}
			//add the clean data into big list
			cleanData.add(clean);
		}
		br.close();
	}
	
	/**
	 * generates a digraph based on the dataset
	 * 
	 * @return the digraph generated
	 */
	public static Digraph graph(){
		Digraph graph = new Digraph(33);
		//read from clean dataset
		for (int i = 0; i < cleanData.size(); i++) {
			//read the current connected city line
			String line = cleanData.get(i);
			//split the line, from first element to second 
			String[] temp = line.split(",");
			Integer from = cities.indexOf(temp[0]);
			Integer to = cities.indexOf(temp[1]);
			
			//add an edge to the graph
			graph.addEdge(from, to);
		}
		return graph;
	}

}

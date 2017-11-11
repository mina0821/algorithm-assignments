package cs2xb3_a3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class calculates the weight of the edge
 * by given the destination of the edge
 * 
 * @author mina
 *
 */
public class WeightCalculator {
	
	/**
	 * find the weight of the edge based on how many
	 * restaurant is available at the destination of 
	 * the edge
	 * (Specifically, more restaurant available, smaller value)
	 * 
	 * @param city the string of the city
	 * @return 1 if all three restaurant available
	 * 			4 if no restaurant available
	 * @throws IOException 
	 */
	public static Double findrst (String city) throws IOException{
		//read the data from the location of the city
		String fName = "data/USCities.csv";
		File file = new File(fName);
		//opens and reads cities
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		br.readLine();
		String line;
		
		Double longt = 0.0;
		Double lat = 0.0;
		//load the data
		while ((line = br.readLine()) != null){
			String[] entry = line.split(",");
			String upper = city.toUpperCase();
			//find the location of the city
			if (entry[3].equals(upper)){
				longt = Double.parseDouble(entry[5]);
				lat = Double.parseDouble(entry[4]);
				//auto-check if find right position
				break;
			}
		}
		br.close();
		
		//Initialize the checker to find how many restrts could reach
		Double checker = 4.0;
		
		//load the data from three restaurant
		//burger king
		BufferedReader br_bk = new BufferedReader(new FileReader(new File("data/burgerking.csv")));
		while ((line = br_bk.readLine()) != null){
			//split the item
			String[] items = line.split(",");
			Double longti = Double.parseDouble(items[0]);
			Double lati = Double.parseDouble(items[1]);
			//check if there is one within the city
			if (Math.abs(longt - longti) < 0.5 && Math.abs(lat - lati) < 0.5){
				checker--;
				break;
			}
		}
		br_bk.close();
		
		//load the data from three restaurant
		//mcdonalds
		BufferedReader br_mc = new BufferedReader(new FileReader(new File("data/mcdonalds.csv")));
		while ((line = br_mc.readLine()) != null){
			//split the item
			String[] items = line.split(",");
			Double longti = Double.parseDouble(items[0]);
			Double lati = Double.parseDouble(items[1]);
			//check if there is one within the city
			if (Math.abs(longt - longti) < 0.5 && Math.abs(lat - lati) < 0.5){
				checker--;
				break;
			}
		}
		br_mc.close();
		
		//load the data from three restaurant
		//wendys
		BufferedReader br_wd = new BufferedReader(new FileReader(new File("data/wendys.csv")));
		while ((line = br_wd.readLine()) != null){
			//split the item
			String[] items = line.split(",");
			Double longti = Double.parseDouble(items[0]);
			Double lati = Double.parseDouble(items[1]);
			//check if there is one within the city
			if (Math.abs(longt - longti) < 0.5 && Math.abs(lat - lati) < 0.5){
				checker--;
				break;
			}
		}
		br_wd.close();
		
		return checker;
	}
}

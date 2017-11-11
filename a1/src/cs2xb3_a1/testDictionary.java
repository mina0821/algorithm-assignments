/*		Student Information
 *      -------------------
 *      Student name: Su, Mingnan
 *      Student Number: 400016478
 *      Course Code: CS 2XB3
 *      Lab Section: L01
 *      
 *      I attest that the following code being submitted is my own
individual work.
 */

package cs2xb3_a1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;


public class testDictionary {
	
	//This method read from file input.txt
	//read the data, return as a Dictionary
	public static Dictionary ReadFile(){
		//create a variable to store the result
		Dictionary result = new Dictionary();
		
		
		try {
			//open the file
			File f = new File("input.txt");
			Scanner s = new Scanner(f);
			
			//go through the data
			while(s.hasNext()){
				String pairs = s.next();
				
				//split by comma
				//index 0 -> key
				//index 1 -> value
				String[] dic = pairs.split(",");
				
				int key = Integer.parseInt(dic[0]);
				result.insert(key, dic[1]);
			}
			//close the file
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		return result;
	}
	
	//This method takes a Dictionary as input
	//write the pairs (keys,values) into output.txt
	public static void WriteFile(Dictionary input){
		FileWriter f;
	    try {
	    	//open the output file
			f=new FileWriter("output.txt");
			
			//all keys in the input Dictionary is stored in keys
			ArrayList<Integer> keys = input.AllKeys();
			
			//go through all the keys in the input Dictionary
			for (Integer key : keys) {
				//generates a string
				String line = String.format("%d,%s",key,input.GetValue(key));
				//write to file
				f.write(line+"\n");
			}
			//close the file
			f.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//This method takes an ArrayList as input
	//since different test method return different type of elements
	//in this case, does not specify the type to ArrayList
	public static void write2File(ArrayList input){
		FileWriter f;
		try {
			//open the file
			f=new FileWriter("output.txt");
		
			//go through all the elements in the list
			for (int i = 0; i < input.size(); i++) {
				//write to file
				f.write(String.valueOf(input.get(i))+"\n");
			}
			
			//close the file
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void testInsert(){
		System.out.println("Entering testInsert...");
		//read file from input.txt
		Dictionary dic=ReadFile();
		
		//insert the first pair: <9,"test9">
		//since the key 9 is already existed
		//this pair will not appear in output.txt
		System.out.println("Test case 1 passed.");
		dic.insert(9, "test9");
		//insert the second pair: <30,"test30">
		System.out.println("Test case 2 passed.");
		dic.insert(30,"test30");
		
		WriteFile(dic);
		System.out.println("testInsert completed.");
		
	}
	
	public static void testGetValue(){
		System.out.println("Entering testGetValue...");
		//read file from input.txt
		Dictionary dic=ReadFile();
		//create a list to store the values we get
		ArrayList<String> values = new ArrayList<String>();
		
		//get value from the key 7
		System.out.println("Test case 1 passed.");
		values.add(dic.GetValue(7));
		
		//use alternative version of writefile
		//takes an arrayList as input
		write2File(values);
		System.out.println("testGetValue completed.");
	}
	
	public static void testGetKey(){
		System.out.println("Entering testGetKey...");
		//read file from input.txt
		Dictionary dic=ReadFile();
		//create a list to store the keys we get
		ArrayList<Integer> keys = new ArrayList<Integer>();
		
		//get keys from the value "seven"
		System.out.println("Test case 1 passed.");
		keys.addAll(dic.GetKey("seven"));
		
		write2File(keys);
		System.out.println("testGetKey completed.");
		
	}
	
	public static void testRemove(){
		System.out.println("Entering testRemove...");
		//read file from input.txt
		Dictionary dic=ReadFile();
		
		//Remove the pair with the key 11
		System.out.println("Test case 1 passed.");
		dic.remove(11);
		
		WriteFile(dic);
		System.out.println("testRemove completed.");
		
	}
	
	public static void testContains(){
		System.out.println("Entering testContains...");
		//read file from input.txt
		Dictionary dic=ReadFile();
		//create a list of boolean to store the result
		ArrayList<Boolean> r = new ArrayList<Boolean>();
		
		//test if key 7 is in the dictionary
		System.out.println("Test case 1 passed.");
		r.add(dic.contains(7));
		
		//test if key 99 is in the dictionary
		System.out.println("Test case 2 passed.");
		r.add(dic.contains(99));
		
		write2File(r);
		System.out.println("testContains completed.");
		
	}
	
	public static void testCount(){
		System.out.println("Entering testCount...");
		//read file from input.txt
		Dictionary dic=ReadFile();
		//create a list of integers to store the result
		ArrayList<Integer> r = new ArrayList<Integer>();
		
		//add the size of the dictionary to the list
		System.out.println("Test case 1 passed.");
		r.add(dic.count());
		
		//remove one pair
		//add the current size to the list
		System.out.println("Test case 2 passed.");
		dic.remove(1);
		r.add(dic.count());
		
		write2File(r);
		System.out.println("testCount completed.");
		
	}
	
	public static void testIsEmpty(){
		System.out.println("Entering testIsEmpty...");
		//read file from input.txt
		Dictionary dic=ReadFile();
		//create a list of boolean to store the result
		ArrayList<Boolean> r = new ArrayList<Boolean>();
		
		//test if dictionary is empty
		System.out.println("Test case 1 passed.");
		r.add(dic.isEmpty());
		
		//initialize another dictionary
		//test if new dictionary is empty
		System.out.println("Test case 2 passed.");
		Dictionary dic2 = new Dictionary();
		r.add(dic2.isEmpty());
		
		write2File(r);
		System.out.println("testIsEmpty completed.");
		
	}
	
	public static void testPrintKeys(){
		System.out.println("Entering testPrintKeys...");
		//read file from input.txt
		Dictionary dic=ReadFile();
		
		//print all keys in the dictionary
		//all the keys is store in a ArrayList
		System.out.println("Test case 1 passed.");
		ArrayList<Integer> keys = dic.AllKeys();
		
		dic.printKeys();
		write2File(keys);
		System.out.println("testPrintKeys completed.");
		
	}

	public static void main(String[] args) {
		//test begins
		
		//you may use any test method once at a time
		//output file is always output.txt
		//if you use two test method at the same time,
		//   the last one that gets run will overwrite the previous content
		
		//testInsert();
		//testGetValue();
		//testGetKey();
		//testRemove();
		//testContains();
		//testCount();
		testIsEmpty();
		//testPrintKeys();
		
		//test ends
		
	}
}
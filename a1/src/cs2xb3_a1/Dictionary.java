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

import java.util.ArrayList;
import java.util.Arrays;

public class Dictionary {
	//key stores keys; value stores values;
	private int[] key;
	private String[] value;
	
	//create a default dictionary with length 20
	public Dictionary(){
		key = new int[20];
		value = new String[20];
	}
	
	//insert a new pair
	public void insert(int k, String v){
		//first, check if the key is existed
		boolean exist=false;
		for (int i = 0; i < key.length; i++) {
			if (k==key[i]){
				exist=true;
			}
		}
		//if not, find an empty spot
		if(exist==false){
			for (int i = 0; i < 20; i++) {
				if (value[i]==null){
					//insert the pair
					key[i]=k;
					value[i]=v;
					//interrupt the loop
					break;
				}
			}
		}
	}
	
	//returns the value in given key
	public String GetValue(int k){
		//go over key list to locate the key
		for (int i = 0; i < key.length; i++) {
			if (key[i]==k){
				return value[i];
			}
		}
		return "There is no such key in dictionary.";
	}
	
	//returns all keys of the given value
	public ArrayList<Integer> GetKey(String v){
		//define variables to store the keys
		ArrayList<Integer> r = new ArrayList<>();

		for (int i = 0; i < key.length; i++) {
			if (v.equals(value[i])){
				//add the key to the result list
				r.add(key[i]);
			}
		}
		return r;
	}
	
	//remove the pair if the given key
	public void remove (int k){
		for (int i = 0; i < key.length; i++) {
			if (key[i]==k){
				key[i]=0;
				value[i]=null;
			}
		}
	}
	
	//returns true if values of two keys are the same
	public boolean compare (int k, int k2){
		String v = this.GetValue(k);
		String v2 = this.GetValue(k2);
		return v==v2;
	}
	
	//checks the existence of the given key
	public boolean contains (int k){
		//get the value of given key
		String output = this.GetValue(k);
		//if GetValue does not return a error msg
		//the key is contained in the dictionary
		return "There is no such key in dictionary." != output;
	}
	
	//returns the total number of pairs(size)
	public int count (){
		//initialize the variable
		int size=0;

		for (String v : value) {
			//find any spot which is not empty
			if (v != null){
				//increment size
				size++;
			}
		}
		return size;
	}
	
	//returns is empty or not
	public boolean isEmpty(){
		for (String v : value) {
			//find any spot which is not empty
			if (v != null){
				return false;
			}
		}
		return true;
	}
	
	//store all the keys and return it as a ArrayList
	public ArrayList<Integer> AllKeys(){
		//create an ArrayList to store the keys in the dictionary
		ArrayList<Integer> keys = new ArrayList<Integer>();
		
		for (int i = 0; i < key.length; i++) {
			//find any spot which is not empty
			if (value[i] != null){
				//add the correspoding key in the list
				keys.add(key[i]);
			}
		}
		
		return keys;
	}
	
	//prints out all keys (i.e. {key1, key2, ... keyN})
	public void printKeys (){
		ArrayList<Integer> keys = this.AllKeys();
		System.out.println("Keys: "+keys);
	}

}

package cs2xb3_a3;

/**
 * This is a ADT which stores the restaurant information
 * on the menu
 * 
 * @author mina
 *
 */
public class Menu implements Comparable<Menu>{
	private String name;
	private Double value;
	private String meal;
	
	/**
	 * Constructor of the ADT 
	 * 
	 * @param n the name of the restaurant
	 * @param v the cost of food on given meal
	 * @param meal the name of the meal
	 */
	public Menu (String n, Double v, String meal){
		this.name = n;
		this.value = v;
		this.meal = meal;
	}
	
	/**
	 * Getter of restaurant name
	 * 
	 * @return the name of the restaurant
	 */
	public String rest_name(){
		return this.name;
	}
	
	/**
	 * Getter of the value of the food
	 * 
	 * @return the cost of given meal plan
	 */
	public Double price(){
		return this.value;
	}
	
	/**
	 * Getter of the name of the meal
	 * 
	 * @return the name of the meal plan
	 */
	public String meal_name(){
		return meal;
	}
	

	@Override
	public int compareTo(Menu o) {
		return this.value.compareTo(o.price());
	}

	@Override
	public String toString() {
		return "Menu [name=" + name + ", value=" + value + "]";
	}
	

}

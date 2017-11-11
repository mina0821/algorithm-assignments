package sort;

/**
 * This class implements merge sort.
 * From algorithm textbook 4th edition
 * 
 */
public class Merge {
	private static Comparable [] aux;
	
	/**
	 * merge sort using Comparable
	 * 
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMerge ( Comparable[] x, int n ) {
		aux = new Comparable[n];
		sortMerge(x,0,x.length-1);
	}
	
	/**
	 * merge sort by specifying starting point and ending point
	 * 
	 * @param a The input array that need to be sorted
	 * @param lo the initial point which start sorting
	 * @param hi the final index where sorting ends
	 */
	private static void sortMerge(Comparable[] a, int lo, int hi){
		//If we cannot split an array anymore, stop
		if (hi<=lo) return;
		
		//separate the array with middle index
		int mid = lo + (hi-lo)/2;
		
		//sort the left part
		sortMerge(a,lo,mid);
		//sort the right part
		sortMerge(a,mid+1,hi);
		//merge two parts together
		merge(a,lo,mid,hi);
	}
	
	/**
	 * merge two sub arrays into one big array
	 * two sub arrays are a[lo..mid], a[mid+1..hi]
	 * 
	 * @param a the input array we want to merge
	 * @param lo the initial point of the final array
	 * @param mid the middle point where 
	 *        split the big array into two sub array
	 * @param hi the ending point of the final array
	 */
	public static void merge(Comparable [] a, int lo, int mid, int hi){
		int i = lo, j = mid+1;
		
		//copy the array into a temp array
		for (int k = lo; k <= hi; k++) {
			aux[k]=a[k];
		}
		
		//merge two array into an ordered big array
		for(int k =lo;k<=hi;k++){
			if (i>mid) a[k]= aux[j++];
			else if (j>hi) a[k]= aux[i++];
			else if (less(aux[j],aux[i])) a[k]= aux[j++];
			else a[k]= aux[i++];
		}
	}
	
	/**
	 * Determine which vector is smaller
	 * 
	 * @param v first vector to compare
	 * @param w second of the two vectors to compare
	 * @return true is first vector is smaller, false if not
	 */
	public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
}

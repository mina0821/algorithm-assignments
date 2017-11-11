package sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class implements insertion sort in three methods
 *  1) regular insertion sort
 *  2) by using Comparable interface
 *  3) by using binary search to find insertion point
 * 
 *
 */

public class Insertion {
	
	/**
	 * Determine which vector is smaller
	 * 
	 * @param v first vector to compare
	 * @param w second of the two vectors to compare
	 * @return true is first vector is smaller, false if not
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	/**
	 * Compare two job objects without using comparaTo
	 * 
	 * @param v first job to compare
	 * @param w second job to compare
	 * @return true if first job is smaller
	 */
	private static boolean less(Job v, Job w){
		if (v.getProcessingTime() > w.getProcessingTime()) return false;
		if (v.getProcessingTime() < w.getProcessingTime()) return true;
		if (v.getArrivalTime() > w.getArrivalTime()) return false;
		if (v.getArrivalTime() < w.getArrivalTime()) return true;
		return true;
	}

	/**
	 * exchange two elements in a list of comparable
	 * 
	 * @param a the list we worked on
	 * @param i first index of comparable to be exchanged
	 * @param j second index of comparable in the list
	 */
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	/**
	 * regular insertion sort
	 * sort a list of jobs in increasing order (low - high)
	 * 
	 * @param x - the input array containing processing times of jobs that need to be sorted.
	 */
	public static void sortInsert (Job[] x ) {
		int N = x.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(x[j],x[j-1]); j--) {
				exch(x,j,j-1);
			}
		}
	}
	
	/**
	 * insertion sort using Comparable
	 * sort a list in increasing order
	 * 
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortComparable ( Comparable[] x, int n ) {
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && less(x[j],x[j-1]); j--) {
				exch(x,j,j-1);
			}
		}
	}
	
	/**
	 * search x in xs by performing binary search.
	 * sort a list in increasing order
	 * 
	 * @param xs the list we want to search
	 * @param x the element we want to insert
	 * @return element x should insert either in 
	 *         the left of this position or right
	 */
	public static int searchBinary(Comparable[] xs, Comparable x){
		int size = xs.length;
		int lo = 0;
		int hi = size-1;
		int middle = 0;
		
		while(hi>=lo){
			middle = (lo+hi)/2;
			
			// if element at middle smaller than x
			if(less(xs[middle],x))
				//increase the lower bound
				lo = middle + 1;
			
			// if element at middle greater than x
			else
				//decrease the upper bound
				hi = middle - 1;
		}
		return middle;
	}
	
	/**
	 * optimized insertion sort
	 * 
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortBinary (Comparable[] x, int n ) {
		for (int i = 1; i < n; i++) {
			Comparable[] partial = Arrays.copyOfRange(x, 0, i);
			int pos = searchBinary(partial,x[i]);
			
			//if this elements should sits at left of x[pos]
			if (less(x[pos],x[i]))
				//we need to exchange one more time
				pos = pos + 1;
			//else, we just have the original pos
			
			//exchange the item until we reached pos
			for (int j=i; j > pos; j--) {
				exch(x,j,j-1);
			}
		}
		
	}
}

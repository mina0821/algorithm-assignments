package sort;

/**
 * This class implements heap sort.
 * From algorithm 4th edition page 324
 *
 */

public class Heap {
	
	/**
	 * Determine which element is smaller in given array
	 * 
	 * @param v first index to compare
	 * @param w second index of the two vectors to compare
	 * @return true is first vector is smaller, false if not
	 */
	private static boolean less(Comparable[] x, int i, int j) {
        return x[i-1].compareTo(x[j-1]) < 0;
    }

	/**
	 * exchange two elements in a list of comparable
	 * 
	 * @param a the list we worked on
	 * @param i first index of comparable to be exchanged
	 * @param j second index of comparable in the list
	 */
	private static void exch(Object[] x, int i, int j) {
        Object swap = x[i-1];
        x[i-1] = x[j-1];
        x[j-1] = swap;
    }
	
	/**
	 * heap sort using Comparable
	 * 
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
    public static void sortHeap (Comparable[] x, int n) {
    	//make sure that root node is the largest one
        for (int k = n/2; k >= 1; k--)
            sink(x, k, n);
        
        while (n > 1) {
        	//exchange root node with last node
            exch(x, 1, n--);
            //sink the new root node into correct position
            sink(x, 1, n);
        }
    }
	
    /**
     * sink a elements to its correct position
     *   - That is, parent node is always greater than two 
     *     child nodes
     *     
     * @param x array representation of the tree
     * @param k the index of element we want to sink
     * @param n the length of the array
     */
    private static void sink(Comparable[] x, int k, int n) {
    	//until we reached the last level of the tree
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(x, j, j+1)) j++;
            //if element greater than two nodes, break
            if (!less(x, k, j)) break;
            //sink the element one level down
            exch(x, k, j);
            k = j;
        }
    }
	
}

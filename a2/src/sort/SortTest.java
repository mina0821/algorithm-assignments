package sort;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This is a test class to test five sort methods.
 * Heap sort, Merge sort, Insert(regular), Insert(comparable),
 * Insert(binarySearch)
 * 
 *
 */
public class SortTest {
	private static ArrayList<ArrayList<Job>> data = new ArrayList<ArrayList<Job>>();
	private static Stopwatch s;
	private static Job[] first;
	private static Job[] second;
	private static Job[] third;
	private static Job[] fourth;
	private static Job[] fifth;
	private static Job[] test;
	
	@BeforeClass
	/**
	 * Run once if tests begin
	 * read the data from a2_in.txt
	 * transfer in to a big data list
	 * outer lists consist of five big data set
	 * each data set contains a list of jobs
	 * ex)
	 * data = <line1, line2, .. , line4>
	 * line 1 = lists of jobs
	 */
	public static void setUpBeforeClass(){
		
		//read the data from a2_in.txt
		try {
			Scanner input = new Scanner(new File("data/a2_in.txt"));
			
			// each line, we read the data into an array of jobs
			while (input.hasNext()){
				
				//current represents all data in the line
				String current = input.next();
				//split current by comma
				String[] jobs = current.split(",");
				//store the data in current line in result
				ArrayList<Job> r = new ArrayList<Job>();
				
				//iterate though jobs
				for (int i = 0; i < jobs.length; i=i+3) {
					//first element is id
					String id = jobs[i].substring(1, jobs[i].length());
					//second element is processing time
					Integer proc = Integer.parseInt(jobs[i+1]);
					//third element is arrival time
					String temp = jobs[i+2].substring(0, jobs[i+2].length()-1);
					Integer time = Integer.parseInt(temp);
					
					//create a Job to store all the data
					Job job = new Job(id,proc,time);
					
					//add job into current line data vector
					r.add(job);
				}
				
				//add current line data vector into all jobs vector
				data.add(r);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Run every time before each test methods.
	 */
	@Before
	public void setUp() {
		//first line of data
		ArrayList<Job> firstln = data.get(0);
		//convert to array
		first = new Job[firstln.size()];
		first = firstln.toArray(first);
		
		//second line of data
		ArrayList<Job> secln = data.get(1);
		//convert to array
		second = new Job[secln.size()];
		second = secln.toArray(second);
		
		//third line of data
		ArrayList<Job> thirdln = data.get(2);
		//convert to array
		third = new Job[thirdln.size()];
		third = thirdln.toArray(third);
		
		//fourth line of data
		ArrayList<Job> fourln = data.get(3);
		//convert to array
		fourth = new Job[fourln.size()];
		fourth = fourln.toArray(fourth);
		
		//fifth line of data
		ArrayList<Job> fifln = data.get(4);
		//convert to array
		fifth = new Job[fifln.size()];
		fifth = fifln.toArray(fifth);
		
		//test of array size 2^14,2^16,2^18
		ArrayList<Job> tests = data.get(5);
		//convert to array
		test = new Job[tests.size()];
		test = tests.toArray(test);
		

	}

	/**
	 * local function to check if a list of comparable is
	 * sorted.
	 * 
	 * @param a list of comparable
	 * @return true if the list is sorted. False if not
	 */
	@SuppressWarnings("unchecked")
	public static boolean isSorted(Comparable[] a) { // Test whether the array
		// entries are in order.
		for (int i = 1; i < a.length; i++)
			if (a[i].compareTo(a[i-1])<0)
				return false;
		return true;
	}

	/**
	 * test methods for regular insertion sort
	 */
	@Test
	public void testInsertSort() {
		//create an array to store the times elapsed
		double[] timesInsertSort = new double[6];
		
		//sort by using regular insertion sort
		s = new Stopwatch();
		Insertion.sortInsert(first);
		timesInsertSort[0] = s.elapsedTime();
		
		s = new Stopwatch();
		Insertion.sortInsert(second);
		timesInsertSort[1] = s.elapsedTime();
		
		s = new Stopwatch();
		Insertion.sortInsert(third);
		timesInsertSort[2] = s.elapsedTime();
		
		s = new Stopwatch();
		Insertion.sortInsert(fourth);
		timesInsertSort[3] = s.elapsedTime();
		
		s = new Stopwatch();
		Insertion.sortInsert(fifth);
		timesInsertSort[4] = s.elapsedTime();
		
		s = new Stopwatch();
		Insertion.sortInsert(test);
		timesInsertSort[5] = s.elapsedTime();
		
		System.out.println("Insertion Regular sort");
		System.out.println(Arrays.toString(timesInsertSort));
		
		//check if it is sorted
		assertTrue(isSorted(first));
		assertTrue(isSorted(second));
		assertTrue(isSorted(third));
		assertTrue(isSorted(fourth));
		assertTrue(isSorted(fifth));
		

	}

	/**
	 * test methods for insertion sort using comparable
	 * interface
	 */
	@Test
	public void testInsertComparable() {
		//create an array to store elapsed time
		double[] timesInsertCmp = new double[6];
		
		//sort by using comparable insertion sort
		s = new Stopwatch();
		Insertion.sortComparable(first, first.length);
		timesInsertCmp[0] = s.elapsedTime();
		
		s = new Stopwatch();
		Insertion.sortComparable(second, second.length);
		timesInsertCmp[1] = s.elapsedTime();
		
		s = new Stopwatch();
		Insertion.sortComparable(third, third.length);
		timesInsertCmp[2] = s.elapsedTime();
		
		s = new Stopwatch();
		Insertion.sortComparable(fourth, fourth.length);
		timesInsertCmp[3] = s.elapsedTime();
		
		s = new Stopwatch();
		Insertion.sortComparable(fifth, fifth.length);
		timesInsertCmp[4] = s.elapsedTime();
		
		s = new Stopwatch();
		Insertion.sortComparable(test, test.length);
		timesInsertCmp[5] = s.elapsedTime();
		
		System.out.println("Insertion Comparable sort");
		System.out.println(Arrays.toString(timesInsertCmp));
		
		//check if it is sorted
		assertTrue(isSorted(first));
		assertTrue(isSorted(second));
		assertTrue(isSorted(third));
		assertTrue(isSorted(fourth));
		assertTrue(isSorted(fifth));
	}

	/**
	 * test methods for insertion sort optimised
	 * by binary search
	 */
	@Test
	public void testInsertBinary() {
		//create an array to store elapsed time
		double[] timesInsertBin = new double[6];
		
		//sort by using insertion sort with binary search
		s = new Stopwatch();
		Insertion.sortBinary(first, first.length);
		timesInsertBin[0] = s.elapsedTime();
		
		s = new Stopwatch();
		Insertion.sortBinary(second, second.length);
		timesInsertBin[1] = s.elapsedTime();
		
		s = new Stopwatch();
		Insertion.sortBinary(third, third.length);
		timesInsertBin[2] = s.elapsedTime();
		
		s = new Stopwatch();
		Insertion.sortBinary(fourth, fourth.length);
		timesInsertBin[3] = s.elapsedTime();
		
		s = new Stopwatch();
		Insertion.sortBinary(fifth, fifth.length);
		timesInsertBin[4] = s.elapsedTime();
		
		s = new Stopwatch();
		Insertion.sortBinary(test, test.length);
		timesInsertBin[5] = s.elapsedTime();
		
		System.out.println("Insertion sort with Binary search");
		System.out.println(Arrays.toString(timesInsertBin));
		
		//check if it is sorted
		assertTrue(isSorted(first));
		assertTrue(isSorted(second));
		assertTrue(isSorted(third));
		assertTrue(isSorted(fourth));
		assertTrue(isSorted(fifth));
	}

	/**
	 * test methods for merge sort
	 */
	@Test
	public void testMergeSort() {
		//create an array to store elapsed time
		double[] timesMergeSort = new double[6];
		
		//sort by using insertion sort with binary search
		s = new Stopwatch();
		Merge.sortMerge(first, first.length);
		timesMergeSort[0] = s.elapsedTime();
		
		s = new Stopwatch();
		Merge.sortMerge(second, second.length);
		timesMergeSort[1] = s.elapsedTime();
		
		s = new Stopwatch();
		Merge.sortMerge(third, third.length);
		timesMergeSort[2] = s.elapsedTime();
		
		s = new Stopwatch();
		Merge.sortMerge(fourth, fourth.length);
		timesMergeSort[3] = s.elapsedTime();
		
		s = new Stopwatch();
		Merge.sortMerge(fifth, fifth.length);
		timesMergeSort[4] = s.elapsedTime();
		
		s = new Stopwatch();
		Merge.sortMerge(test, test.length);
		timesMergeSort[5] = s.elapsedTime();
		
		System.out.println("Merge Sort");
		System.out.println(Arrays.toString(timesMergeSort));
		
		//check if it is sorted
		assertTrue(isSorted(first));
		assertTrue(isSorted(second));
		assertTrue(isSorted(third));
		assertTrue(isSorted(fourth));
		assertTrue(isSorted(fifth));
	}

	/**
	 * test methods for heap sort
	 */
	@Test
	public void testHeapSort() {
		//create an array to store elapsed time
		double[] timesHeapSort = new double[5];
		
		//sort by using insertion sort with binary search
		s = new Stopwatch();
		Heap.sortHeap(first,first.length);
		timesHeapSort[0] = s.elapsedTime();
		
		s = new Stopwatch();
		Heap.sortHeap(second, second.length);
		timesHeapSort[1] = s.elapsedTime();
		
		s = new Stopwatch();
		Heap.sortHeap(third, third.length);
		timesHeapSort[2] = s.elapsedTime();
		
		s = new Stopwatch();
		Heap.sortHeap(fourth, fourth.length);
		timesHeapSort[3] = s.elapsedTime();
		
		s = new Stopwatch();
		Heap.sortHeap(fifth, fifth.length);
		timesHeapSort[4] = s.elapsedTime();
		
		s = new Stopwatch();
		Heap.sortHeap(test, test.length);
		timesHeapSort[4] = s.elapsedTime();
		
		System.out.println("Heap Sort");
		System.out.println(Arrays.toString(timesHeapSort));
		
		//check if it is sorted
		assertTrue(isSorted(first));
		assertTrue(isSorted(second));
		assertTrue(isSorted(third));
		assertTrue(isSorted(fourth));
		assertTrue(isSorted(fifth));
	}

}

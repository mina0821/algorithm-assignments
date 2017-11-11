package sort;

/**
 * This class is an ADT which stores each job's
 * ID, execution time and arrival time together.
 * Implement from comparable interface.
 * 
 *
 */

public class Job implements Comparable<Job>{
	private String jobID;
	private int processingTime;
	private int arrivalTime;
	
	/**
	 * Constructor for ADT job
	 * 
	 * @param id The identical id of a job
	 * @param pTime processing time 
	 * @param aTime arrival time
	 */
	public Job(String id, int pTime, int aTime)
	{
		this.jobID = id;
		this.processingTime = pTime;
		this.arrivalTime = aTime;
	}
	
	/**
	 * get the processing time of a job
	 * 
	 * @return precessingTime of an object
	 */
	public int getProcessingTime()
	{
		return this.processingTime;
	}
	
	/**
	 * set the processing time of a job
	 * 
	 * @param t the processing time want to set
	 */
	public void setProcessingTime(int t)
	{
		this.processingTime = t;
	}
	
	/**
	 * get the arrival time of a job
	 * 
	 * @return the arrival time of an object
	 */
	public int getArrivalTime()
	{
		return this.arrivalTime;
	}
	
	/**
	 * set the arrival time of a job
	 * 
	 * @param t the arrival time want to set
	 */
	public void setArrivalTime(int t)
	{
		this.arrivalTime = t;
	}
	
	/**
	 * get the identical ID of a job
	 * 
	 * @return ID of an object
	 */
	public String getJobID()
	{
		return this.jobID;
	}
	
	/**
	 * set an identical ID to a job
	 * 
	 * @param id the ID we want to set
	 */
	public void setJobID(String id)
	{
		this.jobID = id;
	}
	
	/**
	 * Compare a job with another job. First compare
	 * processing Time, then arrival time and ID.
	 * If all three are the same, return zero.
	 * 
	 * @return 1 if current object is greater. -1 if smaller
	 *         0 if all the attributes are equal
	 */
	@Override
	public int compareTo(Job other)
	{
		if (this.processingTime > other.processingTime) return 1;
		if (this.processingTime < other.processingTime) return -1;
		if (this.arrivalTime > other.arrivalTime) return 1;
		if (this.arrivalTime < other.arrivalTime) return -1;
		return this.jobID.compareTo(other.jobID);
	}
	
	/**
	 * Represents the ADT with a line of string
	 * 
	 * @return String representation of the object
	 */
	public String toString() {
		return jobID + "/" + processingTime + "/" + arrivalTime;
	}

}

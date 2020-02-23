package numberPlay.util;

/**
 * RunningAverageResultsI defines an interface to be implemented by classes that
 * intend to stroe the running average for each number processed in a stream of
 * numbers.
 */
public interface RunningAverageResultsI {
	/**
	 * Function to store the data of running average
	 * 
	 * @param data - The data of type Double that would be stored for further
	 *             writing to an output file
	 */
	void store(Double data);
}

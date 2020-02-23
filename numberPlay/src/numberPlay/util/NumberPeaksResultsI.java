package numberPlay.util;

/**
 * NumberPeaksResultsI defines an interface to be implemented by classes that
 * intend to store peaks in the input number stream.
 */
public interface NumberPeaksResultsI {
	/**
	 * Function to store the NumberPeaksResults results into the fnal data variable
	 * 
	 * @param data - The calculated NumberPeaksResults that needs to be stored as
	 *             final data
	 */
	void store(Double data);
}

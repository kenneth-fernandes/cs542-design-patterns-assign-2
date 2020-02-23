package numberPlay.util;

/**
 * To be implemented by classes that persist generated output data.
 */
public interface PersisterI {
	/**
	 * Function is used for closing the witer object
	 */
	void close();

	/**
	 * Function to write the final data into the output file
	 */
	void writeToFile();
}

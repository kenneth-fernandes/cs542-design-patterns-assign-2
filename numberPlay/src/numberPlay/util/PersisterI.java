package numberPlay.util;

import java.io.IOException;

/**
 * To be implemented by classes that persist generated output data.
 */
public interface PersisterI {
	/**
	 * Function is used for closing the witer object
	 */
	void close() throws IOException;

	/**
	 * Function to write the final data into the output file
	 */
	void writeToFile() throws Exception;
}

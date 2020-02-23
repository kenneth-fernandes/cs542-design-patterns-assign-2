package numberPlay.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.List;

/**
 * Class has methods that stores top K Numbers data and implements the write to
 * output file functions
 */
public class TopKNumbersData implements PersisterI, TopKNumbersResultsI {
	// Data member of TopKNumbersData that stores its own object
	private static TopKNumbersData topKNumsDataObj;
	// Data member of TopKNumbersData that stores the final data
	private String topKNumbersFinalData;
	// Data member of TopKNumbersData that stores the BufferedWriter object
	private BufferedWriter writer;
	// Data member of TopKNumbersData that stores the Output file object to write
	// the data
	private File outputFile;

	/**
	 * TopKNumbersData constructor
	 */
	private TopKNumbersData() {
		topKNumbersFinalData = UtilityConstants.getInstance().EMPTY_STRING;
	}

	/**
	 * Function of TopKNumbersData that returns its own singleton object
	 * 
	 * @return - Returns the object of TopKNumbersData
	 */
	public static TopKNumbersData getInstance() {
		if (topKNumsDataObj == null) {
			topKNumsDataObj = new TopKNumbersData();
		}
		return topKNumsDataObj;
	}

	/**
	 * Function to store the top K numbers list as final data
	 */
	@Override
	public void store(List<Double> topK) {

		topKNumbersFinalData = topKNumbersFinalData
				.concat(topK.toString().concat(UtilityConstants.getInstance().NEWLINE_STRING));
	}

	/**
	 * Function to write the final data to the output file
	 */
	@Override
	public void writeToFile() {

		try {
			outputFile = new File(InputParametersData.getInstance().getTopKNumOutFilePath());
			if (outputFile.exists()) {
				outputFile.delete();

			}
			outputFile.createNewFile();

			writer = new BufferedWriter(new FileWriter(outputFile));
			writer.write(topKNumbersFinalData);

		} catch (InvalidPathException | SecurityException | IOException ex) {
			try {
				writer.close();

			} catch (NullPointerException | IOException e) {
				System.out.println(UtilityConstants.getInstance().FILECLOSE_FAILURE_ERR_MESSAGE);
			}
		}
	}

	/**
	 * Function to close the file writer
	 */
	@Override
	public void close() {
		try {
			writer.close();

		} catch (NullPointerException | IOException e) {
			System.out.println(UtilityConstants.getInstance().FILECLOSE_FAILURE_ERR_MESSAGE);
		}
	}
}

package numberPlay.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;

public class NumberPeaksData implements PersisterI, NumberPeaksResultsI {
	// Data member of NumberPeaksData that stores its own singleton object
	private static NumberPeaksData numberPeaksDataObj;
	// Data member of NumberPeaksData that stores the Number Peaks final calculated
	// data
	private String numPeaksFinalData;
	// Data member of NumberPeaksData to store the Buffered writer object
	private BufferedWriter writer;

	// Data member of NumberPeaksData to store the output file
	private File outputFile;
	// Data member of NumberPeaksData to check if file is processed properly
	public boolean FileProcessed;

	/**
	 * Function that returns the singleton object of NumberPeaksData
	 * 
	 * @return - Returns the object of NumberPeaksData
	 */
	public static NumberPeaksData getInstance() {
		if (numberPeaksDataObj == null) {
			numberPeaksDataObj = new NumberPeaksData();
		}
		return numberPeaksDataObj;
	}

	/**
	 * NumberPeaksData constructor
	 */
	private NumberPeaksData() {
		numPeaksFinalData = UtilityConstants.getInstance().EMPTY_STRING;
		FileProcessed = false;
	}

	/**
	 * Function to store the data into the final data variable
	 */
	@Override
	public void store(Double d) {
		numPeaksFinalData = numPeaksFinalData
				.concat(d.toString().concat(UtilityConstants.getInstance().NEWLINE_STRING));
	}

	/**
	 * Function to write the final data into an output file
	 */
	@Override
	public void writeToFile() throws Exception {

		try {
			outputFile = new File(InputParametersData.getInstance().getNumPeaksOutFilePath());

			if (outputFile.exists()) {
				outputFile.delete();

			}
			outputFile.createNewFile();

			writer = new BufferedWriter(new FileWriter(outputFile));
			writer.write(numPeaksFinalData);
			FileProcessed = true;

		} catch (InvalidPathException | SecurityException | IOException ex) {
			try {
				writer.close();

			} catch (NullPointerException | IOException e) {
				throw new IOException(UtilityConstants.getInstance().FILECLOSE_FAILURE_ERR_MESSAGE);
			}
		}
	}

	/**
	 * Function to close the file writer
	 * 
	 * @throws IOException
	 */
	@Override
	public void close() throws IOException {
		try {
			writer.close();
			FileProcessed = true;

		} catch (NullPointerException | IOException e) {
			throw new IOException(UtilityConstants.getInstance().FILECLOSE_FAILURE_ERR_MESSAGE);
			
		}
	}

	@Override
	public String toString() {
		return "Number Peaks Data class";
	}
}

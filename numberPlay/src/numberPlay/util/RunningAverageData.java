package numberPlay.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;

/**
 * Class containing methods that implements the methods to store the final data
 * as well as write the final data to an output file
 */
public class RunningAverageData implements PersisterI, RunningAverageResultsI {
	// Data memeber of RunningAverageData that stores its own object
	private static RunningAverageData runningAvgDatObj;
	// Data memeber of RunningAverageData that stores the Buffered writer object
	private BufferedWriter writer;
	// Data member of RunningAverageData to store the output file
	private File outputFile;
	// Data member of RunningAverageData to store the final running average data
	private String runAvgFinalData;

	/**
	 * RunningAverageData constructor
	 */
	private RunningAverageData() {
		runAvgFinalData = UtilityConstants.getInstance().EMPTY_STRING;
	}

	/**
	 * Function that returns the singleton object of RunningAverageData
	 * 
	 * @return - Object of RunningAverageData
	 */
	public static RunningAverageData getInstance() {
		if (runningAvgDatObj == null) {
			runningAvgDatObj = new RunningAverageData();
		}
		return runningAvgDatObj;
	}

	/**
	 * Function to store the data into the final data variable
	 */
	@Override
	public void store(Double d) {
		runAvgFinalData = runAvgFinalData.concat(d.toString().concat(UtilityConstants.getInstance().NEWLINE_STRING));
	}

	/**
	 * Function to write the final data into an output file
	 */
	@Override
	public void writeToFile() throws Exception{

		try {
			outputFile = new File(InputParametersData.getInstance().getRunAvgOutFile());

			if (outputFile.exists()) {
				outputFile.delete();

			}
			outputFile.createNewFile();

			writer = new BufferedWriter(new FileWriter(outputFile));
			writer.write(runAvgFinalData);

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

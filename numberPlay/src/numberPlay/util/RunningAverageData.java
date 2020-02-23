package numberPlay.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;

public class RunningAverageData implements PersisterI, RunningAverageResultsI {

	private static RunningAverageData runningAvgDatObj;
	private BufferedWriter writer;
	private File outputFile;

	public static RunningAverageData getInstance() {
		if (runningAvgDatObj == null) {
			runningAvgDatObj = new RunningAverageData();
		}
		return runningAvgDatObj;
	}

	private String runAvgFinalData;

	private RunningAverageData() {
		runAvgFinalData = "";
	}

	@Override
	public void store(Double d) {
		runAvgFinalData = runAvgFinalData.concat(d.toString().concat("\n"));
	}

	@Override
	public void writeToFile() {

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

	@Override
	public void close() {
		try {
			writer.close();

		} catch (NullPointerException | IOException e) {
			System.out.println(UtilityConstants.getInstance().FILECLOSE_FAILURE_ERR_MESSAGE);
		}
	}
}

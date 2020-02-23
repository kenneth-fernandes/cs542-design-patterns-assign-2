package numberPlay.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;

public class NumberPeaksData implements PersisterI, NumberPeaksResultsI {

	private static NumberPeaksData numberPeaksDataObj;
	private String numPeaksFinalData;
	private BufferedWriter writer;
	private File outputFile;

	public static NumberPeaksData getInstance() {
		if (numberPeaksDataObj == null) {
			numberPeaksDataObj = new NumberPeaksData();
		}
		return numberPeaksDataObj;
	}

	private NumberPeaksData() {
		numPeaksFinalData = "";
	}

	@Override
	public void store(Double d) {
		numPeaksFinalData = numPeaksFinalData.concat(d.toString().concat("\n"));
	}

	@Override
	public void writeToFile() {

		try {
			outputFile = new File(InputParametersData.getInstance().getNumPeaksOutFilePath());

			if (outputFile.exists()) {
				outputFile.delete();

			}
			outputFile.createNewFile();

			writer = new BufferedWriter(new FileWriter(outputFile));
			writer.write(numPeaksFinalData);
			System.out.print(numPeaksFinalData);

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

package numberPlay.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.List;

public class TopKNumbersData implements PersisterI, TopKNumbersResultsI {

	private static TopKNumbersData topKNumsDataObj;
	private String topKNumbersFinalData;
	private BufferedWriter writer;
	private File outputFile;

	private TopKNumbersData() {
		topKNumbersFinalData = "";
	}

	public static TopKNumbersData getInstance() {
		if (topKNumsDataObj == null) {
			topKNumsDataObj = new TopKNumbersData();
		}
		return topKNumsDataObj;
	}

	@Override
	public void store(List<Double> topK) {
		topKNumbersFinalData = topKNumbersFinalData.concat(topK.toString().concat("\n"));
	}

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

	@Override
	public void close() {
		try {
			writer.close();

		} catch (NullPointerException | IOException e) {
			System.out.println(UtilityConstants.getInstance().FILECLOSE_FAILURE_ERR_MESSAGE);
		}
	}
}

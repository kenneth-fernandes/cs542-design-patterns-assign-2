package numberPlay.util;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;

/**
 * Class that has methods that retrieves the input file and reads the data
 * present in the file
 */
public final class FileProcessor {
	// Data member of FileProcessor that stores its own object
	private static FileProcessor fileProcessorObj;
	// Data member of FileProcessor that stores Buffered reader object
	private BufferedReader reader;
	// Data member of FileProcessor that stores the current line read from the input
	// file
	private String line;

	public static FileProcessor getInstance(String inputFilePath)
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		if (fileProcessorObj == null) {
			fileProcessorObj = new FileProcessor(inputFilePath);
		}
		return fileProcessorObj;
	}

	/**
	 * Constructor of FileProcessor initiating the File reading process
	 * 
	 * @param inputFilePath - The path for input.txt
	 * @throws InvalidPathException  - Exception that occurs if path is invalid
	 * @throws SecurityException     - Exception that occurs if the security manager
	 *                               to indicate a security violation.
	 * @throws FileNotFoundException - Exception that occurs when File is not found
	 *                               on the given file path
	 * @throws IOException           - Exceptions that occur due to File I/O
	 *                               operations
	 */
	public FileProcessor(String inputFilePath)
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

		if (!Files.exists(Paths.get(inputFilePath))) {
			throw new FileNotFoundException(UtilityConstants.getInstance().INVALID_INPUT_FILEPATH_ERR_MESSAGE);
		}

		reader = new BufferedReader(new FileReader(new File(inputFilePath)));
		line = reader.readLine();
	}

	/**
	 * Function that returns the line read by line reader from the input file
	 * 
	 * @return - line read by line reader from the input file
	 * @throws IOException - Exceptions that occur due to File I/O operations
	 */
	public String poll() throws IOException {
		if (null == line)
			return null;

		String newValue = line.trim();
		line = reader.readLine();
		return newValue;
	}

	/**
	 * Function that closes the reader object
	 * 
	 * @throws IOException - Exceptions that occur due to File I/O operations
	 */
	public void close() throws IOException {
		try {
			reader.close();
			line = null;
		} catch (IOException e) {
			throw new IOException(UtilityConstants.getInstance().FILECLOSE_FAILURE_ERR_MESSAGE, e);
		}
	}
}

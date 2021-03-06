package numberPlay.driver;

import numberPlay.util.FileProcessor;
import numberPlay.util.InputParametersData;
import numberPlay.util.UtilityConstants;

import numberPlay.filter.FloatingPointEventFilter;
import numberPlay.filter.IntegerEventFilter;
import numberPlay.filter.ProcessingCompleteEventFilter;

import numberPlay.observer.NumberPeaksObserver;
import numberPlay.observer.RunningAverageObserver;
import numberPlay.observer.TopKNumbersObserver;

import numberPlay.processing.NumberProcessor;

import numberPlay.subject.MetricsSubject;
import numberPlay.subject.SubjectI;

/**
 * @author Kenneth Peter Faernandes
 */
public class Driver {
	public static void main(String[] args) throws Exception {

		// Object of Utility Constants to retrieve necessary constants
		UtilityConstants utilConstsObj = UtilityConstants.getInstance();

		/*
		 * As the build.xml specifies the arguments as argX, in case the argument value
		 * is not given java takes the default value specified in build.xml. To avoid
		 * that, below condition is used FIXME Refactor commandline validation using the
		 * validation design taught in class.
		 */
		final int REQUIRED_NUMBER_OF_ARGS = 6;
		if ((args.length != REQUIRED_NUMBER_OF_ARGS) || (args[0].equals(utilConstsObj.INPUT_FILEPATH_ARG))
				|| (args[1].equals(utilConstsObj.RUNNING_AVG_WINDOW_SIZE_INPUT_ARG))
				|| (args[2].equals(utilConstsObj.RUNNING_AVG_OUTPUT_FILEPATH_ARG))
				|| (args[3].equals(utilConstsObj.K_VALUE_ARG))
				|| (args[4].equals(utilConstsObj.TOP_K_NUMBERS_OUTPUT_FILEPATH_ARG))
				|| (args[5].equals(utilConstsObj.NUMBER_PEAKS_OUTPUT_FILEPATH_ARG))) {

			System.err.printf(utilConstsObj.INVALID_ARGUMENTS_ERROR_MESSAGE, REQUIRED_NUMBER_OF_ARGS);

			System.exit(0);
		}
		/*
		 * Setting the input parameters into InputParametersData object data members
		 */
		InputParametersData inputParamsDataObj = InputParametersData.getInstance();
		try {

			inputParamsDataObj.setInputFilePath(args[0]);
			inputParamsDataObj.setRunAvgWindowSize(args[1]);
			inputParamsDataObj.setRunAvgOutFile(args[2]);
			inputParamsDataObj.setKValue(args[3]);
			inputParamsDataObj.setTopKNumOutFilePath(args[4]);
			inputParamsDataObj.setNumPeaksOutFilePath(args[5]);
			inputParamsDataObj.validateInputArgs();

			/*
			 * Registering the observers based on events section starts
			 */
			// Retrieving the MetricsSubject object
			SubjectI metricsSubjObj = MetricsSubject.getInstance();

			// Registering RunningAverageObserver object to Integer and Process complete
			// events
			metricsSubjObj.registerObserver(RunningAverageObserver.getInstance(), IntegerEventFilter.getInstance());
			metricsSubjObj.registerObserver(RunningAverageObserver.getInstance(),
					ProcessingCompleteEventFilter.getInstance());

			// Registering TopKNumbersObserver object to Integer, Floating and Process
			// Complete event
			metricsSubjObj.registerObserver(TopKNumbersObserver.getInstance(), IntegerEventFilter.getInstance());
			metricsSubjObj.registerObserver(TopKNumbersObserver.getInstance(), FloatingPointEventFilter.getInstance());
			metricsSubjObj.registerObserver(TopKNumbersObserver.getInstance(),
					ProcessingCompleteEventFilter.getInstance());

			// Registering NumberPeaksObserver object to Integer, Floating point and process
			// complete events
			metricsSubjObj.registerObserver(NumberPeaksObserver.getInstance(), IntegerEventFilter.getInstance());
			metricsSubjObj.registerObserver(NumberPeaksObserver.getInstance(), FloatingPointEventFilter.getInstance());
			metricsSubjObj.registerObserver(NumberPeaksObserver.getInstance(),
					ProcessingCompleteEventFilter.getInstance());

			/*
			 * Registering the observers based on events section ends
			 */

			// Retrieving the FileProcessor object
			FileProcessor fileProcessorObj = FileProcessor.getInstance(inputParamsDataObj.getInputFilePath());

			// Retrieving the NumberProcessor object
			NumberProcessor numProcessorObj = NumberProcessor.getInstance();

			// Retrieving each number from the input file and thenprocessing it.
			String numString;
			while ((numString = fileProcessorObj.poll()) != null) {
				if (!numString.isEmpty()) {
					numProcessorObj.processNumber(numString);
				}
			}
			fileProcessorObj.close();

			// Notifying the observers when the processing is complete so that the outputs
			// are persisted to their respective files
			metricsSubjObj.notifyAllObservers(ProcessingCompleteEventFilter.getInstance(),
					UtilityConstants.getInstance().PROCESSING_COMPLETE_EVENT);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			System.exit(0);

		}

		System.out.println("===================================================================");
		System.out.println(
				"Program execution has been successfully completed. Kindly checck the metrics calculated in the output files.");
	}

	@Override
	public String toString() {
		return "Driver class : main() method";
	}

}

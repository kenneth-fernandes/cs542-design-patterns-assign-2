package numberPlay.driver;

import numberPlay.util.FileProcessor;
import numberPlay.filter.TriggerEventFilter.TriggerEvents;
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

		/*
		 * As the build.xml specifies the arguments as argX, in case the argument value
		 * is not given java takes the default value specified in build.xml. To avoid
		 * that, below condition is used FIXME Refactor commandline validation using the
		 * validation design taught in class.
		 */
		final int REQUIRED_NUMBER_OF_ARGS = 6;
		if ((args.length != REQUIRED_NUMBER_OF_ARGS) || (args[0].equals("${inputNumStream}"))
				|| (args[1].equals("${runAvgWindowSize}")) || (args[2].equals("${runAvgOutFile}"))
				|| (args[3].equals("${k}")) || (args[4].equals("${topKNumOutFile}"))
				|| (args[5].equals("${numPeaksOutFile}"))) {

			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.",
					REQUIRED_NUMBER_OF_ARGS);

			System.exit(0);
		}

		/*
		 * Registering the observers based on events
		 */

		// Registering RunningAverageObserver object to Integer event

		SubjectI metricsSubjObj = MetricsSubject.getInstance();
		metricsSubjObj.registerObserver(RunningAverageObserver.getInstance(),
				TriggerEvents.INTEGER_EVENT);

		// Registering TopKNumbersObserver object to Integer event
		metricsSubjObj.registerObserver(TopKNumbersObserver.getInstance(), TriggerEvents.INTEGER_EVENT);

		// Registering TopKNumbersObserver object to Floating point event
		metricsSubjObj.registerObserver(TopKNumbersObserver.getInstance(),
				TriggerEvents.FLOATING_POINT_EVENT);

		// Registering NumberPeaksObserver object to Integer event
		metricsSubjObj.registerObserver(NumberPeaksObserver.getInstance(), TriggerEvents.INTEGER_EVENT);

		// Registering NumberPeaksObserver object to Floating point event
		metricsSubjObj.registerObserver(NumberPeaksObserver.getInstance(),
				TriggerEvents.FLOATING_POINT_EVENT);
		
		

		// Retrieving the FileProcessor object
		FileProcessor fileProcessorObj = FileProcessor.getInstance(args[0]);
		// Retrieving the NumberProcessor object
		NumberProcessor numProcessorObj = NumberProcessor.getInstance();

		String numString;

		while ((numString = fileProcessorObj.poll()) != null) {
			if (!numString.isEmpty()) {
				numProcessorObj.processNumber(numString);
			}
		}

		// FIXME Create an instance of each of the classes implementing PersisterI and
		// the
		// corresponding ResultsI interface.
		// Observers use these objects to dump data to be stored and eventually
		// persisted
		// to the corresponding output file.

		// FIXME Instantiate the subject.

		// FIXME Instantiate the observers, providing the necessary filter and the
		// results object.

		// FIXME Register each observer with the subject for the necessary set of
		// events.

		// FIXME Delegate control to a separate utility class/method that provides
		// numbers one at a time, from the FileProcessor,
		// to the subject.
	}
}

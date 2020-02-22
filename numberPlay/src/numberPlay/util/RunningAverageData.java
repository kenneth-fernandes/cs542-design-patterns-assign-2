package numberPlay.util;

public class RunningAverageData implements PersisterI, RunningAverageResultsI {

	private static RunningAverageData runningAvgDatObj;

	public static RunningAverageData getInstance() {
		if (runningAvgDatObj == null) {
			runningAvgDatObj = new RunningAverageData();
		}
		return runningAvgDatObj;
	}

	@Override
	public void store(Double d) {
	}

	@Override
	public void writeToFile() {
	}

	@Override
	public void close() {
	}
}

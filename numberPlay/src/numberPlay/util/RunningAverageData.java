package numberPlay.util;

public class RunningAverageData implements PersisterI, RunningAverageResultsI {

	private static RunningAverageData runningAvgDatObj;

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
		System.out.println(runAvgFinalData);
	}

	@Override
	public void close() {
	}
}

package numberPlay.util;

public class NumberPeaksData implements PersisterI, NumberPeaksResultsI {

	private static NumberPeaksData numberPeaksDataObj;
	private String numPeaksFinalData;

	public static NumberPeaksData getInstance() {
		if (numberPeaksDataObj == null) {
			numberPeaksDataObj = new NumberPeaksData();
		}
		return numberPeaksDataObj;
	}

	private NumberPeaksData(){
		numPeaksFinalData = "";
	}

	@Override
	public void store(Double d) {
		numPeaksFinalData = numPeaksFinalData.concat(d.toString().concat("\n"));
	}

	@Override
	public void writeToFile() {
		System.out.println(numPeaksFinalData);
	}

	@Override
	public void close() {
	}
}

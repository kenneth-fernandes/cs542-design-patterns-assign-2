package numberPlay.util;

public class NumberPeaksData implements PersisterI, NumberPeaksResultsI {

	private static NumberPeaksData numberPeaksDataObj;

	public static NumberPeaksData getInstance() {
		if (numberPeaksDataObj == null) {
			numberPeaksDataObj = new NumberPeaksData();
		}
		return numberPeaksDataObj;
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

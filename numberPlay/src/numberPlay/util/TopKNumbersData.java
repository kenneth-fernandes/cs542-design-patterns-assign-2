package numberPlay.util;

import java.util.List;

public class TopKNumbersData implements PersisterI, TopKNumbersResultsI {

	private static TopKNumbersData yopKNumsDataObj;

	public static TopKNumbersData getInstance() {
		if (yopKNumsDataObj == null) {
			yopKNumsDataObj = new TopKNumbersData();
		}
		return yopKNumsDataObj;
	}
	@Override
	public void store(List<Double> topK) {
	}

	@Override
	public void writeToFile() {
	}

	@Override
	public void close() {
	}
}

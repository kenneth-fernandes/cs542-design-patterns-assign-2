package numberPlay.util;

import java.util.List;

public class TopKNumbersData implements PersisterI, TopKNumbersResultsI {

	private static TopKNumbersData topKNumsDataObj;
	private String topKNumbersFinalData;

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
		System.out.println(topKNumbersFinalData);
	}

	@Override
	public void close() {
	}
}

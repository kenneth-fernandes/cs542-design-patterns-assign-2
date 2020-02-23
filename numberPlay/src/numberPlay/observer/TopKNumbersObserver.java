package numberPlay.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import numberPlay.filter.FilterI;
import numberPlay.filter.ProcessingCompleteEventFilter;
import numberPlay.util.InputParametersData;
import numberPlay.util.TopKNumbersData;

public class TopKNumbersObserver implements ObserverI {

    private static TopKNumbersObserver topKNumObservrsObj;
    private TopKNumbersData topKNumDataObj;
    List<Double> topKNumberLst;

    private TopKNumbersObserver() {

        topKNumDataObj = TopKNumbersData.getInstance();
        topKNumberLst = new ArrayList<Double>();
    }

    /**
     * Function to get instance of TopKNumbersObserver
     * 
     * @return - The instance of the class TopKNumbersObserver
     */
    public static ObserverI getInstance() {
        if (null == topKNumObservrsObj) {
            topKNumObservrsObj = new TopKNumbersObserver();
        }
        return topKNumObservrsObj;
    }

    @Override
    public void update(FilterI triggerEvent, String dataString) {
        if (!triggerEvent.equals(ProcessingCompleteEventFilter.getInstance())) {

            double currentNum = Double.parseDouble(dataString);
            if (topKNumberLst.size() == InputParametersData.getInstance().getKValue()) {
                topKNumberLst.remove(topKNumberLst.size() - 1);
            }
            topKNumberLst.add(currentNum);

            Collections.sort(topKNumberLst, Collections.reverseOrder());

            topKNumDataObj.store(topKNumberLst);

        } else {
            topKNumDataObj.writeToFile();
            topKNumDataObj.close();
            ;
        }

    }
}
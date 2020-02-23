package numberPlay.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import numberPlay.filter.FilterI;
import numberPlay.filter.ProcessingCompleteEventFilter;
import numberPlay.util.InputParametersData;
import numberPlay.util.TopKNumbersData;
import numberPlay.util.TopKNumbersQueue;

public class TopKNumbersObserver implements ObserverI {

    private static TopKNumbersObserver topKNumObservrsObj;
    private TopKNumbersQueue topKNumArrObj;
    private TopKNumbersData topKNumDataObj;
    List<Double> topKNumberLst;

    private TopKNumbersObserver() {
        topKNumArrObj = new TopKNumbersQueue(InputParametersData.getInstance().getKValue());
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

            double num = Double.parseDouble(dataString);
            if (topKNumberLst.size() == InputParametersData.getInstance().getKValue()) {
                topKNumberLst.remove(2);
            }
            topKNumberLst.add(num);

            Collections.sort(topKNumberLst, Collections.reverseOrder());

            topKNumDataObj.store(topKNumberLst);
            /*
             * for (int i = topKNumArrObj.getElemsInQueueCount() - 1; i >= 0; i -= 1) {
             * System.out.print(arr[i] + ", "); }
             */

        } else {
            topKNumDataObj.writeToFile();
        }

    }
}
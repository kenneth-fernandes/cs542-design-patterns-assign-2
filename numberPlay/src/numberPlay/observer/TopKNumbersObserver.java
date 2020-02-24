package numberPlay.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import numberPlay.filter.FilterI;
import numberPlay.filter.ProcessingCompleteEventFilter;

import numberPlay.processing.NumberProcessor;

import numberPlay.util.InputParametersData;
import numberPlay.util.TopKNumbersData;

/**
 * Class containing methods to implement the Top K Numbers functionality
 */
public class TopKNumbersObserver implements ObserverI {
    // Data member of TopKNumbersObserver that stores its own object
    private static TopKNumbersObserver topKNumObservrsObj;
    // Data member of TopKNumbersObserver that stores the object of TopKNumbersData
    private TopKNumbersData topKNumDataObj;
    // Data member of TopKNumbersObserver that stores the list of Top K Numbers
    private List<Double> topKNumberLst;

    /**
     * TopKNumbersObserver constructor
     */
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

    /**
     * Function that intiates the functionality of the top k elements
     * 
     * @param triggerEvent - - Trigger event Filter object
     * @param dataString   - Data of type string
     */

    @Override
    public void update(FilterI triggerEvent, String dataString) throws Exception{
        if (!triggerEvent.equals(ProcessingCompleteEventFilter.getInstance())) {

            double currentNum = NumberProcessor.getInstance().roundNumber(Double.parseDouble(dataString));
            if (topKNumberLst.size() == InputParametersData.getInstance().getKValue()) {
                topKNumberLst.remove(topKNumberLst.size() - 1);
            }
            topKNumberLst.add(currentNum);

            Collections.sort(topKNumberLst, Collections.reverseOrder());

            topKNumDataObj.store(topKNumberLst);

        } else {
            topKNumDataObj.writeToFile();
            topKNumDataObj.close();
        }

    }

    @Override
    public String toString(){
        return "Top K Numbers Observer class";
    }
}
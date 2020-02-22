package numberPlay.observer;

import numberPlay.filter.FilterI;


public class TopKNumbersObserver implements ObserverI {

    private static ObserverI topKNumObsrvrsObj;
    private boolean isIntegerEvent;

    /**
     * Function to get instance of TopKNumbersObserver
     * 
     * @return - The instance of the class TopKNumbersObserver
     */
    public static ObserverI getInstance() {
        if (null == topKNumObsrvrsObj) {
            topKNumObsrvrsObj = new TopKNumbersObserver();
        }
        return topKNumObsrvrsObj;
    }

    @Override
    public void update(FilterI triggerEvent, String dataString) {
        
    }
}
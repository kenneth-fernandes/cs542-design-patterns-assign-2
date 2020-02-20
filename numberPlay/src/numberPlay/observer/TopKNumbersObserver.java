package numberPlay.observer;

import numberPlay.filter.TriggerEventFilter.TriggerEvents;

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
    public void update(TriggerEvents event) {
        if (event == TriggerEvents.INTEGER_EVENT) {
            isIntegerEvent = true;
        } else {
            if (event == TriggerEvents.FLOATING_POINT_EVENT) {
                isIntegerEvent = false;
            }
        }
    }
}
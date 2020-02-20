package numberPlay.observer;

import numberPlay.filter.TriggerEventFilter.TriggerEvents;;

public class NumberPeaksObserver implements ObserverI {

    private static ObserverI numPeaksObsrvrObj;

    public boolean isIntegerEvent;

    /**
     * Function to get instance of NumberPeaksObserver
     * 
     * @return - The instance of the class NumberPeaksObserver
     */
    public static ObserverI getInstance() {
        if (null == numPeaksObsrvrObj) {
            numPeaksObsrvrObj = new NumberPeaksObserver();
        }
        return numPeaksObsrvrObj;
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
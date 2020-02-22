package numberPlay.observer;

import numberPlay.filter.FilterI;

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
    public void update(FilterI triggerEvent, String dataString) {
        
    }
}
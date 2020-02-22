package numberPlay.observer;

import numberPlay.filter.FilterI;
import numberPlay.filter.ProcessingCompleteEventFilter;

public class NumberPeaksObserver implements ObserverI {

    private static NumberPeaksObserver numPeaksObsrvrObj;

    private boolean isFirstNumProceessed;

    private double previousNumProcessed;

    private double peakNum;

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

    private NumberPeaksObserver() {
        isFirstNumProceessed = false;
    }

    @Override
    public void update(FilterI triggerEvent, String dataString) {

        if (!triggerEvent.equals(ProcessingCompleteEventFilter.getInstance())) {
            double num = Double.parseDouble(dataString);

            if (!isFirstNumProceessed) {
                isFirstNumProceessed = true;
            } else {
                if (num < previousNumProcessed) {
                    peakNum = previousNumProcessed;
                    System.out.println(peakNum);
                }
            }
            previousNumProcessed = num;

        } else {

        }

    }
}
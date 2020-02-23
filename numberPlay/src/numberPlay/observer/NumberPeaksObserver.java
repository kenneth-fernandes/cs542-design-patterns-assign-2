package numberPlay.observer;

import numberPlay.filter.FilterI;
import numberPlay.filter.ProcessingCompleteEventFilter;
import numberPlay.util.NumberPeaksData;

public class NumberPeaksObserver implements ObserverI {

    private static NumberPeaksObserver numPeaksObsrvrObj;

    private NumberPeaksData numPeaksDataObj;

    private boolean isFirstNumProceessed;

    private double previousNumProcessed;

    private double peakNum;

    private double currentNum;

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
        numPeaksDataObj = NumberPeaksData.getInstance();
    }

    @Override
    public void update(FilterI triggerEvent, String dataString) {

        if (!triggerEvent.equals(ProcessingCompleteEventFilter.getInstance())) {
            currentNum = Double.parseDouble(dataString);

            if (!isFirstNumProceessed) {
                isFirstNumProceessed = true;
            } else {
                if (currentNum < previousNumProcessed) {
                    peakNum = previousNumProcessed;
                    numPeaksDataObj.store(peakNum);
                }
            }
            previousNumProcessed = currentNum;

        } else {
            numPeaksDataObj.writeToFile();

        }

    }
}
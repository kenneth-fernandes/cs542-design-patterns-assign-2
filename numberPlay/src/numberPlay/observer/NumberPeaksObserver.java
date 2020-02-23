package numberPlay.observer;

import numberPlay.filter.FilterI;
import numberPlay.filter.ProcessingCompleteEventFilter;
import numberPlay.util.NumberPeaksData;

/**
 * Class containing methods to implement the Number Peaks calculation
 * functionality
 */
public class NumberPeaksObserver implements ObserverI {
    // Data member of NumberPeaksObserver class storing its own object
    private static NumberPeaksObserver numPeaksObsrvrObj;

    // Data member of NumberPeaksObserver class storing object of NumberPeaksData
    // class
    private NumberPeaksData numPeaksDataObj;

    // Data member of NumberPeaksObserver class storing whether number has processed
    // once by NumberPeaks Observer
    private boolean isFirstNumProceessed;

    // Data member of NumberPeaksObserver class storing the previous number that has
    // been processed
    private double previousNumProcessed;

    // Data member of NumberPeaksObserver class storing the peak number data
    private double peakNum;

    // Data member of NumberPeaksObserver class storing the current number
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

    /**
     * NumberPeaksObserver constructor
     */
    private NumberPeaksObserver() {
        isFirstNumProceessed = false;
        numPeaksDataObj = NumberPeaksData.getInstance();
    }

    /**
     * Function that intiates the functionality of calculating the Number Peaks
     * 
     * @param triggerEvent - - Trigger event Filter object
     * @param dataString   - Data of type string
     */
    @Override
    public void update(FilterI triggerEvent, String dataString) throws Exception{

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
            numPeaksDataObj.close();

        }

    }
}
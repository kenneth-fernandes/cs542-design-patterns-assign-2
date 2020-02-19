package numberPlay.observer;

public class NumberPeaksObserver implements ObserverI {

    private static ObserverI numPeaksObsrvrObj;

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
    public void update(Object obj) {
    }
}
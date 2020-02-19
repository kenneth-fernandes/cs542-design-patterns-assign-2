package numberPlay.observer;

public class TopKNumbersObserver implements ObserverI {

    private static ObserverI topKNumObsrvrsObj;

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
    public void update(Object obj) {
    }
}
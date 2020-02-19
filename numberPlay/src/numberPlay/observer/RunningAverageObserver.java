package numberPlay.observer;

public class RunningAverageObserver implements ObserverI {

    private static ObserverI runningAvgObsverObj;

    /**
     * Function to get instance of RunningAverageObserver
     * @return - The instance of the class RunningAverageObserver
     */
    public static ObserverI getInstance() {
        if (null == runningAvgObsverObj) {
            runningAvgObsverObj = new RunningAverageObserver();
        }
        return runningAvgObsverObj;
    }


    @Override
    public void update(Object obj) {
    }
}
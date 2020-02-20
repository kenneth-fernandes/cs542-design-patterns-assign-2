package numberPlay.observer;

import numberPlay.filter.TriggerEventFilter.TriggerEvents;
import numberPlay.processing.NumberProcessor;;

public class RunningAverageObserver implements ObserverI {

    private static ObserverI runningAvgObsverObj;
    private boolean isIntegerEvent;

    /**
     * Function to get instance of RunningAverageObserver
     * 
     * @return - The instance of the class RunningAverageObserver
     */
    public static ObserverI getInstance() {
        if (null == runningAvgObsverObj) {
            runningAvgObsverObj = new RunningAverageObserver();
        }
        return runningAvgObsverObj;
    }

    @Override
    public void update(TriggerEvents event) {
        if (event == TriggerEvents.INTEGER_EVENT) {
            isIntegerEvent = true;
            int num = Integer.parseInt(NumberProcessor.getInstance().getCurrentNumStr());
        }
    }
}
package numberPlay.observer;

import numberPlay.filter.TriggerEventFilter.TriggerEvents;
import numberPlay.processing.NumberProcessor;
import numberPlay.util.RunAvgCalnQueue;

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
            Double avg = 0.0;
            isIntegerEvent = true;
            int num = Integer.parseInt(NumberProcessor.getInstance().getCurrentNumStr());
            RunAvgCalnQueue q = RunAvgCalnQueue.getInstance();
            if (q.isQueueFull()) {
                q.dequeue();
            }
            q.enqueue(num);

            int[] elemArr = q.getElementsInQueue();
            System.out.println("Queue: - ");
            for (int i = 0; i < q.getElemsInQueueCount(); i += 1) {
                System.out.println(elemArr[i]);
                avg += elemArr[i];
            }
            avg /= (double) q.getElemsInQueueCount();
            System.out.println(" : Avg - " + avg);

        }
    }
}
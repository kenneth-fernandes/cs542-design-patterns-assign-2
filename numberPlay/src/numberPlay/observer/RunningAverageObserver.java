package numberPlay.observer;

import numberPlay.filter.FilterI;
import numberPlay.filter.ProcessingCompleteEventFilter;
import numberPlay.processing.NumberProcessor;
import numberPlay.util.InputParametersData;
import numberPlay.util.RunningAverageQueue;

public class RunningAverageObserver implements ObserverI {

    private static RunningAverageObserver runningAvgObsverObj;
    private RunningAverageQueue runAvgQueue;

    private String outputStr = "";

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

    public RunningAverageObserver() {
        runAvgQueue = new RunningAverageQueue(InputParametersData.getInstance().getRunAvgWindowSize());
    }

    @Override
    public void update(FilterI triggerEvent, String dataString) {

        if (!triggerEvent.equals(ProcessingCompleteEventFilter.getInstance())) {

            Double avg = 0.0;

            int num = Integer.parseInt(NumberProcessor.getInstance().getCurrentNumStr());

            if (runAvgQueue.isQueueFull()) {
                runAvgQueue.dequeue();
            }
            runAvgQueue.enqueue(num);

            int[] elemArr = runAvgQueue.getElementsInQueue();

            for (int i = 0; i < runAvgQueue.getElemsInQueueCount(); i += 1) {
                avg += elemArr[i];
            }
            avg /= (double) runAvgQueue.getElemsInQueueCount();
            outputStr = outputStr.concat(avg + ",");
            // System.out.println(outputStr);

            // }

        } else {

        }

    }
}
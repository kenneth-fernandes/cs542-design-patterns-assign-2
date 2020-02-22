package numberPlay.observer;

import numberPlay.filter.FilterI;
import numberPlay.processing.NumberProcessor;
import numberPlay.util.RunAvgCalnQueue;

public class RunningAverageObserver implements ObserverI {

    private static ObserverI runningAvgObsverObj;
    private boolean isIntegerEvent;
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

    @Override
    public void update(FilterI triggerEvent,String dataString) {
        //if (event.test(str)) {
            Double avg = 0.0;
            isIntegerEvent = true;
            int num = Integer.parseInt(NumberProcessor.getInstance().getCurrentNumStr());
            RunAvgCalnQueue q = RunAvgCalnQueue.getInstance();
            if (q.isQueueFull()) {
                q.dequeue();
            }
            q.enqueue(num);

            int[] elemArr = q.getElementsInQueue();
            
            for (int i = 0; i < q.getElemsInQueueCount(); i += 1) {
                avg += elemArr[i];
            }
            avg /= (double) q.getElemsInQueueCount();
            outputStr = outputStr.concat(avg+"\n");
            //System.out.println(outputStr);

       // }
    }
}
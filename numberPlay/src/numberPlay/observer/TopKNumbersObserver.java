package numberPlay.observer;

import numberPlay.filter.FilterI;
import numberPlay.filter.FloatingPointEventFilter;
import numberPlay.filter.IntegerEventFilter;
import numberPlay.filter.ProcessingCompleteEventFilter;
import numberPlay.util.InputParametersData;
import numberPlay.util.TopKNumbersQueue;

public class TopKNumbersObserver implements ObserverI {

    private static TopKNumbersObserver topKNumObservrsObj;
    private TopKNumbersQueue topKNumArrObj;
    

    private TopKNumbersObserver() {
        topKNumArrObj = new TopKNumbersQueue(InputParametersData.getInstance().getKValue());
    }

    /**
     * Function to get instance of TopKNumbersObserver
     * 
     * @return - The instance of the class TopKNumbersObserver
     */
    public static ObserverI getInstance() {
        if (null == topKNumObservrsObj) {
            topKNumObservrsObj = new TopKNumbersObserver();
        }
        return topKNumObservrsObj;
    }

    @Override
    public void update(FilterI triggerEvent, String dataString) {
        if (triggerEvent.equals(IntegerEventFilter.getInstance())
                || triggerEvent.equals(FloatingPointEventFilter.getInstance())) {

            
            double num = Double.parseDouble(dataString);
            if (topKNumArrObj.isQueueFull()) {
                topKNumArrObj.dequeue();
            }
            topKNumArrObj.enqueue(num);
            double[] arr = topKNumArrObj.getElementsInQueue();

            for (int i = topKNumArrObj.getElemsInQueueCount() - 1; i >= 0; i -= 1) {
                System.out.print(arr[i] + ", ");
            }
            System.out.println();

        } else {
            if (triggerEvent.equals(ProcessingCompleteEventFilter.getInstance())) {

            }
        }

    }
}
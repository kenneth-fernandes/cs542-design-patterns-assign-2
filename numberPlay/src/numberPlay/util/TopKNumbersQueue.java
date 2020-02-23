package numberPlay.util;

import java.util.Arrays;


public class TopKNumbersQueue {
    private double[] topKNumArr;
    private int arrSize;
    private int startIndex;
    private int endIndex;
    private UtilityConstants utilConstsObj;

    public TopKNumbersQueue(int kValue) {
        topKNumArr = new double[kValue];
        arrSize = kValue;
        startIndex = 0;
        endIndex = 0;
        utilConstsObj = UtilityConstants.getInstance();

    }

    public int getElemsInQueueCount() {
        return endIndex;
    }

    public boolean isQueueEmpty() {
        return endIndex == startIndex;
    }

    public boolean isQueueFull() {
        return endIndex == arrSize;
    }

    public double peek() {
        if (isQueueEmpty()) {
            System.out.println(utilConstsObj.QUEUE_EMPTY_MSG);
            return Double.MIN_VALUE;
        }
        return topKNumArr[startIndex];
    }

    public void enqueue(double element) {
        if (isQueueFull()) {
            System.out.println(utilConstsObj.QUEUE_FULL_MSG);
            return;
        } else {
            topKNumArr[endIndex] = element;
            endIndex += 1;
            Arrays.sort(topKNumArr, startIndex, endIndex);

        }
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println(utilConstsObj.QUEUE_EMPTY_MSG);
        } else {
            for (int i = 0; i < endIndex - 1; i += 1) {
                topKNumArr[i] = topKNumArr[i + 1];
            }
            if (endIndex < arrSize) {
                topKNumArr[endIndex] = 0;
            }
            endIndex -= 1;
        }
    }

    public double[] getElementsInQueue() {
        return topKNumArr;
    }

}
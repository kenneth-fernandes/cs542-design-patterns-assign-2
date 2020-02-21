package numberPlay.util;

public class RunAvgCalnQueue implements QueueI {
    private static RunAvgCalnQueue queueObj;

    private int[] queueArr;
    private int queueWindowSize;
    private int queueFront;
    private int queueRear;

    private RunAvgCalnQueue(int windowSize) {
        queueArr = new int[windowSize];
        queueWindowSize = windowSize;
        queueFront = 0;
        queueRear = 0;

    }

    public static RunAvgCalnQueue getInstance() {
        if (null == queueObj)
            queueObj = new RunAvgCalnQueue(InputParametersData.getInstance().getRunAvgWindowSize());

        return queueObj;
    }

    public int getElemsInQueueCount() {
        return queueRear;
    }

    public boolean isQueueEmpty() {
        return queueRear == queueFront;
    }

    public boolean isQueueFull() {
        return queueRear == queueWindowSize;
    }

    public int peek() {
        if (isQueueEmpty()) {
            System.out.println("Queue is empty.");
            return Integer.MIN_VALUE;
        }
        return queueArr[queueFront];
    }

    public void enqueue(int element) {
        if (isQueueFull()) {
            System.out.println("Queue is full.");
            return;
        } else {
           // System.out.println("Inserting elem : " + element + " at "+ queueRear);
            queueArr[queueRear] = element;
            queueRear += 1;

        }
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            for (int i = 0; i < queueRear - 1; i += 1) {
                queueArr[i] = queueArr[i+1];
            }
            if (queueRear < queueWindowSize) {
                queueArr[queueRear] = 0;
            }
            queueRear -= 1;
        }
    }

    public int[] getElementsInQueue() {
        return queueArr;
    }
}
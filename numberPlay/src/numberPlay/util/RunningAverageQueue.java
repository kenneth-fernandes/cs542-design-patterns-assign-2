package numberPlay.util;

public class RunningAverageQueue implements QueueI {
    // private static Queue queueObj;

    private int[] queueArr;
    private int queueWindowSize;
    private int queueFront;
    private int queueRear;
    private UtilityConstants utilConstsObj;

    public RunningAverageQueue(int windowSize) {
        queueArr = new int[windowSize];
        queueWindowSize = windowSize;
        queueFront = 0;
        queueRear = 0;
        utilConstsObj = UtilityConstants.getInstance();

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
            System.out.println(utilConstsObj.QUEUE_EMPTY_MSG);
            return Integer.MIN_VALUE;
        }
        return queueArr[queueFront];
    }

    public void enqueue(int element) {
        if (isQueueFull()) {
            System.out.println(utilConstsObj.QUEUE_FULL_MSG);
            return;
        } else {
            queueArr[queueRear] = element;
            queueRear += 1;

        }
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println(utilConstsObj.QUEUE_EMPTY_MSG);
        } else {
            for (int i = 0; i < queueRear - 1; i += 1) {
                queueArr[i] = queueArr[i + 1];
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
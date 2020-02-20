package numberPlay.util;

public class RunAvgCalnQueue implements QueueI {
    private static RunAvgCalnQueue queueObj;

    private int[] queueArr;
    private int queueWindowSize;
    private int queueFront;
    private int queueRear;
    private int queueElemCount;

    private RunAvgCalnQueue(int windowSize) {
        queueArr = new int[windowSize];
        queueWindowSize = windowSize;
        queueElemCount = 0;
        queueFront = 0;
        queueRear = -1;

    }

    public static RunAvgCalnQueue getInstance() {
        if (null == queueObj)
            queueObj = new RunAvgCalnQueue(InputParametersData.getInstance().getRunAvgWindowSize());

        return queueObj;
    }

    public int getQueueSize() {
        return queueElemCount;
    }

    public boolean isQueueEmpty() {
        return queueElemCount == 0;
    }

    public boolean isQueueFull() {
        return queueElemCount == queueWindowSize;
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
            queueRear = (++queueRear) % queueWindowSize;
            queueArr[queueRear] = element;
            queueElemCount += 1;
        }
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            queueFront = (++queueFront) % queueWindowSize;
            queueElemCount -= 1;
        }
    }
}
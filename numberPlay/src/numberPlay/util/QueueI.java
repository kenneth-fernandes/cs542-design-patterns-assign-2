package numberPlay.util;

public interface QueueI {
    public int getQueueSize();

    public boolean isQueueEmpty();

    public boolean isQueueFull();

    public int peek();

    public void enqueue(int element);

    public void dequeue();

}
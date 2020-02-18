/**
 * @author jgz
 * @Date 2020-02-17 16:26
 */
public class DesignCircularQueue {

    private final int capacity;
    private int[] arr;
    private int front;
    private int rear;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public DesignCircularQueue(int k) {
        this.capacity = k+1;
        arr = new int[capacity];
        front = 0;
        rear = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        arr[rear] = value;
        rear = (rear+1)%capacity;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front+1) % capacity;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) return -1;
        return arr[(rear + capacity -1) % capacity];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return front == rear ? true:false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (rear+1) % capacity == front ? true:false;
    }
}

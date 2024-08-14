package synthesizer;

import java.util.Iterator;

// items can only be enqueued at the back of the queue, and can only be dequeued from the front of the queue.
// Unlike our Deque,the BoundedDeque has a fixed capacity, and nothing is allowed to enqueue if the queue is full.

public interface BoundedQueue<T> extends Iterable<T> {
    // return size of the buffer
    int capacity();

    // return number of items currently in the buffer
    int fillCount();

    // add item x to the end
    void enqueue(T x);

    // delete and return item from the front
    T dequeue();

    // return (but do not delete) item from the front
    T peek();

    /** return an iterator */
    Iterator<T> iterator();

    // is the buffer empty (fillCount equals zero)?
    default boolean isEmpty() {
        return fillCount() == 0;
    }

    // is the buffer full (fillCount is same as capacity)?
    default boolean isFull() {
        return fillCount() == capacity();
    }
}

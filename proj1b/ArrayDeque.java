public class ArrayDeque<T> implements Deque<T> {
    private int size;
    private int elementSize;
    private int nextFirst;
    private int nextLast;
    private T[] dequeContainer;

    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        this.size = 8;
        this.elementSize = 0;
        nextFirst = 0;
        nextLast = 1;
        dequeContainer = (T[]) new Object[size];
    }

    // 25% Usage
    @SuppressWarnings("unchecked")
    private void resize() {
        if (elementSize == size) {
            T[] newDequeContainer = (T[]) new Object[size * 2];
            int firstElementIndex = (nextFirst == size - 1 ? 0 : nextFirst + 1);
            for (int i = firstElementIndex, j = 0; j != elementSize; i++, j++) {
                newDequeContainer[j] = dequeContainer[i % size];
            }

            size *= 2;
            nextFirst = size - 1;
            nextLast = elementSize;
            dequeContainer = newDequeContainer;
        }

        if (elementSize != 0 && ((double)elementSize / size) < 0.25) {
            T[] newDequeContainer = (T[]) new Object[size / 2];
            int firstElementIndex = (nextFirst == size - 1 ? 0 : nextFirst + 1);
            int orgSize = size;
            size /= 2;

            for (int i = firstElementIndex, j = 0; j != elementSize; i++, j++) {
                newDequeContainer[j] = dequeContainer[i % orgSize];
            }

            nextFirst = size - 1;
            nextLast = elementSize;
            dequeContainer = newDequeContainer;
        }
    }

    // Adds an item of type T to the front of the deque.
    @Override
    public void addFirst(T item) {
        if (elementSize == size) {
            resize();
        }

        dequeContainer[nextFirst] = item;
        elementSize += 1;
        if (nextFirst == 0) {
            nextFirst = size - 1;
        } else {
            nextFirst -= 1;
        }
    }

    // Adds an item of type T to the back of the deque.
    @Override
    public void addLast(T item) {
        if (elementSize == size) {
            resize();
        }

        dequeContainer[nextLast] = item;
        elementSize += 1;
        if (nextLast == size - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
    }

    @Override
    public boolean isEmpty() {
        return elementSize == 0;
    }

    // Returns the number of items in the deque.
    @Override
    public int size() {
        return elementSize;
    }

    // Prints the items in the deque from first to last, separated by a space.
    @Override
    public void printDeque() {
        int firstElementIndex = (nextFirst == size - 1 ? 0 : nextFirst + 1);
        int lastElementIndex = (nextLast == 0 ? size - 1 : nextLast - 1);
        for (int i = firstElementIndex; i % size != lastElementIndex + 1 ; i++) {
            System.out.println(dequeContainer[i]);
        }
    }

    // Removes and returns the item at the front of the deque. If no such item exists, returns null.
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        nextFirst = (nextFirst == size - 1 ? 0 : nextFirst + 1);
        T item = dequeContainer[nextFirst];
        dequeContainer[nextFirst] = null;
        elementSize -= 1;

        resize();

        return item;
    }

    // Removes and returns the item at the back of the deque. If no such item exists, returns null.
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        nextLast = (nextLast == 0 ? size - 1 : nextLast - 1);
        T item = dequeContainer[nextLast];
        dequeContainer[nextLast] = null;
        elementSize -= 1;

        resize();

        return item;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists,
    // returns null. Must not alter the deque!
    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }

        int targetIndex = (nextFirst + 1 + index) % size;
        return dequeContainer[targetIndex];
    }
}

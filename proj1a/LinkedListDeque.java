public class LinkedListDeque<T> {
    private final DequeNode firstSentinel = new DequeNode();
    private final DequeNode lastSentinel = new DequeNode();
    private int size;

    public class DequeNode {
        public T item;
        public DequeNode next;
        public DequeNode previous;
    }

    public LinkedListDeque () {
        firstSentinel.item = null;
        firstSentinel.next = lastSentinel;
        firstSentinel.previous = lastSentinel;
        lastSentinel.item = null;
        lastSentinel.next = firstSentinel;
        lastSentinel.previous = firstSentinel;
    }

    // Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        DequeNode dequeNode = new DequeNode();
        dequeNode.item = item;
        dequeNode.next = firstSentinel.next;
        dequeNode.previous = firstSentinel;

        dequeNode.next.previous = dequeNode;
        firstSentinel.next = dequeNode;

        size += 1;
    }

    // Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        DequeNode dequeNode = new DequeNode();
        dequeNode.item = item;
        dequeNode.previous = lastSentinel.previous;
        dequeNode.next = lastSentinel;

        dequeNode.previous.next = dequeNode;
        lastSentinel.previous = dequeNode;

        size += 1;
    }

    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        return firstSentinel.next == lastSentinel && firstSentinel.previous == lastSentinel
                && lastSentinel.next == firstSentinel && lastSentinel.previous == firstSentinel;
    }

    // Returns the number of items in the deque.
    public int size() {
        return size;
    }

    // Prints the items in the deque from first to last, separated by a space.
    public void printDeque() {
        DequeNode firstNode = firstSentinel;
        DequeNode lastNode = lastSentinel;
        while (firstNode.next != lastNode) {
            DequeNode node = firstNode.next;
            System.out.println(node.item);
            firstNode = firstNode.next;
        }
    }

    // Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst() {
        if (size() == 0) {
            return null;
        }

        T item = firstSentinel.next.item;
        firstSentinel.next.next.previous = firstSentinel;
        firstSentinel.next = firstSentinel.next.next;
        size -= 1;
        return item;
    }

    // Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast() {
        if (size() == 0) {
            return null;
        }

        T item = lastSentinel.previous.item;
        lastSentinel.previous.previous.next = lastSentinel;
        lastSentinel.previous = lastSentinel.previous.previous;

        size -= 1;
        return item;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists,
    // returns null. Must not alter the deque!
    public T get(int index) {
        DequeNode firstNode = firstSentinel.next;
        DequeNode lastNode = lastSentinel;

        int countIndex = 0;
        while (firstNode != lastNode) {
            if (countIndex == index) {
                return firstNode.item;
            }

            firstNode = firstNode.next;
            countIndex++;
        }

        return null;
    }

    private T getRecursiveHelp(DequeNode start, int index) {
        if (index == 0) {
            return start.item;
        }

        return getRecursiveHelp(start.next, index - 1);
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }

        return getRecursiveHelp(firstSentinel.next, index);
    }
}

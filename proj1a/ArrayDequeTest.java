//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayDequeTest {

    @Test
    public void testaddsizeempty() {
        ArrayDeque<String> dq = new ArrayDeque<>();
        assertEquals(true, dq.isEmpty());

        dq.addFirst("first");
        assertEquals(1, dq.size());

        dq.addLast("last");
        assertEquals(2, dq.size());

        dq.printDeque();

        String first = dq.removeFirst();
        assertEquals("first", first);

        String last = dq.removeLast();
        assertEquals("last", last);

        assertEquals(0, dq.size());
    }

    public ArrayDeque<Integer> create(int[] array) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int x : array) {
            dq.addLast(x);
        }
        return dq;
    }
    @Test
    public void testgrowshrink() {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < 16; i++) {
            dq.addLast(i);
        }
        for (int i = -16; i < 0; i++) {
            dq.addFirst(i);
        }
        for (Integer i = -1; i >= 16; i--) {
            assertEquals(i, dq.get(i));
        }
        for (int i = 0; i < 30; i++) {
            dq.removeFirst();
        }
        assertEquals(2, dq.size());
        dq.printDeque();
    }

    @Test
    public void testget() {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(0);
        dq.removeLast();
        dq.addFirst(2);
        dq.addLast(3);
        dq.addFirst(4);
        dq.removeLast();
        dq.removeLast();
        Integer item = dq.get(0);
        assertEquals((Integer)4, item);
    }

    public void main(String[] args) {
        testgrowshrink();
    }
}

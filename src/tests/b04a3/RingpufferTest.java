package b04a3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RingpufferTest {

    Ringpuffer<Integer> ringpuffer;

    @BeforeEach
    void setUp() {
        ringpuffer = new Ringpuffer(3);
    }

    @Test
    void sizeTest() {

        ringpuffer.addFirst(1);
        assertEquals(1, ringpuffer.size());
        ringpuffer.addFirst(2);
        assertEquals(2, ringpuffer.size());
    }

    @Test
    void getTest() {
        ringpuffer.addFirst(1);
        ringpuffer.addLast(2);
        assertEquals(1, ringpuffer.get(0));
        assertEquals(2, ringpuffer.get(1));
    }

    @Test
    void getThrowsExceptionTest() {
        assertThrows(IllegalStateException.class, () -> {
            //pos -1 < 0
            ringpuffer.get(-1);
        });
        assertThrows(IllegalStateException.class, () -> {
            // pos 4 > capacity
            ringpuffer.get(4);
        });
        assertThrows(IllegalStateException.class, () -> {
            //pos 1 = null;
            ringpuffer.get(1);
        });
    }

    @Test
    void setTest() {
        ringpuffer.addFirst(1);
        ringpuffer.addLast(2);
        assertEquals(1, ringpuffer.set(0, 10));
        assertEquals(10, ringpuffer.get(0));
        assertEquals(10, ringpuffer.pointer());
    }

    @Test
    void setThrowsExceptionTest() {
        assertThrows(IllegalStateException.class, () -> {
            //pos -1 < 0
            ringpuffer.set(-1, 10);
        });
        assertThrows(IllegalStateException.class, () -> {
            // pos 4 > capacity
            ringpuffer.set(4, 10);
        });
        assertThrows(IllegalStateException.class, () -> {
            //pos 1 = null;
            ringpuffer.set(1, 10);
        });
    }

    @Test
    void addFirstTest() {
        ringpuffer.addFirst(1);
        ringpuffer.addFirst(2);
        assertEquals(2, ringpuffer.get(0));
        assertEquals(1, ringpuffer.get(1));
        assertEquals(2, ringpuffer.size());
        assertEquals(2, ringpuffer.pointer());
    }

    @Test
    void addFirstThrowsExceptionTest() {
        assertThrows(IllegalStateException.class, () -> {
            ringpuffer.addFirst(1);
            ringpuffer.addFirst(2);
            ringpuffer.addFirst(3);
            ringpuffer.addFirst(4);
        });
    }

    @Test
    void addLastTest() {
        ringpuffer.addLast(1);
        ringpuffer.addLast(2);
        assertEquals(1, ringpuffer.get(0));
        assertEquals(2, ringpuffer.get(1));
        assertEquals(2, ringpuffer.size());
    }

    @Test
    void addLastThrowsExceptionTest() {
        assertThrows(IllegalStateException.class, () -> {
            ringpuffer.addLast(1);
            ringpuffer.addLast(2);
            ringpuffer.addLast(3);
            ringpuffer.addLast(4);
        });
    }

    @Test
    void removeFirst() {
        ringpuffer.addLast(1);
        ringpuffer.addLast(2);
        ringpuffer.addLast(3);
        assertEquals(1, ringpuffer.removeFirst());
        assertEquals(2, ringpuffer.size());
        assertEquals(2, ringpuffer.pointer());
        ringpuffer.addLast(4);
        assertEquals(4, ringpuffer.get(0));
        ringpuffer.removeFirst();
        assertEquals(3, ringpuffer.pointer());
    }

    @Test
    void removeFirstThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            ringpuffer.removeFirst();
        });
    }

    @Test
    void removeLast() {
        ringpuffer.addLast(1);
        ringpuffer.addLast(2);
        ringpuffer.addLast(3);
        assertEquals(3, ringpuffer.removeLast());
        assertEquals(2, ringpuffer.size());
        assertEquals(1, ringpuffer.pointer());
        ringpuffer.addLast(4);
        assertEquals(4, ringpuffer.get(2));
        ringpuffer.removeLast();
        assertEquals(2, ringpuffer.size());
    }

    @Test
    void removeLastThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            ringpuffer.removeLast();
        });
    }
}
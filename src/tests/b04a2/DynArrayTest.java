package b04a2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DynArrayTest {

    DynArray<Integer> dynArray;

    @BeforeEach
    void setUp() {
        dynArray = new DynArray<>();
    }

    @Test
    void sizeTest() {
        dynArray.addFirst(1);
        assertEquals(1, dynArray.size());
        dynArray.addLast(2);
        assertEquals(2, dynArray.size());
    }

    @Test
    void capacity() {
        dynArray.addFirst(1);
        assertEquals(1, dynArray.capacity());
        dynArray.addLast(2);
        assertEquals(2, dynArray.capacity());
        dynArray.addLast(3);
        assertEquals(4, dynArray.capacity());
        dynArray.addLast(4);
        assertEquals(4, dynArray.capacity());
        dynArray.addLast(5);
        assertEquals(8, dynArray.capacity());

    }

    @Test
    void getTest() {
        dynArray.addFirst(1);
        dynArray.addLast(2);
        assertEquals(1, dynArray.get(0));
        assertEquals(2, dynArray.get(1));
    }

    @Test
    void getThrowsExceptionTest() {
        assertThrows(IllegalStateException.class, () -> {
            //pos -1 < 0
            dynArray.get(-1);
        });
        assertThrows(IllegalStateException.class, () -> {
            // pos 4 > capacity
            dynArray.get(4);
        });
        assertThrows(IllegalStateException.class, () -> {
            //pos 1 = null;
            dynArray.get(1);
        });
    }

    @Test
    void setTest() {
        dynArray.addFirst(1);
        dynArray.addLast(2);
        assertEquals(1, dynArray.set(0, 10));
        assertEquals(10, dynArray.get(0));
    }

    @Test
    void setThrowsExceptionTest() {
        assertThrows(IllegalStateException.class, () -> {
            //pos -1 < 0
            dynArray.set(-1, 10);
        });
        assertThrows(IllegalStateException.class, () -> {
            // pos 4 > capacity
            dynArray.set(4, 10);
        });
        assertThrows(IllegalStateException.class, () -> {
            //pos 1 = null;
            dynArray.set(1, 10);
        });
    }

    @Test
    void addFirstTest() {
        dynArray.addFirst(1);
        dynArray.addFirst(2);
        assertEquals(2, dynArray.get(0));
        assertEquals(1, dynArray.get(1));
        assertEquals(2, dynArray.size());
        dynArray.addFirst(3);
        assertEquals(4, dynArray.capacity());
    }

    @Test
    void addLastTest() {
        dynArray.addLast(1);
        dynArray.addLast(2);
        assertEquals(1, dynArray.get(0));
        assertEquals(2, dynArray.get(1));
        assertEquals(2, dynArray.size());
        dynArray.addLast(3);
        assertEquals(4, dynArray.capacity());
    }

    @Test
    void removeFirst() {
        dynArray.addLast(1);
        dynArray.addLast(2);
        dynArray.addLast(3);
        assertEquals(1, dynArray.removeFirst());
        assertEquals(2, dynArray.size());
        assertEquals(2, dynArray.removeFirst());
        assertEquals(2, dynArray.capacity());
    }

    @Test
    void removeFirstThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            dynArray.removeFirst();
        });
    }

    @Test
    void removeLastTest() {
        dynArray.addLast(1);
        dynArray.addLast(2);
        dynArray.addLast(3);
        assertEquals(3, dynArray.removeLast());
        assertEquals(2, dynArray.size());
        assertEquals(2, dynArray.removeLast());
        assertEquals(2, dynArray.capacity());
    }

    @Test
    void removeLastThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            dynArray.removeLast();
        });
    }
}
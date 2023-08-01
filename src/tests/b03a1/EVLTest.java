package b03a1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class EVLTest {

    EVL<Integer> evl;

    @BeforeEach
    void setUp() {
        evl = new EVL<>();
        evl.addLast(1);
        evl.addLast(2);
        evl.addLast(3);
    }

    @Test
    void getFirstTest() {
        assertEquals(1, evl.getFirst());
    }

    @Test
    void getLastTest() {
        assertEquals(3, evl.getLast());
    }

    @Test
    void getFirstAndGetLastThrowsExceptionTest() {
        EVL<Integer> evl = new EVL<>();
        assertThrows(NoSuchElementException.class, () -> {
            evl.getFirst();
        });

        assertThrows(NoSuchElementException.class, () -> {
            evl.getLast();
        });
    }

    @Test
    void addLastTest() {
        assertEquals(3, evl.size());
        assertTrue(evl.contains(1));
        assertTrue(evl.contains(2));
        assertTrue(evl.contains(3));
    }

    @Test
    void addLastThrowsExceptionTest() {
        assertThrows(IllegalStateException.class, () -> {
            evl.addLast(null);
        });
    }

    @Test
    void removeLastTest() {

        assertEquals(3, evl.removeLast());
        assertFalse(evl.contains(3));
        assertEquals(2,evl.size());
        assertTrue(evl.contains(1));
        assertTrue(evl.contains(2));
    }

    @Test
    void removeLastThrowsExceptionTest() {
        EVL<Integer> evl = new EVL<>();
        assertThrows(NoSuchElementException.class, () -> {
            evl.removeLast();
        });
    }

    @Test
    void containsTest() {
        assertTrue(evl.contains(1));
        assertTrue(evl.contains(2));
        assertTrue(evl.contains(3));
        assertFalse(evl.contains(10));
        assertFalse(evl.contains(24));
    }

    @Test
    void containsThrowsExceptionTest() {
        EVL<Integer> evl = new EVL<>();
        assertThrows(NoSuchElementException.class, () -> {
            evl.contains(24);
        });
    }

    @Test
    void sizeTest() {
        assertEquals(3, evl.size());
        evl.removeLast();
        assertEquals(2, evl.size());
        evl.addLast(4);
        evl.addLast(5);
        assertEquals(4, evl.size());
    }

    @Test
    void testToStringTest() {
        assertEquals("1-> 2-> 3", evl.toString());
    }
}
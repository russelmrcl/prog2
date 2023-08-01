package b05a3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FolgeMitRingTest {

    FolgeMitRing<Integer> ring;

    @BeforeEach
    void setUp() {
        ring = new FolgeMitRing<>(4);
    }

    @Test
    void isEmptyTest() {
        assertTrue(ring.isEmpty());
        ring.insert(1);
        assertFalse(ring.isEmpty());
        ring.remove();
        assertTrue(ring.isEmpty());
    }

    @Test
    void sizeTest() {
        assertEquals(0, ring.size());
        ring.insert(1);
        ring.insert(2);
        assertEquals(2, ring.size());
        ring.remove();
        assertEquals(1, ring.size());
    }

    @Test
    void capacityTest() {
        assertEquals(4, ring.capacity());
    }

    @Test
    void insertTest() {
        ring.insert(1);
        ring.insert(2);
        assertEquals(2, ring.size());
        assertEquals(2, ring.get(1));
    }

    @Test
    void removeTest() {
        ring.insert(1);
        ring.insert(2);
        assertEquals(1, ring.remove());
        assertEquals(1, ring.size());
    }

    @Test
    void removeThrowsTest() {
        assertThrows(NoSuchElementException.class, () -> {
            ring.remove();
        });
    }

    @Test
    void get() {
        ring.insert(10);
        ring.insert(20);
        assertEquals(10, ring.get(0));
        assertEquals(20, ring.get(1));
        ring.remove();
        assertEquals(20, ring.get(1));
    }

    @Test
    void getThrowsException() {
        assertThrows(IllegalStateException.class, () -> {
            //index < 0
            ring.get(-1);
        });
        assertThrows(IllegalStateException.class, () -> {
            //larger than size
            ring.get(1);
        });
        assertThrows(IllegalStateException.class, () -> {
            //larger than capacity
            ring.get(2);
        });
    }

    @Test
    void set() {
        ring.insert(10);
        assertEquals(10, ring.set(0, 100));
        assertEquals(100, ring.get(0));
    }

    @Test
    void removePosTest() {
        ring.insert(10);
        ring.insert(20);
        ring.insert(30);

        assertEquals(20, ring.remove(1));
        assertEquals(2, ring.size());
        assertEquals(10, ring.get(0));
        assertEquals(30, ring.get(1));
    }

    @Test
    void removePosThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            //ring is empty
            ring.remove(0);
        });
        ring.insert(1);
        assertThrows(IllegalStateException.class, () -> {
            //index < 0
            ring.remove(-1);
        });
        assertThrows(IllegalStateException.class, () -> {
            //larger than size
            ring.remove(1);
        });
        assertThrows(IllegalStateException.class, () -> {
            //larger than capacity
            ring.remove(2);
        });
    }

    @Test
    void insertPosTest() {
        ring.insert(10);
        ring.insert(20);
        ring.insert(30);
        assertEquals(20, ring.get(1));
        ring.insert(1, 100);
        assertEquals(20, ring.get(2));
        ring.remove();
        ring.insert(3, 300);
        assertEquals(30, ring.get(0));
        assertEquals(4, ring.size());
    }

    @Test
    void insertPosThrowsExceptionTest() {
        assertThrows(IllegalStateException.class, () -> {
            //index < 0
            ring.insert(-1, 10);
        });
        assertThrows(IllegalStateException.class, () -> {
            //larger than capacity
            ring.insert(5, 10);
        });
    }
}
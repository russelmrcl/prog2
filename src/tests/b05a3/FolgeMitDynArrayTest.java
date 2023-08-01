package b05a3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FolgeMitDynArrayTest {

    FolgeMitDynArray<Integer> dyn;

    @BeforeEach
    void setUp() {
        dyn = new FolgeMitDynArray<>();
    }

    @Test
    void isEmptyTest() {
        assertTrue(dyn.isEmpty());
        dyn.insert(1);
        assertFalse(dyn.isEmpty());
        dyn.remove();
        assertTrue(dyn.isEmpty());
    }

    @Test
    void sizeTest() {
        assertEquals(0, dyn.size());
        dyn.insert(1);
        dyn.insert(2);
        assertEquals(2, dyn.size());
        dyn.remove();
        assertEquals(1, dyn.size());
    }

    @Test
    void capacityTest() {
        assertEquals(1, dyn.capacity());
        dyn.insert(1);
        dyn.insert(2);
        assertEquals(2, dyn.capacity());
        dyn.insert(3);
        assertEquals(4, dyn.capacity());
    }

    @Test
    void insertTest() {
        dyn.insert(1);
        dyn.insert(2);
        assertEquals(2, dyn.size());
        assertEquals(2, dyn.get(1));
    }

    @Test
    void removeTest() {
        dyn.insert(1);
        dyn.insert(2);
        assertEquals(2, dyn.remove());
        assertEquals(1, dyn.size());
    }

    @Test
    void removeThrowsTest() {
        assertThrows(NoSuchElementException.class, () -> {
            dyn.remove();
        });
    }

    @Test
    void get() {
        dyn.insert(10);
        dyn.insert(20);
        assertEquals(10, dyn.get(0));
        assertEquals(20, dyn.get(1));
        dyn.remove();
        assertEquals(10, dyn.get(0));
    }

    @Test
    void getThrowsException() {
        assertThrows(IllegalStateException.class, () -> {
            //index < 0
            dyn.get(-1);
        });
        assertThrows(IllegalStateException.class, () -> {
            //larger than size
            dyn.get(1);
        });
        assertThrows(IllegalStateException.class, () -> {
            //larger than capacity
            dyn.get(2);
        });
    }

    @Test
    void set() {
        dyn.insert(10);
        assertEquals(10, dyn.set(0, 100));
        assertEquals(100, dyn.get(0));
    }

    @Test
    void removePosTest() {
        dyn.insert(10);
        dyn.insert(20);
        dyn.insert(30);

        assertEquals(20, dyn.remove(1));
        assertEquals(2, dyn.size());
        assertEquals(10, dyn.get(0));
        assertEquals(30, dyn.get(1));
    }

    @Test
    void removePosThrowsException() {

        assertThrows(IllegalStateException.class, () -> {
            //index < 0
            dyn.remove(-1);
        });
        assertThrows(IllegalStateException.class, () -> {
            //larger than size
            dyn.remove(1);
        });
        assertThrows(IllegalStateException.class, () -> {
            //larger than capacity
            dyn.remove(2);
        });
    }

    @Test
    void insertPosTest() {
        dyn.insert(10);
        dyn.insert(20);
        dyn.insert(30);

        dyn.insert(0, 100);
        assertEquals(100, dyn.get(0));
        assertEquals(10, dyn.get(1));
        assertEquals(20, dyn.get(2));
        assertEquals(4, dyn.size());
    }

    @Test
    void insertPosThrowsExceptionTest() {
        assertThrows(IllegalStateException.class, () -> {
            //index < 0
            dyn.insert(-1, 10);
        });
        assertThrows(IllegalStateException.class, () -> {
            //larger than capacity
            dyn.insert(2, 10);
        });
    }
}
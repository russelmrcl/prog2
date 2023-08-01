package b05a4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SchlangeMitRingTest {

    SchlangeMitRing ring;

    @BeforeEach
    void setUp() {
        ring = new SchlangeMitRing(3);
    }

    @Test
    void isEmptyTest() {
        assertTrue(ring.isEmpty());
        ring.insert(1);
        assertFalse(ring.isEmpty());
    }

    @Test
    void sizeTest() {
        assertEquals(0, ring.size());
        ring.insert(1);
        assertEquals(1, ring.size());
        ring.insert(2);
        assertEquals(2, ring.size());
    }

    @Test
    void capacityTest() {
        assertEquals(3, ring.capacity());
    }

    @Test
    void insertTest() {
        ring.insert(1);
        ring.insert(2);
        assertEquals(2, ring.size());
        assertEquals(1, ring.front());
        ring.insert(3);
        assertEquals(3, ring.size());

    }

    @Test
    void insertThrowsExceptionTest() {
        assertThrows(IllegalStateException.class, () -> {
            ring.insert(1);
            ring.insert(2);
            ring.insert(3);
            ring.insert(4);
        });
    }

    @Test
    void removeTest() {
        ring.insert(1);
        ring.insert(2);
        ring.insert(3);
        assertEquals(1, ring.remove());
        assertEquals(2, ring.front());
        assertEquals(2, ring.size());
    }

    @Test
    void removeThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            ring.remove();
        });
    }

    @Test
    void frontTest() {
        ring.insert(1);
        ring.insert(2);
        ring.insert(3);
        assertEquals(1, ring.front());
        ring.remove();
        assertEquals(2, ring.front());
    }

    @Test
    void frontThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            ring.front();
        });
    }
}
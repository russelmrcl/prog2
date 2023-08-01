package b01a2;

import b00a2.StapelMitArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StapelMitArrayTest {

    StapelMitArray stapel;

    @BeforeEach
    void setUp() {
        stapel = new StapelMitArray(3);
    }

    @Test
    void isEmptyTest() {
        assertTrue(stapel.isEmpty());
        stapel.insert(1);
        assertFalse(stapel.isEmpty());
    }

    @Test
    void sizeTest() {
        assertEquals(0, stapel.size());
        stapel.insert(1);
        assertEquals(1, stapel.size());
        stapel.insert(2);
        assertEquals(2, stapel.size());
    }

    @Test
    void capacityTest() {
        assertEquals(3, stapel.capacity());
    }

    @Test
    void insertTest() {
        stapel.insert(1);
        stapel.insert(2);
        assertEquals(2, stapel.size());
        assertEquals(2, stapel.top());
        stapel.insert(3);
        assertEquals(3, stapel.size());
        assertEquals(3, stapel.top());
    }

    @Test
    void insertThrowsExceptionTest() {
        assertThrows(IllegalStateException.class, () -> {
            stapel.insert(1);
            stapel.insert(2);
            stapel.insert(3);
            stapel.insert(4);
        });
    }

    @Test
    void removeTest() {
        stapel.insert(1);
        stapel.insert(2);
        stapel.insert(3);
        assertEquals(3, stapel.remove());
        assertEquals(2, stapel.top());
        assertEquals(2, stapel.size());
    }

    @Test
    void removeThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            stapel.remove();
        });
    }

    @Test
    void top() {
        stapel.insert(1);
        stapel.insert(2);
        assertEquals(2, stapel.top());
        stapel.insert(3);
        assertEquals(3, stapel.top());
        stapel.remove();
        assertEquals(2, stapel.top());
    }

    @Test
    void topThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            stapel.top();
        });
    }
}
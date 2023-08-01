package b02a4;

import b02a3.StapelMitArray;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StapelMitArrayTestWithDouble {

    StapelMitArray<Double> stapel;

    @BeforeEach
    void setUp() {
        stapel = new StapelMitArray<>(3);
    }

    @Test
    void isEmptyTest() {
        assertTrue(stapel.isEmpty());
        stapel.insert(10.7);
        assertFalse(stapel.isEmpty());
    }

    @Test
    void sizeTest() {
        assertEquals(0, stapel.size());
        stapel.insert(17.7);
        stapel.insert(15.9);
        assertEquals(2, stapel.size());
    }

    @Test
    void capacityTest() {
        assertEquals(3, stapel.capacity());
    }

    @Test
    void insert() {
        assertEquals(0, stapel.size());
        stapel.insert(20.5);
        stapel.insert(10.3);
        assertEquals(2, stapel.size());
        assertEquals(10.3, stapel.top());
    }

    @Test
    void insertThrowsExceptionTest() {
        assertThrows(IllegalStateException.class, () -> {
            stapel.insert(10.1);
            stapel.insert(10.2);
            stapel.insert(10.3);
            stapel.insert(10.4);
        });
    }

    @Test
    void removeTest() {
        stapel.insert(10.1);
        stapel.insert(10.2);
        assertEquals(2, stapel.size());
        assertEquals(10.2, stapel.top());
        stapel.remove();
        assertEquals(1, stapel.size());
        assertEquals(10.1, stapel.top());
    }

    @Test
    void removeThrowsExceptionTest() {
        assertThrows(NoSuchElementException.class, () -> {
            stapel.remove();
        });
    }

    @Test
    void topTest() {
        stapel.insert(10.1);
        stapel.insert(10.2);
        assertEquals(10.2, stapel.top());
        stapel.remove();
        assertEquals(10.1, stapel.top());
    }

    @Test
    void topThrowsExceptionTest() {
        assertThrows(NoSuchElementException.class, () -> {
            stapel.top();
        });
    }
}
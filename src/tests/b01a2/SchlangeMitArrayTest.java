package b01a2;

import b00a2.SchlangeMitArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SchlangeMitArrayTest {

    SchlangeMitArray schlange;

    @BeforeEach
    void setUp() {
        schlange = new SchlangeMitArray(3);
    }

    @Test
    void isEmptyTest() {
        assertTrue(schlange.isEmpty());
        schlange.insert(1);
        assertFalse(schlange.isEmpty());
    }

    @Test
    void sizeTest() {
        assertEquals(0, schlange.size());
        schlange.insert(1);
        assertEquals(1, schlange.size());
        schlange.insert(2);
        assertEquals(2, schlange.size());
    }

    @Test
    void capacityTest() {
        assertEquals(3, schlange.capacity());
    }

    @Test
    void insertTest() {
        schlange.insert(1);
        schlange.insert(2);
        assertEquals(2, schlange.size());
        assertEquals(1, schlange.front());
        schlange.insert(3);
        assertEquals(3, schlange.size());

    }

    @Test
    void insertThrowsExceptionTest() {
        assertThrows(IllegalStateException.class, () -> {
            schlange.insert(1);
            schlange.insert(2);
            schlange.insert(3);
            schlange.insert(4);
        });
    }

    @Test
    void removeTest() {
        schlange.insert(1);
        schlange.insert(2);
        schlange.insert(3);
        assertEquals(1, schlange.remove());
        assertEquals(2, schlange.front());
        assertEquals(2, schlange.size());
    }

    @Test
    void removeThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            schlange.remove();
        });
    }

    @Test
    void frontTest() {
        schlange.insert(1);
        schlange.insert(2);
        schlange.insert(3);
        assertEquals(1, schlange.front());
        schlange.remove();
        assertEquals(2, schlange.front());
    }

    @Test
    void frontThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            schlange.front();
        });
    }
}
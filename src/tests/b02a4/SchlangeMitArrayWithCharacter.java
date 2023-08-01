package b02a4;

import b02a3.SchlangeMitArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SchlangeMitArrayWithCharacter {

    SchlangeMitArray<Character> schlange;

    @BeforeEach
    void setUp() {
        schlange = new SchlangeMitArray<>(3);
    }

    @Test
    void isEmptyTest() {
        assertTrue(schlange.isEmpty());
        schlange.insert('R');
        assertFalse(schlange.isEmpty());
    }

    @Test
    void sizeTest() {
        assertEquals(0, schlange.size());
        schlange.insert('R');
        schlange.insert('A');
        assertEquals(2, schlange.size());
    }

    @Test
    void capacityTest() {
        assertEquals(3, schlange.capacity());
    }

    @Test
    void insertTest() {
        assertEquals(0, schlange.size());
        schlange.insert('R');
        schlange.insert('A');
        assertEquals(2, schlange.size());
        assertEquals('R', schlange.front());
    }

    @Test
    void insertThrowsExceptionTest() {
        assertThrows(IllegalStateException.class, () -> {
            schlange.insert('L');
            schlange.insert('O');
            schlange.insert('V');
            schlange.insert('E');
        });
    }

    @Test
    void removeTest() {
        schlange.insert('R');
        schlange.insert('A');
        assertEquals(2, schlange.size());
        assertEquals('R', schlange.front());
        schlange.remove();
        assertEquals(1, schlange.size());
        assertEquals('A', schlange.front());
    }

    @Test
    void removeThrowsExceptionTest() {
        assertThrows(NoSuchElementException.class, () -> {
            schlange.remove();
        });
    }

    @Test
    void frontTest() {
        schlange.insert('R');
        schlange.insert('A');
        assertEquals('R', schlange.front());
        schlange.remove();
        assertEquals('A', schlange.front());
    }

    @Test
    void frontThrowsExceptionTest() {
        assertThrows(NoSuchElementException.class, () -> {
            schlange.front();
        });
    }
}
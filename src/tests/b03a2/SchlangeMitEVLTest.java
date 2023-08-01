package b03a2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SchlangeMitEVLTest {

    SchlangeMitEVL<Integer> schlangeMitEVL;

    @BeforeEach
    void setUp() {
        schlangeMitEVL = new SchlangeMitEVL<>();
        schlangeMitEVL.insert(1);
        schlangeMitEVL.insert(2);
        schlangeMitEVL.insert(3);
    }

    @Test
    void isEmptyTest() {
        assertFalse(schlangeMitEVL.isEmpty());
        schlangeMitEVL.remove();
        schlangeMitEVL.remove();
        schlangeMitEVL.remove();
        assertTrue(schlangeMitEVL.isEmpty());
    }

    @Test
    void sizeTest() {
        assertEquals(3, schlangeMitEVL.size());
        schlangeMitEVL.insert(4);
        assertEquals(4, schlangeMitEVL.size());
        schlangeMitEVL.remove();
        schlangeMitEVL.remove();
        assertEquals(2, schlangeMitEVL.size());
    }

    @Test
    void capacityTest() {
        assertEquals(Integer.MAX_VALUE, schlangeMitEVL.capacity());
    }

    @Test
    void insertTest() {
        schlangeMitEVL.insert(4);
        assertEquals(4, schlangeMitEVL.size());
        assertEquals(1, schlangeMitEVL.front());
        schlangeMitEVL.insert(5);
        assertEquals(5, schlangeMitEVL.size());
    }

    @Test
    void insertThrowsExceptionTest() {
        assertThrows(IllegalStateException.class, () -> {
            schlangeMitEVL.insert(null);
        });
        //Test wird lange dauern!
        /*assertThrows(IllegalStateException.class, () -> {
            SchlangeMitEVL<Integer> schlangeMitEvl = new SchlangeMitEVL<>();
            for (int i = 1; i < Integer.MAX_VALUE; i++) {
                schlangeMitEvl.insert(i);
            }
            schlange.insert(24);
        });*/
    }

    @Test
    void removeTest() {
        assertEquals(1, schlangeMitEVL.remove());
        assertEquals(2, schlangeMitEVL.front());
        assertEquals(2, schlangeMitEVL.size());
        assertEquals(2, schlangeMitEVL.remove());
        assertEquals(1, schlangeMitEVL.size());
    }

    @Test
    void removeThrowsException() {
        SchlangeMitEVL<Integer> schlangeMitEVL = new SchlangeMitEVL<>();
        assertThrows(NoSuchElementException.class, () -> {
            schlangeMitEVL.remove();
        });
    }

    @Test
    void frontTest() {
        assertEquals(1, schlangeMitEVL.front());
        schlangeMitEVL.remove();
        assertEquals(2, schlangeMitEVL.front());
    }

    @Test
    void frontThrowsException() {
        SchlangeMitEVL<Integer> schlangeMitEVL = new SchlangeMitEVL<>();
        assertThrows(NoSuchElementException.class, () -> {
            schlangeMitEVL.front();
        });
    }

    @Test
    void testToString() {
        assertEquals("1-> 2-> 3", schlangeMitEVL.toString());
    }
}
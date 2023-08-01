package b06a1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class IntSuchbaumTest {

    IntSuchbaum baum;

    @BeforeEach
    void setUp() {
        baum = new IntSuchbaum();
    }

    @Test
    void isEmptyTest() {
        assertTrue(baum.isEmpty());
        baum.insert(3);
        assertFalse(baum.isEmpty());
    }

    @Test
    void insertTest() {
        baum.insert(3);
        baum.insert(2);
        baum.insert(5);
        assertTrue(baum.contains(5));
        assertEquals(3, baum.size());
        assertEquals(2, baum.hoehe());
    }

    @Test
    void containsTest() {
        baum.insert(3);
        baum.insert(2);
        assertTrue(baum.contains(3));
        assertTrue(baum.contains(2));
        assertFalse(baum.contains(10));
    }

    @Test
    void containsThrowsTest() {
        assertThrows(NoSuchElementException.class, () -> {
            baum.contains(10);
        });
    }

    @Test
    void toStringTest() {
        baum.insert(3);
        baum.insert(2);
        baum.insert(5);
        baum.insert(4);
        baum.insert(1);
        baum.insert(7);
        assertEquals("(((1)2)3((4)5(7)))", baum.toString());
    }

    @Test
    void hoeheTest() {
        assertEquals(0, baum.hoehe());
        baum.insert(3);
        assertEquals(1, baum.hoehe());
        baum.insert(2);
        baum.insert(5);
        assertEquals(2, baum.hoehe());
        baum.insert(4);
        baum.insert(1);
        baum.insert(7);
        assertEquals(3, baum.hoehe());

    }

    @Test
    void sizeTest() {
        assertEquals(0, baum.size());
        baum.insert(3);
        assertEquals(1, baum.size());
        baum.insert(2);
        baum.insert(5);
        assertEquals(3, baum.size());
        baum.insert(4);
        baum.insert(1);
        baum.insert(7);
        assertEquals(6, baum.size());
    }
}
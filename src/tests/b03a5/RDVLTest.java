package b03a5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RDVLTest {

    private RDVL<String> rdvl;

    @BeforeEach
    void setUp() {
        rdvl = new RDVL<>();
    }

    @Test
    void isEmptyTest() {
        assertTrue(rdvl.isEmpty());
        rdvl.add("Element");
        assertFalse(rdvl.isEmpty());
        rdvl.remove();
        assertTrue(rdvl.isEmpty());
    }

    @Test
    void sizeTest() {
        assertEquals(0, rdvl.size());
        rdvl.add("Element");
        assertEquals(1, rdvl.size());
        rdvl.remove();
        assertEquals(0, rdvl.size());
    }

    @Test
    void addTest() {
        rdvl.add("Element");
        assertEquals("Element", rdvl.element());
        rdvl.add("New Element");
        assertEquals("Element", rdvl.element());
        rdvl.next(1);
        assertEquals("New Element", rdvl.element());
    }

    @Test
    void addThrowsExceptionTest() {
        assertThrows(IllegalStateException.class, () -> {
            rdvl.add(null);
        });
    }

    @Test
    void removeTest() {
        rdvl.add("Element");
        assertEquals("Element", rdvl.remove());
        assertTrue(rdvl.isEmpty());
    }

    @Test
    void removeThrowsExceptionTest() {
        assertThrows(NoSuchElementException.class, () -> {
            rdvl.remove();
        });
    }

    @Test
    void nextTest() {
        rdvl.add("Element1");
        rdvl.add("Element2");
        rdvl.add("Element3");

        rdvl.next(2);
        assertEquals("Element3", rdvl.element());

        rdvl.next(1);
        assertEquals("Element1", rdvl.element());
    }

    @Test
    void prevTest() {
        rdvl.add("Element1");
        rdvl.add("Element2");
        rdvl.add("Element3");

        rdvl.prev(2);
        assertEquals("Element2", rdvl.element());

        rdvl.prev(1);
        assertEquals("Element1", rdvl.element());
    }
}
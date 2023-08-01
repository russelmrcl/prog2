package b06a4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class IntSuchbaumTest {

    IntSuchbaum baum;

    @BeforeEach
    void setUp() {
        baum = new IntSuchbaum();
        baum.insert(6);
        baum.insert(4);
        baum.insert(1);
        baum.insert(9);
        baum.insert(7);
        baum.insert(10);
        baum.insert(8);
    }

    @Test
    void removeNodeWithoutSuccessor() {
        assertTrue(baum.contains(8));
        baum.remove(8);
        assertFalse(baum.contains(8));
        assertEquals(6, baum.size());
        assertEquals("(((1)4)6((7)9(10)))", baum.toString());
    }

    @Test
    void removeNodeWithOneSuccessor() {
        assertTrue(baum.contains(4));
        baum.remove(4);
        assertFalse(baum.contains(4));
        assertEquals(6, baum.size());
        assertEquals("((1)6((7(8))9(10)))", baum.toString());
    }

    @Test
    void removeNodeWithTwoSuccessor() {
        assertTrue(baum.contains(9));
        baum.remove(9);
        assertFalse(baum.contains(9));
        assertEquals(6, baum.size());
        assertEquals("(((1)4)6((7)8(10)))", baum.toString());
    }

    @Test
    void removeThrowExceptionTest() {
        IntSuchbaum baum = new IntSuchbaum();
        assertThrows(NoSuchElementException.class, () -> {
            baum.remove(0);
        });
        baum.insert(3);
        baum.insert(2);
        baum.insert(1);
        assertThrows(IllegalArgumentException.class, () -> {
            baum.remove(10);
        });
    }
}
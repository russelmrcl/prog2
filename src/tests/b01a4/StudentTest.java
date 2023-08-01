package b01a4;

import b00a3.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student x;
    Student y;
    Student z;

    @BeforeEach
    void setUp() {
        x = new Student("Marcelo", "Russel", 9047365);
        y = new Student("Marcelo", "Russel", 9047365);
        z = new Student("Marcelo", "Russel", 9047365);
    }

    @Test
    void testReﬂexivitaet() {
        assertTrue(x.equals(x));
    }

    @Test
    void testSymmetrie() {
        assertTrue(x.equals(y));
        assertTrue(y.equals(x));
    }

    @Test
    void testTransitivitaet() {
        assertTrue(x.equals(y));
        assertTrue(y.equals(z));
        assertTrue(x.equals(z));
    }

    @Test
    void testKonsistenz() {
        for (int i = 0; i < 1000; i++) {
            assertEquals(x.equals(y), y.equals(x));
        }
    }

    @Test
    void nullVerschiedenheit() {
        assertNotEquals(x, null);
    }
}
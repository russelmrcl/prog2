package b02a7;

import b02a6.Paar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaarTest {

    Paar<Integer, String> paar1;

    @BeforeEach
    void setUp() {
        paar1 = new Paar<>(10, "Russel");
    }

    @Test
    void getErstesTest() {
        assertEquals(10, paar1.getErstes());
    }

    @Test
    void getZweitesTest() {
        assertEquals("Russel", paar1.getZweites());
    }

    @Test
    void setErstesTest() {
        paar1.setErstes(5);
        assertEquals(5, paar1.getErstes());
    }

    @Test
    void setZweitesTest() {
        paar1.setZweites("Arbnora");
        assertEquals("Arbnora", paar1.getZweites());
    }

    @Test
    void setBeidesTest() {
        paar1.setBeides(5, "Arbnora");
    }

    @Test
    void equalsTest() {
        Paar<Integer, String> paar2 = new Paar<>(5, "Arbnora");
        Paar<Integer, String> paar3 = new Paar<>(10, "Arbnora");
        assertTrue(paar2.equals(paar2));
        assertFalse(paar2.equals(paar3));
        assertFalse(paar1.equals(paar3));
    }

    @Test
    void toStringTest() {
        assertEquals("(10,Russel)", paar1.toString());
    }
}
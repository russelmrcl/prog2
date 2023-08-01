package b03a4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EVLZipTest {

    EVL<Integer> evl1;
    EVL<Integer> evl2;

    @BeforeEach
    void setUp() {
        evl1 = new EVL<>();
        evl2 = new EVL<>();
    }

    @Test
    public void zipEmptyListsTest() {

        evl1.zip(evl2);
        assertTrue(evl1.isEmpty());
        assertTrue(evl2.isEmpty());
    }

    @Test
    public void zipFirstListEmptyTest() {

        evl2.addLast(1);
        evl2.addLast(2);
        evl2.addLast(3);

        evl1.zip(evl2);

        assertEquals(3, evl1.size());
        assertEquals(1, evl1.getFirst());
        assertEquals(3, evl1.getLast());
        assertEquals("1-> 2-> 3", evl1.toString());
        assertTrue(evl2.isEmpty());
    }

    @Test
    public void zipSecondListEmptyTest() {

        evl1.addLast(1);
        evl1.addLast(2);
        evl1.addLast(3);

        evl2.zip(evl1);

        assertEquals(3, evl2.size());
        assertEquals(1, evl2.getFirst());
        assertEquals(3, evl2.getLast());
        assertEquals("1-> 2-> 3", evl2.toString());
        assertTrue(evl1.isEmpty());
    }

    @Test
    public void zipEqualSizeListsTest() {

        evl1.addLast(1);
        evl1.addLast(3);
        evl1.addLast(5);

        evl2.addLast(2);
        evl2.addLast(4);
        evl2.addLast(6);

        evl1.zip(evl2);

        assertEquals(6, evl1.size());
        assertEquals(1, evl1.getFirst());
        assertEquals(6, evl1.getLast());
        assertEquals("1-> 2-> 3-> 4-> 5-> 6", evl1.toString());
        assertTrue(evl2.isEmpty());
    }

    @Test
    public void zipFirstListLargerTest() {

        evl1.addLast(1);
        evl1.addLast(3);
        evl1.addLast(5);
        evl1.addLast(6);

        evl2.addLast(2);
        evl2.addLast(4);

        evl1.zip(evl2);

        assertEquals(6, evl1.size());
        assertEquals(1, evl1.getFirst());
        assertEquals(6, evl1.getLast());
        assertEquals("1-> 2-> 3-> 4-> 5-> 6", evl1.toString());
        assertTrue(evl2.isEmpty());
    }

    @Test
    public void zipSecondListLargerTest() {

        evl1.addLast(1);
        evl1.addLast(3);
        evl1.addLast(5);
        evl1.addLast(6);

        evl2.addLast(2);
        evl2.addLast(4);

        evl1.zip(evl2);

        assertEquals(6, evl1.size());
        assertEquals(1, evl1.getFirst());
        assertEquals(6, evl1.getLast());
        assertEquals("1-> 2-> 3-> 4-> 5-> 6", evl1.toString());
        assertTrue(evl2.isEmpty());
    }

}
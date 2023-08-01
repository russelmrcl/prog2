package b01a3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StapelMitArrayTest {

    StapelMitArray stapel;

    @BeforeEach
    void setUp() {
        stapel = new StapelMitArray(5);
    }

    @Test
    void applyToAllVerdoppeln() {

        int array[] = {1, 2, 3, 4, 5};
        for (int i = 0; i < array.length; i++) {
            stapel.insert(array[i]);
        }
        stapel.applyToAll((v) -> v * 2);

        for (int i = stapel.size() - 1; 0 <= i; i--) {
            assertEquals(array[i] * 2, stapel.remove());
        }
    }

    @Test
    void applyToAllQuadrieren() {

        int array[] = {1, 2, 3, 4, 5};
        for (int i = 0; i < array.length; i++) {
            stapel.insert(array[i]);
        }
        stapel.applyToAll((q) -> q * q);

        for (int i = stapel.size() - 1; 0 <= i; i--) {
            assertEquals(array[i] * array[i], stapel.remove());
        }
    }
}
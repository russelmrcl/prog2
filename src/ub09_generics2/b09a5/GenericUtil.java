package b09a5;

import b08a4.Puffer;
import b08a4.Schlange;
import b08a4.SchlangeMitEVL;

import java.util.Random;

public abstract class GenericUtil {

    public static <T> T gambling(T o1, T o2) {
        return new Random().nextBoolean() ? o1 : o2;
    }

    public static <T> Schlange<T> arrayToSchlange(T[] array) {
        Schlange<T> schlange = new SchlangeMitEVL<>();
        for (T value : array) {
            schlange.insert(value);
        }
        return schlange;
    }

    public static <T extends Puffer> T gambling(T o1, T o2) {
        return new Random().nextBoolean() ? o1 : o2;
    }

    public static <T> void printAll(Iterable<T> obj) {
        for (T value : obj) {
            System.out.println(value);
        }
    }

    public static <U> void insertInto(Puffer<U> puffer, U[] array) {
        for (U value : array) {
            puffer.insert(value);
        }
    }

    public static <U> void insertInto(Puffer<U> puffer1, Puffer<U> puffer2) {
        while (!puffer2.isEmpty()) {
            puffer1.insert(puffer2.remove());
        }
    }

}

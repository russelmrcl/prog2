package b09a6;

import b05a2.Folge;
import b05a3.FolgeMitRing;
import b08a4.FolgeMitDynArray;
import b08a4.Puffer;
import b08a4.Schlange;
import b08a4.SchlangeMitEVL;

import java.util.Iterator;
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

    public static <T extends Comparable<T>> Folge<T> getMinima(Puffer<T> puffer1, Puffer<T> puffer2) {

        Folge<T> result = new FolgeMitDynArray<>();

        if (puffer1.isEmpty() && puffer2.isEmpty()) {
            return result;
        }

        Iterator<T> i1 = puffer1.iterator();
        Iterator<T> i2 = puffer2.iterator();
        while (i1.hasNext() && i2.hasNext()) {
            T value1 = i1.next();
            T value2 = i2.next();
            result.insert(value1.compareTo(value2) <= 0 ? value1 : value2);
        }
        while (i1.hasNext()) {
            result.insert(i1.next());
        }
        while (i2.hasNext()) {
            result.insert(i2.next());
        }
        return result;


    }

}

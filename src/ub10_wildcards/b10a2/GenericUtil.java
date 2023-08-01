package b10a2;

import b05a2.Folge;
import b08a4.FolgeMitDynArray;
import b08a4.Puffer;

import java.util.Iterator;

public abstract class GenericUtil {

    public static <T extends Comparable<? super T>> Folge<T> getMinima(Puffer<? extends T> puffer1, Puffer<? extends T> puffer2) {

        Folge<T> result = new FolgeMitDynArray<>();
        if (puffer1.isEmpty() && puffer2.isEmpty()) {
            return result;
        }

        Iterator<? extends T> i1 = puffer1.iterator();
        Iterator<? extends T> i2 = puffer2.iterator();
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

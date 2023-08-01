package b10a3;

import b05a2.Folge;
import b08a4.FolgeMitDynArray;
import b08a4.Puffer;

import java.util.Comparator;
import java.util.Iterator;

public abstract class GenericUtil {

    public static <T> Folge<T> getMinima(Puffer<? extends T> puffer1, Puffer<? extends T> puffer2, Comparator<? super T> comp) {

        Folge<T> result = new FolgeMitDynArray<>();
        if (puffer1.isEmpty() && puffer2.isEmpty()) {
            return result;
        }

        Iterator<? extends T> i1 = puffer1.iterator();
        Iterator<? extends T> i2 = puffer2.iterator();
        while (i1.hasNext() && i2.hasNext()) {
            T value1 = i1.next();
            T value2 = i2.next();
            result.insert(comp.compare(value1, value2) <= 0 ? value1 : value2);
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

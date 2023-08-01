package b09a2;

import b08a4.*;

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

}

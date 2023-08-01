package b09a1;

import java.util.Random;

public abstract class GenericUtil {

    public static <T> T gambling(T o1, T o2) {
        return new Random().nextBoolean() ? o1 : o2;
    }



}

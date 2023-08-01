package b02a3;

import java.util.NoSuchElementException;

public interface Puffer<T> {

    boolean isEmpty();

    int size();

    int capacity();

    void insert(T i) throws IllegalStateException;

    T remove() throws NoSuchElementException;

}

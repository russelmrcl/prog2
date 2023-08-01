package b08a4;

import java.util.NoSuchElementException;

public interface Puffer<T> extends Iterable<T> {

    boolean isEmpty();

    int size();

    int capacity();

    void insert(T i) throws IllegalStateException;

    T remove() throws NoSuchElementException;

}

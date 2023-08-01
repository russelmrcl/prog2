package b00a2;

import java.util.NoSuchElementException;

public interface Puffer {

    boolean isEmpty();

    int size();

    int capacity();

    void insert(Integer i) throws IllegalStateException;

    int remove() throws NoSuchElementException;

}

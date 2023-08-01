package b05a4;

import b02a3.Schlange;
import b04a3.Ringpuffer;

import java.util.NoSuchElementException;

public class SchlangeMitRing<T> implements Schlange<T> {

    private Ringpuffer schlange;

    public SchlangeMitRing(int capacity) {
        schlange = new Ringpuffer<>(capacity);
    }

    @Override
    public boolean isEmpty() {
        return schlange.isEmpty();
    }

    @Override
    public int size() {
        return schlange.size();
    }

    @Override
    public int capacity() {
        return schlange.capacity();
    }

    @Override
    public void insert(T i) throws IllegalStateException {
        schlange.addLast(i);
    }

    @Override
    public T remove() throws NoSuchElementException {
        return (T) schlange.removeFirst();
    }

    @Override
    public T front() throws NoSuchElementException {
        return (T) schlange.pointer();
    }
}

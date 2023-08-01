package b03a2;

import b02a3.Schlange;
import b03a1.EVL;

import java.util.NoSuchElementException;

public class SchlangeMitEVL<T> implements Schlange<T> {

    private EVL<T> schlangeMitEvl;

    public SchlangeMitEVL() {
        schlangeMitEvl = new EVL<>();
    }


    @Override
    public boolean isEmpty() {
        return schlangeMitEvl.size() == 0;
    }

    @Override
    public int size() {
        return schlangeMitEvl.size();
    }

    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void insert(T i) throws IllegalStateException {
        schlangeMitEvl.addLast(i);
    }

    @Override
    public T remove() throws NoSuchElementException {
        return schlangeMitEvl.removeFirst();
    }

    @Override
    public T front() throws NoSuchElementException {
        return schlangeMitEvl.getFirst();
    }

    @Override
    public String toString() {
        return schlangeMitEvl.toString();
    }
}

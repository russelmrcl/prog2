package b08a4;

import b05a2.Folge;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FolgeMitDynArray<T> implements Folge<T>, Iterable<T> {

    private DynArray<T> dynArray;

    public FolgeMitDynArray() {
        dynArray = new DynArray<>();
    }

    @Override
    public boolean isEmpty() {
        return dynArray.isEmpty();
    }

    @Override
    public int size() {
        return dynArray.size();
    }

    @Override
    public int capacity() {
        return dynArray.capacity();
    }

    @Override
    public void insert(T i) throws IllegalStateException {
        dynArray.addLast(i);
    }

    @Override
    public T remove() throws NoSuchElementException {
        return dynArray.removeLast();
    }

    @Override
    public T get(int pos) {
        return dynArray.get(pos);
    }

    @Override
    public T set(int pos, T e) {
        return dynArray.set(pos, e);
    }

    @Override
    public T remove(int pos) {

        if (pos < 0 || pos > capacity() - 1 || pos > size()) {
            throw new IllegalStateException();
        }
        T removedElement = dynArray.get(pos);
        for (int i = pos; i < size() - 1; i++) {
            dynArray.set(i, dynArray.get(i + 1));
        }
        dynArray.removeLast();
        return removedElement;
    }

    @Override
    public void insert(int pos, T e) {

        if (pos < 0 || pos > capacity() - 1 || pos > size()) {
            throw new IllegalStateException();
        }
        dynArray.addLast(dynArray.set(pos, e));
        for (int i = size() - 1; i > pos; i--) {
            dynArray.set(i, dynArray.get(i - 1));
        }
        dynArray.set(pos, e);
    }
    
    @Override
    public Iterator<T> iterator() {
        return dynArray.iterator();
    }

    @Override
    public String toString() {
        return dynArray.toString();
    }
}

package b08a4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StapelMitArray<T> implements Stapel<T> {

    private T[] data;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public StapelMitArray(int maxGroesse) {
        data = (T[]) new Object[maxGroesse];
        currentSize = -1;
    }


    @Override
    public boolean isEmpty() {
        return currentSize == -1;
    }

    @Override
    public int size() {
        return currentSize + 1;
    }

    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public void insert(T i) throws IllegalStateException {
        if (size() == capacity()) {
            throw new IllegalStateException();
        }
        data[++currentSize] = i;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return data[currentSize--];
    }

    @Override
    public T top() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return data[currentSize];
    }

    @Override
    public Iterator<T> iterator() {
        return new StapelIterator();
    }

    private class StapelIterator implements Iterator<T> {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return data[index++];
        }
    }
}

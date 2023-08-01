package b02a3;

import java.util.NoSuchElementException;

public class SchlangeMitArray<T> implements Schlange<T> {

    private T[] data;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public SchlangeMitArray(int maxGroesse) {
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
        T removedElement = data[0];
        for (int i = 0; i < size() - 1; i++) {
            data[i] = data[i + 1];
        }
        currentSize--;
        return removedElement;
    }

    @Override
    public T front() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return data[0];
    }
}

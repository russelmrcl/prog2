package b00a2;

import java.util.NoSuchElementException;

public class SchlangeMitArray implements Schlange {

    private Integer[] data;
    private int currentSize;

    public SchlangeMitArray(int maxGroesse) {
        data = new Integer[maxGroesse];
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
    public void insert(Integer i) throws IllegalStateException {
        if (size() == capacity()) {
            throw new IllegalStateException();
        }
        data[++currentSize] = i;
    }

    @Override
    public int remove() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int removedElement = data[0];
        for (int i = 0; i < size() - 1; i++) {
            data[i] = data[i + 1];
        }
        currentSize--;
        return removedElement;
    }

    @Override
    public int front() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return data[0];
    }
}

package b00a2;

import java.util.NoSuchElementException;

public class StapelMitArray implements Stapel {

    private int[] data;
    private int currentSize;

    public StapelMitArray(int maxGroesse) {
        data = new int[maxGroesse];
        currentSize = -1;
    }


    @Override
    public boolean isEmpty() {
        return currentSize == -1;
    }

    @Override
    public int size() {
        return currentSize +1;
    }

    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public void insert(Integer i) throws IllegalStateException {
        if (size() == capacity()) {
            throw new IllegalStateException();
        } else {
            data[++currentSize] = i;
        }
    }

    @Override
    public int remove() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return data[currentSize--];
        }
    }

    @Override
    public int top() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return data[currentSize];
        }
    }
}

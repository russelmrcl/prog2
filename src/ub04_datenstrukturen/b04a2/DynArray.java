package b04a2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class DynArray<T> {

    private T[] data;
    private int size = 0;
    private int capacity = 1;

    @SuppressWarnings("unchecked")
    public DynArray() {
        data = (T[]) new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public T get(int pos) {

        if (pos < 0 || pos > capacity() - 1 || pos > size()) {
            throw new IllegalStateException();
        }
        return data[pos];
    }

    public T set(int pos, T e) {

        if (pos < 0 || pos > capacity() - 1 || pos > size()) {
            throw new IllegalStateException();
        }
        T replacedElement = data[pos];
        data[pos] = e;
        return replacedElement;
    }

    public void addFirst(T e) {

        if (size() == capacity()) {
            grow();
        }

        for (int i = 0; i < size; i++) {
            data[i + 1] = data[i];
        }
        data[0] = e;
        size++;
    }

    public void addLast(T e) {

        if (size() == capacity()) {
            grow();
        }
        data[size++] = e;
    }

    public T removeFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T removedElement = data[0];
        data[0] = null;
        for (int i = 0; i < size; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        if (size() * 4 == capacity()) {
            shrink();
        }
        return removedElement;
    }

    public T removeLast() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T removedElement = data[size() - 1];
        data[size() - 1] = null;
        size--;
        if (size() * 4 == capacity()) {
            shrink();
        }
        return removedElement;
    }


    private void grow() {

        capacity *= 2;
        @SuppressWarnings("unchecked")
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void shrink() {

        capacity /= 2;
        @SuppressWarnings("unchecked")
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        return "DynArray{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}



package b05a3;

import b04a3.Ringpuffer;
import b05a2.Folge;

import java.util.NoSuchElementException;

public class FolgeMitRing<T> implements Folge<T> {

    private Ringpuffer<T> ringpuffer;
    private boolean removePosUsed = false;

    public FolgeMitRing(int capacity) {
        ringpuffer = new Ringpuffer<>(capacity);
    }


    @Override
    public boolean isEmpty() {
        return ringpuffer.isEmpty();
    }

    @Override
    public int size() {
        return ringpuffer.size();
    }

    @Override
    public int capacity() {
        return ringpuffer.capacity();
    }

    @Override
    public void insert(T i) throws IllegalStateException {
        int currentPointer = ringpuffer.getPointer();
        if (removePosUsed) {
            ringpuffer.setPointer(0);
        }
        ringpuffer.addLast(i);
        ringpuffer.setPointer(currentPointer);
    }

    @Override
    public T remove() throws NoSuchElementException {
        removePosUsed = false;
        return ringpuffer.removeFirst();
    }

    @Override
    public T get(int pos) {
        return ringpuffer.get(pos);
    }

    @Override
    public T set(int pos, T e) {
        return ringpuffer.set(pos, e);
    }

    @Override
    public T remove(int pos) {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (pos < 0 || pos > capacity() - 1 || pos > size() - 1) {
            throw new IllegalStateException();
        }

        T removedElement = ringpuffer.get(pos);
        for (int i = pos; i < size() - 1; i++) {
            ringpuffer.set(i, get(i + 1));
        }
        removePosUsed = true;
        ringpuffer.removeLast();
        return removedElement;
    }

    @Override
    public void insert(int pos, T e) {

        if (pos < 0 || pos > size()) {
            throw new IllegalStateException();
        }
        int currentPointer = ringpuffer.getPointer();
        if (removePosUsed) {
            ringpuffer.setPointer(0);
        }
        if (currentPointer == capacity() - 1) {
            ringpuffer.addLast(get(pos));
            ringpuffer.set(pos - 1, get(pos - 1));
            ringpuffer.setPointer(0);
        } else {
            ringpuffer.addLast(get(0));
        }
        if (ringpuffer.get(pos) != null && currentPointer + 1 != size() || removePosUsed) {
            int index = (ringpuffer.getPointer() == 0) ? size() - 2 : (currentPointer != capacity() - 1) ? size() - 1 : size();
            for (int i = index; i >= pos; i--) {
                ringpuffer.set((i + 1) % capacity(), get(i % capacity()));
            }
        }
        ringpuffer.set(pos, e);
        ringpuffer.setPointer(currentPointer);
    }


    @Override
    public String toString() {
        return ringpuffer.toString();
    }
}

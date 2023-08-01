package b03a5;

import java.util.NoSuchElementException;

public class RDVL<T> {

    private ListElement entry;
    private int size = 0;

    private class ListElement {

        T data;
        ListElement next;
        ListElement prev;

        ListElement(T data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return this.size;
    }

    public void add(T e) {

        if (null == e) {
            throw new IllegalStateException();
        }
        ListElement newElement = new ListElement(e);
        if (isEmpty()) {
            entry = newElement;
            entry.prev = entry;
            entry.next = entry;
        } else {
            ListElement tmp = entry.prev;
            entry.prev = newElement;
            tmp.next = newElement;
            newElement.next = entry;
            newElement.prev = tmp;
        }
        size++;
    }

    public T remove() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T removedElement;
        if (size() == 1) {
            removedElement = entry.data;
            entry = null;
        } else {
            ListElement tmp = entry.prev;
            removedElement = entry.data;
            entry = entry.next;
            tmp.next = entry;
            entry.prev = tmp;
        }
        size--;
        return removedElement;
    }

    public T element() {
        return entry.data;
    }

    public void next(int s) {
        while (s > 0) {
            entry = entry.next;
            s--;
        }
    }

    public void prev(int s) {
        while (s > 0) {
            entry = entry.prev;
            s--;
        }
    }
}

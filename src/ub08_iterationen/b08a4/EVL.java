package b08a4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EVL<T> implements Iterable<T> {

    private ListElement first = null;
    private int size = 0;

    private class ListElement {

        T data;
        ListElement next = null;

        ListElement(T data) {
            this.data = data;
        }
    }

    public T getFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.data;

    }

    public T getLast() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ListElement tmp = first;
        while (null != tmp.next) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public void addFirst(T e) {

        if (null == e) {
            throw new IllegalStateException();
        }
        ListElement element = new ListElement(e);
        if (!isEmpty()) {
            element.next = first;
        }
        first = element;
    }

    public void addLast(T e) {

        if (null == e) {
            throw new IllegalStateException();
        }
        ListElement element = new ListElement(e);
        if (isEmpty()) {
            first = element;
        } else {
            ListElement tmp = first;
            while (null != tmp.next) {
                tmp = tmp.next;
            }
            tmp.next = element;
        }
        size++;
    }

    public T removeFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T removedElement;
        if (1 == size) {
            removedElement = first.data;
            first = null;
        } else {
            removedElement = getFirst();
            first = first.next;
        }
        size--;
        return removedElement;
    }

    public T removeLast() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T removedElement;
        if (1 == size) {
            removedElement = first.data;
            first = null;
        } else {
            ListElement tmp = first;
            while (null != tmp.next.next) {
                tmp = tmp.next;
            }
            removedElement = tmp.next.data;
            tmp.next = null;
        }
        size--;
        return removedElement;
    }

    public boolean contains(T e) {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ListElement tmp = first;
        while (null != tmp) {
            if (tmp.data.equals(e)) {
                return true;
            } else {
                tmp = tmp.next;
            }
        }
        return false;
    }

    public void zip(EVL<T> other) {

        if (isEmpty()) {
            first = other.first;
            size = other.size;
            other.first = null;
            other.size = 0;
        }
        ListElement current = first;
        while (!other.isEmpty()) {
            if (current.next == null) {
                current.next = other.first;
                size += other.size;
                other.first = null;
                other.size = 0;
            } else {
                ListElement tmp = current.next;
                current.next = other.first;
                size++;
                other.size--;
                other.first = other.first.next;
                current.next.next = tmp;
                current = tmp;
            }
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new EVLIterator();
    }

    private class EVLIterator implements Iterator<T> {

        ListElement current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T value = current.data;
            current = current.next;
            return value;
        }
    }

    @Override
    public String toString() {
        return toString(first);
    }

    private String toString(ListElement current) {

        if (isEmpty()) {
            return "Empty!";
        } else if (null == current.next) {
            return current.data.toString();
        } else {
            return current.data + "-> " + toString(current.next);
        }
    }
}

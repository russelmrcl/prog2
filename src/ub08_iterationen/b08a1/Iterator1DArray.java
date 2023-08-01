package b08a1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterator1DArray<T> implements Iterator<T> {

    private int currentIndex;
    private T[] data;
    /*end ist exklusiv, dh. end wird nicht als index betrachtet beispiel end = 1, es wird
    nur das 0 element ausgegeben & nicht das 1 element.*/
    private int endIndex;

    public Iterator1DArray(T[] data) {
        this(data, 0, data.length);
    }

    public Iterator1DArray(T[] data, int start) {
        this(data, start, data.length);
    }

    public Iterator1DArray(T[] data, int start, int end) {
        this.currentIndex = start;
        this.data = data;
        this.endIndex = end;
        if (this.endIndex > data.length || this.endIndex <= this.currentIndex) {
            this.endIndex = data.length;
        }
    }

    @Override
    public boolean hasNext() {
        return this.currentIndex < this.endIndex;
    }

    @Override
    public T next() {

        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[currentIndex++];
    }

}

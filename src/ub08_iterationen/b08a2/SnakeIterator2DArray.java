package b08a2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SnakeIterator2DArray<T> implements Iterator<T> {
    private T[][] data;
    private int numRows;
    private int numCols;
    private int rowIndex = 0;
    private int colIndex = 0;
    private boolean movingForward = true;

    public SnakeIterator2DArray(T[][] data) {
        this.data = data;
        this.numRows = SnakeIterator2DArray.this.data.length;
        this.numCols = SnakeIterator2DArray.this.data[0].length;
    }

    @Override
    public boolean hasNext() {
        return rowIndex < numRows && colIndex < numCols;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        T value = data[rowIndex][colIndex];

        if (movingForward) {
            if (colIndex < numCols - 1) {
                colIndex++;
            } else {
                rowIndex++;
                movingForward = false;
            }
        } else {
            if (colIndex > 0) {
                colIndex--;
            } else {
                rowIndex++;
                movingForward = true;
            }
        }
        return value;
    }

}

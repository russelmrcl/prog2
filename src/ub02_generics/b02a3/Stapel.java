package b02a3;

import java.util.NoSuchElementException;

public interface Stapel<T> extends Puffer<T> {

    T top() throws NoSuchElementException;

}

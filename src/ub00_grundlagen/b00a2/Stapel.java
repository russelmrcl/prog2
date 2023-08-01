package b00a2;

import java.util.NoSuchElementException;

public interface Stapel extends Puffer {

    int top() throws NoSuchElementException;

}

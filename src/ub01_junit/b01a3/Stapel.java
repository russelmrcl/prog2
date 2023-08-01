package b01a3;

import java.util.NoSuchElementException;

public interface Stapel extends Puffer {

    int top() throws NoSuchElementException;

}

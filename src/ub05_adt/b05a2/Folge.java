package b05a2;

import b02a3.Puffer;

public interface Folge<T> extends Puffer<T> {

    T get(int pos);

    T set(int pos, T e);

    T remove(int pos);

    void insert(int pos, T e);

}

package b07a3;

import b07a2.Boxer;

import java.util.Comparator;

public class ComparatorBoxerGewicht implements Comparator<Boxer> {

    @Override
    public int compare(Boxer o1, Boxer o2) {
        return Integer.compare(o1.getKg(), o2.getKg());
    }
}

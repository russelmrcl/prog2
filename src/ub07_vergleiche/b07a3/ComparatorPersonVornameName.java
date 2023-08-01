package b07a3;

import b07a2.Person;

import java.util.Comparator;

public class ComparatorPersonVornameName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {

        int vornameVergleich = o1.getVorname().compareTo(o2.getVorname());
        int nameVergleich = o1.getName().compareTo(o2.getName());

        return (vornameVergleich != 0) ? vornameVergleich : nameVergleich;

    }
}

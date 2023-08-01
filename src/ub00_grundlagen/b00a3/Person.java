package b00a3;

public abstract class Person {

    private String name;
    private String vorname;

    public Person(String name, String vorname) {
        this.name = name;
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    @Override
    public boolean equals(Object other) {

        if (!(other instanceof Person)) {
            return false;
        }
        Person otherPerson = (Person) other;
        return this.getName().equals(otherPerson.getName()) && this.getVorname().equals(otherPerson.getVorname());
    }

    @Override
    public String toString() {
        return this.getName() + ", " + this.getVorname();
    }
}

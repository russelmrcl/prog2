package b07a2;

public class Boxer extends Person implements Comparable<Boxer>{

    private int kg;

    public Boxer(String name, String vorname, int kg) {
        super(name, vorname);
        this.kg = kg;
    }

    public int getKg() {
        return kg;
    }

    @Override
    public boolean equals(Object other) {

        if (!(other instanceof Boxer)) {
            return false;
        }
        Boxer otherBoxer = (Boxer) other;
        return super.equals(otherBoxer) && this.getKg() == otherBoxer.getKg();
    }

    @Override
    public String toString() {
        return super.toString() + ", " + getKg();
    }

    @Override
    public int compareTo(Boxer o) {

        int gewichtVergleich = Integer.compare(this.getKg(), o.getKg());
        int nameVergleich = this.getName().compareTo(o.getName());
        int vornameVergleich = this.getVorname().compareTo(o.getVorname());

        return (gewichtVergleich != 0) ? gewichtVergleich :
                (nameVergleich != 0) ?
                nameVergleich : vornameVergleich;
    }
}

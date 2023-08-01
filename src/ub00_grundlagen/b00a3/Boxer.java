package b00a3;

public class Boxer extends Person {

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

}

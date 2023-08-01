package b02a6;

public class Paar<E, Z> {

    private E erstes;
    private Z zweites;

    public Paar(E erstes, Z zweites) {
        this.erstes = erstes;
        this.zweites = zweites;
    }

    public E getErstes() {
        return erstes;
    }

    public Z getZweites() {
        return zweites;
    }

    public E setErstes(E e) {
        E alt = erstes;
        this.erstes = e;
        return alt;
    }

    public Z setZweites(Z z) {
        Z alt = zweites;
        this.zweites = z;
        return alt;
    }

    public void setBeides(E e, Z z) {
        this.erstes = e;
        this.zweites = z;
    }

    public boolean equals(Paar<E, Z> p) {
        return this.getErstes().equals(p.getErstes()) && this.getZweites().equals(p.getZweites());
    }

    public String toString() {
        return "("+ getErstes() + "," + getZweites() + ")";
    }
}

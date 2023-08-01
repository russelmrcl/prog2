package b07a2;

public class Student extends Person implements Comparable<Student> {

    private int matrikelnummer;

    public Student(String name, String vorname, int matrikelnummer) {
        super(name, vorname);
        this.matrikelnummer = matrikelnummer;
    }

    public int getMatrikelnummer() {
        return matrikelnummer;
    }

    @Override
    public boolean equals(Object other) {

        if (!(other instanceof Student)) {
            return false;
        }
        Student otherStudent = (Student) other;
        return super.equals(otherStudent) && this.matrikelnummer == otherStudent.matrikelnummer;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + getMatrikelnummer();
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.getMatrikelnummer(), o.getMatrikelnummer());
    }
}

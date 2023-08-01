package b02a8;

import b00a3.Boxer;
import b00a3.Student;
import b02a3.Puffer;
import b02a3.SchlangeMitArray;
import b02a3.StapelMitArray;
import b02a6.Paar;

public class PufferPaar {
    public static void main(String[] args) {

        Puffer<Paar<Student, String>> servicePoint;
        Puffer<Paar<Boxer, Boxer>> boxEvent;

        servicePoint = new SchlangeMitArray<>(4);
        boxEvent = new StapelMitArray<>(3);

        Student s1 = new Student("Marcelo", "Russel", 9047365);
        String sq1 = "When does the programming 2 lecture start?";
        Student s2 = new Student("Musk", "Elon", 9047364);
        String sq2 = "Where does the programming 2 lecture take place?";
        Student s3 = new Student("Cook", "Tim", 9047363);
        String sq3 = "Where is the library?";
        Student s4 = new Student("Gates", "Nill", 9047362);
        String sq4 = "Where is the cafeteria?";

        Boxer b1 = new Boxer("Pacquiao", "Manny", 72);
        Boxer b2 = new Boxer("Marcelo", "Russel", 73);
        Boxer b3 = new Boxer("Davis", "Gervonta", 75);
        Boxer b4 = new Boxer("Garcia", "Ryan", 75);
        Boxer b5 = new Boxer("Tyson", "Mike", 105);
        Boxer b6 = new Boxer("Mohamed", "Ali", 84);

        Paar<Student, String> s1sq1 = new Paar(s1, sq1);
        servicePoint.insert(s1sq1);
        Paar<Student, String> s2sq2 = new Paar(s2, sq2);
        servicePoint.insert(s2sq2);
        Paar<Student, String> s3sq3 = new Paar(s3, sq3);
        servicePoint.insert(s3sq3);
        Paar<Student, String> s4sq4 = new Paar(s4, sq4);
        servicePoint.insert(s4sq4);

        Paar<Boxer, Boxer> b1b2 = new Paar<>(b1, b2);
        boxEvent.insert(b1b2);
        Paar<Boxer, Boxer> b3b4 = new Paar<>(b3, b4);
        boxEvent.insert(b3b4);
        Paar<Boxer, Boxer> b5b6 = new Paar<>(b5, b6);
        boxEvent.insert(b5b6);


        System.out.println("Service Point:");
        while (!servicePoint.isEmpty()) {
            Paar<Student, String> paar = servicePoint.remove();
            System.out.println(paar.getErstes() + " : " + paar.getZweites());
        }

        System.out.println("Box Event:");
        while (!boxEvent.isEmpty()) {
            Paar<Boxer, Boxer> paar = boxEvent.remove();
            System.out.println(paar.getErstes() + " vs. " + paar.getZweites());
        }
    }
}

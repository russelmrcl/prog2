package b03a3;

import b02a3.SchlangeMitArray;
import b03a2.SchlangeMitEVL;

public class TimeTestSchlange {
    public static void main(String[] args) {

        SchlangeMitArray<Integer> sArray = new SchlangeMitArray<>(100000);
        SchlangeMitEVL<Integer> sEVL = new SchlangeMitEVL<>();

        long start, finish, elapsed;

        start = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) {
            sArray.insert(i);
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Array braucht zum fuellen: " + elapsed + "ms");

        start = System.currentTimeMillis();
        while (!sArray.isEmpty()) {
            sArray.remove();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Array braucht zum leeren: " + elapsed + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sEVL.insert(i);
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("EVL braucht zum fuellen: " + elapsed + "ms");

        start = System.currentTimeMillis();
        while (!sEVL.isEmpty()) {
            sEVL.remove();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("EVL braucht zum leeren: " + elapsed + "ms");
    }
}

package b03a6;

import b03a5.RDVL;

public class Josephus {

    public static int loese(int n, int k) {
        RDVL<Integer> circle = new RDVL<>();

        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        while (circle.size() > 1) {
            circle.next(k-1);
            circle.remove();
        }

        return circle.element();
    }

    public static void main(String[] args) {

        System.out.println(Josephus.loese(5, 2));
    }
}

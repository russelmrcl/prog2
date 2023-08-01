package b04a4;

import b04a3.Ringpuffer;

import java.util.NoSuchElementException;

public class Temperatursensor {

    public static void main(String[] args) {

        Temperatursensor a = new Temperatursensor();
        a.neueMessung(26.5f);
        a.neueMessung(23.8f);
        a.neueMessung(28.2f);
        a.neueMessung(24.6f);
        a.neueMessung(22.1f);
        a.neueMessung(27.9f);
        a.neueMessung(25.4f);
        a.neueMessung(23.7f);
        a.neueMessung(26.8f);
        a.neueMessung(24.2f);
        a.neueMessung(21.5f);
        a.neueMessung(27.3f);
        a.neueMessung(25.6f);
        a.neueMessung(23.9f);
        a.neueMessung(26.1f);
        a.neueMessung(24.8f);
        a.neueMessung(22.3f);
        a.neueMessung(27.5f);
        a.neueMessung(25.2f);
        a.neueMessung(23.4f);
        a.neueMessung(26.7f);
        a.neueMessung(24.3f);
        a.neueMessung(21.8f);
        a.neueMessung(27.1f);
    }

    Ringpuffer<Float> senor = new Ringpuffer<>(24);

    public void neueMessung(Float wert) {
        try {
            senor.addLast(wert);
        } catch (IllegalStateException illegalStateException) {
            senor.removeFirst();
            senor.addLast(wert);
        }
    }

    public float aktuelleTemperatur() {
        try {
            return senor.get(senor.size()-1);
        } catch (IllegalStateException illegalStateException) {
            return Float.NaN;
        }
    }

    public float durchschnittsTemperatur() {
        if (senor.isEmpty()) {
            return Float.NaN;
        }
        float result = 0;
        for (int i = 0; i <= senor.size()-1; i++) {
            result = result + senor.get(i);
        }
        return result / senor.size();
    }

    public void reset() {
        senor.reset();
    }
}

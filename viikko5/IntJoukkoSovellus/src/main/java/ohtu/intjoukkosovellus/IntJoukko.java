package ohtu.intjoukkosovellus;

import java.util.*;

public class IntJoukko {

    private int kasvatuskoko;
    private Set<Integer> joukko;

    public IntJoukko() {
        this(Constants.KAPASITEETTI, Constants.OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, Constants.OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti väärin");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti väärin");
        }
        this.initVars(kapasiteetti, kasvatuskoko);
    }

    private void initVars(int kapasiteetti, int kasvatuskoko) {

        this.joukko = new TreeSet<Integer>(Collections.reverseOrder());
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        this.joukko.add(luku);
        return kuuluu(luku);
    }

    public boolean kuuluu(int luku) {
        return this.joukko.contains(luku);
    }

    public boolean poista(int luku) {
        this.joukko.remove(luku);
        return kuuluu(luku);
    }

    public int mahtavuus() {
        return this.joukko.size();
    }

    @Override
    public String toString() {
        if (this.joukko.size() == 0) {
            return "{}";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            int left = joukko.size();
            for (Integer i : joukko) {
                sb.append(Integer.toString(i));
                if (left > 1) {
                    sb.append(", ");
                }
                left--;
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private static List<Integer> joukkoListaksi(IntJoukko a) {
        return Arrays.asList(Arrays.stream(a.toIntArray()).boxed().toArray(Integer[]::new));
    }

    public int[] toIntArray() {
        return this.joukko.stream().mapToInt(Number::intValue).toArray();
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        Set<Integer> x = new HashSet<>();
        x.addAll(joukkoListaksi(a));
        x.addAll(joukkoListaksi(b));
        return lisaaJoukkoIntJoukkoon(x);
    }

    private static IntJoukko lisaaJoukkoIntJoukkoon(Set<Integer> joukko) {
        IntJoukko y = new IntJoukko();
        for (Integer i : joukko) {
            y.lisaa(i);
        }
        return y;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        Set<Integer> x = new HashSet<>();
        x.addAll(joukkoListaksi(a));
        x.retainAll(joukkoListaksi(b));
        return lisaaJoukkoIntJoukkoon(x);
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        Set<Integer> x = new HashSet<>();
        x.addAll(joukkoListaksi(a));
        x.removeAll((joukkoListaksi(b)));
        return lisaaJoukkoIntJoukkoon(x);
    }

}

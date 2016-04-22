package ohtu.intjoukkosovellus;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntJoukko implements Iterable<Integer> {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti pitaa olla positiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatukoko pitaa olla positiivinen");
        }
        this.ljono = new int[kapasiteetti];
        this.alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public IntJoukko(IntJoukko toinen) {
        this.kasvatuskoko = toinen.kasvatuskoko;
        this.alkioidenLkm = toinen.alkioidenLkm;
        this.ljono = toinen.ljono.clone();
    }

    public boolean lisaa(int luku) {
        if(kuuluu(luku)) return false;

        ljono[alkioidenLkm] = luku;
        alkioidenLkm++;

        if (alkioidenLkm == ljono.length) {
            int[] taulukkoOld = ljono;
            ljono = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(taulukkoOld, ljono);
        }
        return true;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i])
                return true;
        }
        return false;
    }

    private void poistaIndeksi(int indeksi) {
        for (int j = indeksi; j < alkioidenLkm - 1; j++) {
            ljono[j] = ljono[j + 1];
        }
        alkioidenLkm--;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                poistaIndeksi(i);
                return true;
            }
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        int len = Math.min(vanha.length, uusi.length);
        System.arraycopy(vanha, 0, uusi, 0, len);
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String tuotos = "";
        for (int i = 0; i < alkioidenLkm; i++) {
            if(i > 0) tuotos += ", ";
            tuotos += ljono[i];
        }
        return "{" + tuotos + "}";
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        kopioiTaulukko(ljono, taulu);
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko uusi = new IntJoukko(a);
        for (int arvo : b) {
            uusi.lisaa(arvo);
        }
        return uusi;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko uusi = new IntJoukko(a);
        for (int arvo : b) {
            if(uusi.kuuluu(arvo)) {
                uusi.poista(arvo);
            } else {
                uusi.lisaa(arvo);
            }
        }
        return uusi;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko uusi = new IntJoukko(a);
        for (int arvo : b) {
            uusi.poista(arvo);
        }
        return uusi;
    }
    
    private class IntIteraatori implements Iterator<Integer> {
        private int i;

        public IntIteraatori() {
            i = 0;
        }

        @Override
        public boolean hasNext() {
            return i < alkioidenLkm;
        }

        @Override
        public Integer next() {
            if(!hasNext())
                throw new NoSuchElementException();
            return ljono[i++];
        }

        @Override
        public void remove() { }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntIteraatori();
    }
}
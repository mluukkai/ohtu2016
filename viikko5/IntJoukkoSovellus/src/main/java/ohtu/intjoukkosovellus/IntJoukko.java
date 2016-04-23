package ohtu.intjoukkosovellus;



public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukkoTaulu;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        joukkoTaulu = new int[KAPASITEETTI];
        for (int i = 0; i < joukkoTaulu.length; i++) {
            joukkoTaulu[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        joukkoTaulu = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetin kasvatuskoko väärin");//heitin vaan jotain :D
        }
        joukkoTaulu = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            joukkoTaulu[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == joukkoTaulu.length) {
                int[] uusiTaulu = new int[joukkoTaulu.length + kasvatuskoko];
                kopioiTaulukko(joukkoTaulu, uusiTaulu);
                joukkoTaulu = uusiTaulu;
            }
            return true;
        }
        return false;
    }
    
    public int hae(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukkoTaulu[i]) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean kuuluu(int luku) {
        return (hae(luku) != -1);
    }

    public boolean poista(int luku) {
        int poistoKohta = hae(luku);
        if (poistoKohta != -1) {
            for (int j = poistoKohta; j < alkioidenLkm - 1; j++) {
                joukkoTaulu[j] = joukkoTaulu[j + 1];
            }
            alkioidenLkm--;
            return true;
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String palautus = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            palautus += joukkoTaulu[i];
            palautus += ", ";
        }
        if (alkioidenLkm > 0) {
            palautus += joukkoTaulu[alkioidenLkm - 1];
        }
        palautus += "}";
        return palautus;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukkoTaulu[i];
        }
        return taulu;
    }
    
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(i);
        }

        return z;
    }

}

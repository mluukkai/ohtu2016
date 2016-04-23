package ohtu.intjoukkosovellus;

public class IntJoukko {
    // Aloitustaulukon koko
    public final static int KAPASITEETTI = 5;
    // Taulukon kasvatuskerroin
    public final static int OLETUSKASVATUS = 5;
    
    // Uusi taulukko on tämän verran vanhaa suurempi.
    private int kasvatuskoko;
    
    // Joukon luvut säilytetään taulukon alkupäässä.
    private int[] luvut;
    
    // Tyhjässä joukossa alkioiden_määrä on nolla. 
    private int alkioidenLkm;

    public IntJoukko() {
        this(KAPASITEETTI);
    }
    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti ei voi olla negatiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko ei voi olla negatiivinen");
        }
        
        luvut = new int[kapasiteetti];
        for (int i = 0; i < luvut.length; i++) {
            luvut[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == 0) {
            luvut[0] = luku;
            alkioidenLkm++;
            return true;
        }
        
        if (!kuuluu(luku)) {
            luvut[alkioidenLkm] = luku;
            alkioidenLkm++;
            
            if (alkioidenLkm % luvut.length == 0) {
                int[] vanhatLuvut = luvut;
                luvut = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(vanhatLuvut, luvut);
            }
            
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        int montaLoytyi = 0;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                montaLoytyi++;
            }
        }
        
        return montaLoytyi > 0;
    }

    public boolean poista(int luku) {
        int luvunIndex = -1;
        
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                luvunIndex = i;
                luvut[luvunIndex] = 0;
                break;
            }
        }
        
        int apu;
        if (luvunIndex != -1) {
            for (int j = luvunIndex; j < alkioidenLkm - 1; j++) {
                apu = luvut[j];
                luvut[j] = luvut[j + 1];
                luvut[j + 1] = apu;
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

    public int alkioidenMaara() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        }
        
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += luvut[i];
            tuotos += ", ";
        }
        tuotos += luvut[alkioidenLkm - 1];
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = luvut[i];
        }
        
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdistetty = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        
        for (int i = 0; i < aTaulu.length; i++) {
            yhdistetty.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            yhdistetty.lisaa(bTaulu[i]);
        }
        
        return yhdistetty;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikattu = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    leikattu.lisaa(bTaulu[j]);
                }
            }
        }
        
        return leikattu;
    }
    
    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        
        for (int i = 0; i < aTaulu.length; i++) {
            erotus.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            erotus.poista(i);
        }
 
        return erotus;
    }
        
}
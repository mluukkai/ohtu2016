package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        ljono = new int[KAPASITEETTI];
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) return;
        ljono = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) throw new IndexOutOfBoundsException("Kapasitteetti tai kasvatuskoko ei voi olla negatiivinen");
        ljono = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == ljono.length) ljono = Arrays.copyOf(ljono, ljono.length + kasvatuskoko); 
        if (!kuuluu(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < ljono.length; i++) {
            if (ljono[i] == luku) return true;
        }
        return false;
    }

    public boolean poista(int luku) {
        if (!kuuluu(luku)) return false;
        int poistokohta = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) poistokohta = i;
            if (i >= poistokohta && poistokohta != -1 && i != alkioidenLkm - 1) ljono[i] = ljono[i+1];
            if (i >= poistokohta && i == alkioidenLkm - 1) ljono[i] = 0;
        }
        alkioidenLkm--;
        return true;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String tuloste = "{";
        for (int i = 0; i < alkioidenLkm; i++) {
            tuloste += ljono[i];
            if (i != alkioidenLkm -1) tuloste += ", ";
        }
        return tuloste + "}";
    }

    public int[] toIntArray() {
        return Arrays.copyOfRange(ljono, 0, alkioidenLkm);
    }
   

    public static IntJoukko yhdiste(IntJoukko aJoukko, IntJoukko bJoukko) {
        int[] bTaulu = bJoukko.toIntArray();
        for (int i = 0; i < bTaulu.length; i++) {
            aJoukko.lisaa(bTaulu[i]);
        }
        return aJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko aJoukko, IntJoukko bJoukko) {
        int[] aTaulu = aJoukko.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            if (!bJoukko.kuuluu(aTaulu[i])) aJoukko.poista(aTaulu[i]);
        }
        return aJoukko;
    }
    
    public static IntJoukko erotus ( IntJoukko aJoukko, IntJoukko bJoukko) {
        int[] bTaulu = bJoukko.toIntArray();
        for (int i = 0; i < bTaulu.length; i++) {
            if (aJoukko.kuuluu(bTaulu[i])) aJoukko.poista(bTaulu[i]);
        }
        return aJoukko;
    }     
}
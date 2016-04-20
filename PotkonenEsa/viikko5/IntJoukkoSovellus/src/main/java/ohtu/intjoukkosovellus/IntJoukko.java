
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        init(KAPASITEETTI,OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        init(kapasiteetti,OLETUSKASVATUS);
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        init(kapasiteetti,kasvatuskoko);
    }

    private void init(int koko, int kasva) {
        if (koko < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        lukujono = new int[koko];
        for (int i = 0; i < lukujono.length; i++) {
            lukujono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasva;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            lukujono[alkioidenLkm] = luku;
            alkioidenLkm++;
            tarkistaKoko();
            return true;
        }
        return false;
    }

    private void tarkistaKoko() {
        if (alkioidenLkm == lukujono.length) {
            int[] taulukkoOld = new int[lukujono.length];
            taulukkoOld = lukujono;
            kopioiTaulukko(lukujono, taulukkoOld);
            lukujono = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(taulukkoOld, lukujono);
        }
    }

    public boolean kuuluu(int luku) {
        int on =  etsiJaKorvaa(luku, luku);

        if (on >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean poista(int luku) {
        int kohta = etsiJaKorvaa(luku, 0);
        int apu;
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenLkm - 1; j++) {
                apu = lukujono[j];
                lukujono[j] = lukujono[j + 1];
                lukujono[j + 1] = apu;
            }
            alkioidenLkm--;

            return true;
        }

        return false;
    }

    private int etsiJaKorvaa(int luku, int arvo) {
        int kohta = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                lukujono[kohta] = arvo;
                break;
            }
        }
        return kohta;
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
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm ; i++) {
                tuotos += lukujono[i];
                tuotos += (i == alkioidenLkm - 1 ? "" :", ");
            }
            tuotos += "}";
            return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujono[i];
        }
        return taulu;
    }
   
    public void lisaa(int [] taulu) {
        for (int i = 0; i < taulu.length; i++) {
            lisaa(taulu[i]);
        }
    }
    public void poista(int [] taulu) {
        for (int i = 0; i < taulu.length; i++) {
            poista(taulu[i]);
        }
    }
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        x.lisaa(a.toIntArray());
        x.lisaa(b.toIntArray());
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
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        z.lisaa(a.toIntArray());
        z.poista(b.toIntArray());
 
        return z;
    }
        
}
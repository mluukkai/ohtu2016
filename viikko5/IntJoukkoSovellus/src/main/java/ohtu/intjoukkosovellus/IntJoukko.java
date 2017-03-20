
package ohtu.intjoukkosovellus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI);
    }

    public IntJoukko(int kapasiteetti) {        
        this(kapasiteetti, OLETUSKASVATUS);
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetin tulee olla suurempi kuin 0");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoon tulee olla suurempi kuin 0");//heitin vaan jotain :D
        }
        
        this.ljono = new int[kapasiteetti];
        this.alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) return false;
        
        ljono[alkioidenLkm] = luku;
        alkioidenLkm++;
        
        if (alkioidenLkm == ljono.length) {
            int[] temp = ljono;
            ljono = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(temp, ljono);
        }
        
        return true;
    }

    public boolean kuuluu(int luku) {
        return IntStream.of(ljono).anyMatch(x -> x == luku);
    }

    public boolean poista(int luku) {
        if (!kuuluu(luku)) return false;
        
        int kohta = etsiIndeksi(luku);
        int temp;
        
        ljono[kohta] = 0;
        
        for (int i = kohta; i < alkioidenLkm - 1; i++) {
            temp = ljono[i];
            ljono[i] = ljono[i + 1];
            ljono[i+1] = temp;
        }
        
        alkioidenLkm--;
        return true;
    }
    
    private int etsiIndeksi(int luku) {
        for(int i = 0; i < alkioidenLkm; i++) {
            if (ljono[i] == luku) return i;
        }
        
        return -1;
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
        for (int i = 0; i < alkioidenLkm; i++) {
            tuotos += ljono[i];
            if (i < alkioidenLkm - 1) tuotos += ", ";
        }
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }
   
    public static void lisaaKaikki(IntJoukko kohde, IntJoukko lahde) {
        int[] lahdeArr = lahde.toIntArray();
        
        for (int i = 0; i < lahdeArr.length; i++) {
            kohde.lisaa(lahdeArr[i]);
        }
    }
    
    public static void poistaKaikki(IntJoukko kohde, IntJoukko lahde) {
        int[] lahdeArr = lahde.toIntArray();

        for (int i = 0; i < lahdeArr.length; i++) {
            kohde.poista(i);
        }
    }
    
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        
        lisaaKaikki(x, a);
        lisaaKaikki(x, b);
        
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        
        int[] aTaulu = a.toIntArray();
        
        for(int i = 0; i < aTaulu.length; i++) {
            if (b.kuuluu(aTaulu[i])) {
                y.lisaa(aTaulu[i]);
            }
        }
        
        return y;
    }
    
    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        
        lisaaKaikki(z, a);
        poistaKaikki(z, b);
 
        return z;
    }
        
}
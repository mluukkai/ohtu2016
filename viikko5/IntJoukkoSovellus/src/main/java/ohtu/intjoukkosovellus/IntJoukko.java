
package ohtu.intjoukkosovellus;

public class IntJoukko {

     public enum Operaatio {

        YHDISTE, LEIKKAUS, EROTUS
    }
    
    public final static int ALOITUSTAULUKONKOKO = 5, // aloitustalukon koko
                            OLETUSKASVUFAKTORI = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int taulukonKasvuFaktori;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] kokonaislukujenJoukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int[] varaTaulukko;
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        kokonaislukujenJoukko = new int[ALOITUSTAULUKONKOKO];
        for (int i = 0; i < kokonaislukujenJoukko.length; i++) {
            kokonaislukujenJoukko[i] = 0;
        }
        alkioidenLkm = 0;
        this.taulukonKasvuFaktori = OLETUSKASVUFAKTORI;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            kapasiteetti=ALOITUSTAULUKONKOKO;
        }
        kokonaislukujenJoukko = new int[kapasiteetti];
        this.taulukonKasvuFaktori = OLETUSKASVUFAKTORI;

    }
    
    
    public IntJoukko(int kapasiteetti, int taulukonKasvuFaktori) {
        if (kapasiteetti<5) {kapasiteetti=5;}
        if (taulukonKasvuFaktori<5) {taulukonKasvuFaktori=5;}
  
        kokonaislukujenJoukko = new int[kapasiteetti];
        this.taulukonKasvuFaktori = taulukonKasvuFaktori;
    }
    
    public void lisaa(int[] taulu) {
        for (int i = 0; i<taulu.length; i++) {
            lisaa(taulu[i]);
        }
    }

    public boolean lisaa(int luku) {
        if (!sisaltyykoJoukkoon(luku)) {
            if (alkioidenLkm % kokonaislukujenJoukko.length == 0) {
                kasva();
            }
            kokonaislukujenJoukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            return true;
        }
        return false;
    }

    public boolean sisaltyykoJoukkoon(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == kokonaislukujenJoukko[i]) {
                return true;
            }
        }
        return false;
        
    }

    public boolean poista(int luku) {
        for (int i = 0; i<kokonaislukujenJoukko.length; i++) {
            if (kokonaislukujenJoukko[i]==luku) {
                alkioidenLkm--;
                kokonaislukujenJoukko[i]=kokonaislukujenJoukko[alkioidenLkm];
                kokonaislukujenJoukko[alkioidenLkm]=0;
                return true;
            }
        }
       return false;
    }

    private void kasva() {
        varaTaulukko = kokonaislukujenJoukko;
        kokonaislukujenJoukko = new int[alkioidenLkm + taulukonKasvuFaktori];
         System.arraycopy(varaTaulukko, 0, kokonaislukujenJoukko, 0, varaTaulukko.length);
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += kokonaislukujenJoukko[i]+", ";
            }
            tuotos += kokonaislukujenJoukko[alkioidenLkm - 1]+"}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            if (kokonaislukujenJoukko[i]!=0) {
            taulu[i] = kokonaislukujenJoukko[i];
            }
        }
        return taulu;
    }
   
   
        
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko(a.mahtavuus()+b.mahtavuus());
        x.lisaa(a.getTaulu());
        x.lisaa(b.getTaulu());
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();

        for (int i = 0; i < a.getTaulu().length; i++) {
            for (int j = 0; j < b.getTaulu().length; j++) {
                if (a.getTaulu()[i] == a.getTaulu()[j]) {
                    y.lisaa(a.getTaulu()[j]);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        for (int i = 0; i < a.getTaulu().length; i++) {
            z.lisaa(a.getTaulu()[i]);
        }
        for (int i = 0; i < b.getTaulu().length; i++) {
            z.poista(a.getTaulu()[i]);
        }
         return z;
    }
 
    public int[] getTaulu() {
        return this.kokonaislukujenJoukko;
    }
    
}
package ohtu.intjoukkosovellus;

public class IntJoukko {

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
        if (kapasiteetti < 0) throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        if (kasvatuskoko < 0) throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) ljono[i] = 0;
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (alkioidenLukumaara(luku)) return true;
        if (!kuuluu(luku)) {
            lisays(luku);
            return true;
        }
        return false;
    }
    
    public void lisays(int luku) {
        ljono[alkioidenLkm] = luku;
        alkioidenLkm++;
        if (jakoJaannos()) {}   
    }

    public boolean jakoJaannos() {
        if (alkioidenLkm % ljono.length == 0) {
            int[] taulukkoOld = new int[ljono.length];
            kopioiTaulukko(ljono, taulukkoOld);
            ljono = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(taulukkoOld, ljono);
            return true;
        }
        return false;
    }

    public boolean alkioidenLukumaara(int luku) {
        if (alkioidenLkm == 0) {
            ljono[0] = luku;
            alkioidenLkm++;
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        return paikka(luku) != -1 ;
    }
    
    public int paikka(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) return i;
        }
        return -1;
    }

    public boolean poista(int luku) {
        int kohta = paikka(luku);
        if (kohta == -1) return false;
        if (kohta != -1) {
            lapikaynti(kohta);
            return true;
        }
        return false;
    }
    
    public void lapikaynti(int kohta) {
        int apu;
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
                apu = ljono[j];
                ljono[j] = ljono[j + 1];
                ljono[j + 1] = apu;
            }
            alkioidenLkm--;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);
    }
    
    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + ljono[0] + "}";
        } else {
            return cutTheCrap();
        }
    }
    
    public String cutTheCrap() {
        String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += ljono[i] + ", ";
            }
            tuotos += ljono[alkioidenLkm - 1] + "}";
            return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(ljono, 0, taulu, 0, taulu.length);
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int i = 0; i < a.toIntArray().length; i++) x.lisaa(a.toIntArray()[i]);
        for (int i = 0; i < b.toIntArray().length; i++) x.lisaa(b.toIntArray()[i]);
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        for (int i = 0; i < a.toIntArray().length; i++) {
            for (int j = 0; j < b.toIntArray().length; j++) {
                if (a.toIntArray()[i] == b.toIntArray()[j]) y.lisaa(b.toIntArray()[j]);
            }
        }
        return y;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        for (int i = 0; i < a.toIntArray().length; i++) z.lisaa(a.toIntArray()[1]);
        for (int i = 0; i < b.toIntArray().length; i++) z.poista(i);
        return z;
    }
}


package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        ljono = new int[KAPASITEETTI];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if(kapasiteetti>0){
            ljono = new int[kapasiteetti];
            for (int i = 0; i < ljono.length; i++) {
                ljono[i] = 0;
            }
            alkioidenLkm = 0;
            this.kasvatuskoko = OLETUSKASVATUS;
        }
    }
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if(kapasiteetti>0&&kasvatuskoko>0){
            ljono = new int[kapasiteetti];
            for (int i = 0; i < ljono.length; i++) {
                ljono[i] = 0;
            }
            alkioidenLkm = 0;
            this.kasvatuskoko = kasvatuskoko;
        }
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            uudistaTaulukko(luku);
            return true;
        }
        return false;
    }
    public void uudistaTaulukko(int luku){
        ljono[alkioidenLkm] = luku;
        alkioidenLkm++;
        if (alkioidenLkm%ljono.length == 0) {
            int[] taulukkoOld = new int[ljono.length];
            taulukkoOld = ljono;
            ljono = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(taulukkoOld, ljono);
        }
    }
    public boolean kuuluu(int luku) {
        
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int kohta = -1;
        int apu;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                kohta = i;
                ljono[kohta] = 0;
                break;
            }
        }
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenLkm - 1; j++) {
                ljono[j] = ljono[j+1];
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
            String tuotos = "{";
            if(alkioidenLkm>0){
               tuotos =  keraaAlkiot(tuotos); 
            }
            tuotos += "}";
            return tuotos;
    }
    public String keraaAlkiot(String tuotos){
        for(int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += ljono[i];
            tuotos += ", ";
        }
        tuotos += ljono[alkioidenLkm-1];
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        yhdiste = lisaaTauluun(yhdiste,aTaulu);
        yhdiste = lisaaTauluun(yhdiste,bTaulu);
        return yhdiste;
    }
    public static IntJoukko lisaaTauluun(IntJoukko lisataan,int[] lisattava){
        for (int i = 0; i < lisattava.length; i++) {
            lisataan.lisaa(lisattava[i]);
        }
        return lisataan;
    }
    public static IntJoukko poistaTaulusta(IntJoukko poistetaan,int[] poistettava){
        for (int i = 0; i < poistettava.length; i++) {
            poistetaan.poista(i);
        }
        return poistetaan;
    }
    public static IntJoukko lisaaTauluunEhdolla(IntJoukko lisataan,int[] lisattava1,int lisattava2[]){
        for (int i = 0; i < lisattava1.length; i++) {
            for (int j = 0; j < lisattava2.length; j++) {
                if (lisattava1[i] == lisattava2[j]) {
                    lisataan.lisaa(lisattava2[j]);
                }
            }
        }
        return lisataan;
    }
    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        leikkaus = lisaaTauluunEhdolla(leikkaus,aTaulu,bTaulu);
        return leikkaus;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        erotus = lisaaTauluun(erotus,aTaulu);
        erotus = poistaTaulusta(erotus,bTaulu);
        return erotus;
    }
        
}
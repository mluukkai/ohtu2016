
package ohtu.intjoukkosovellus;

public class IntJoukko {

    private int kapasiteetti,oletuskasvatus;
    
    // näin paljon isompi kuin vanha
    private int kasvatus;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(5,5);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti,5);
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0)kapasiteetti=0;
        if (kasvatuskoko < 0)kasvatuskoko=0;
        ljono = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatus = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm >= ljono.length)kasvataTaulukko();
            return true;
        }
        return false;
    }
    
    private void kasvataTaulukko(){
        int[] vanha = ljono.clone();
        vanha = ljono;
        ljono = new int[alkioidenLkm + kasvatus];
        lisaaAlkiot(vanha, ljono);
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
        boolean loytyy=false;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]){
                loytyy=true;
                alkioidenLkm--;
            }
            if(loytyy)ljono[i] = ljono[i + 1];
        }
        return loytyy;    
        
    }

    private void lisaaAlkiot(int[] alkiot, int[] lista) {
        for (int i = 0; i < alkiot.length; i++) {
            lista[i] = alkiot[i];
        }
    }

    public int maara() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if(alkioidenLkm==0)return "{}";
        
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += ljono[i];
            tuotos += ", ";
        }
        tuotos += ljono[alkioidenLkm - 1];
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
    
    public IntJoukko kopioi(){
        IntJoukko x = new IntJoukko();
        x.ljono=this.ljono;
        x.alkioidenLkm=this.alkioidenLkm;
        x.kasvatus=this.kasvatus;
        x.kapasiteetti=this.kapasiteetti;
        x.oletuskasvatus=this.oletuskasvatus;
        return x;
    }
   

    public IntJoukko yhdiste(IntJoukko a) {
        IntJoukko x = kopioi();
        int[] aTaulu = a.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        return x;
    }

    public IntJoukko leikkaus(IntJoukko b) {
        IntJoukko x=new IntJoukko();
        IntJoukko a = kopioi();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    x.lisaa(bTaulu[j]);
                }
            }
        }
        return x;

    }
    
    public IntJoukko erotus (IntJoukko b) {
        IntJoukko x = kopioi();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; i++) {
            x.poista(bTaulu[i]);
        }
        return x;
    }
    
    public int[] getTaulukko(){
        return ljono;
    }
    
    public void setTaulukko(int[] taulu){
        ljono=taulu;
    }
        
}
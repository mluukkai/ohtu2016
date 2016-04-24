
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5,    // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
                                                 // näin paljon isompi kuin vanha
    
    private int kasvatus;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden määrä on nolla. 

    public IntJoukko() {
        lukujono = new int[KAPASITEETTI];
        for (int i = 0; i < lukujono.length; i++) {
            lukujono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatus = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        lukujono = new int[kapasiteetti];
        for (int i = 0; i < lukujono.length; i++) {
            lukujono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatus = OLETUSKASVATUS;

    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetin ja kasvatuskoon taytyy olla positiivisia");//heitin vaan jotain :D
        }
        
        lukujono = new int[kapasiteetti];
        for (int i = 0; i < lukujono.length; i++) {
            lukujono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatus = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == 0) {
            lukujono[0] = luku;
            alkioidenLkm++;
            return true;
        }
        
        if (!jonostaLoytyy(luku)) {
            lukujono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % lukujono.length == 0) {
                int[] taulukkoOld = new int[lukujono.length];
                taulukkoOld = lukujono;
                kopioiTaulukko(lukujono, taulukkoOld);
                lukujono = new int[alkioidenLkm + kasvatus];
                kopioiTaulukko(taulukkoOld, lukujono);
            }
            return true;
        }
        return false;
    }

    public boolean jonostaLoytyy(int luku) {
        for (int i : lukujono) {
            if (i == luku) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int kohta = -1;
        int apu;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                lukujono[kohta] = 0;
                break;
            }
        }
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
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + lukujono[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += lukujono[i];
                tuotos += ", ";
            }
            tuotos += lukujono[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujono[i];
        }
        return taulu;
    }
       
    public static IntJoukko teeJoukoille (String operaatio, IntJoukko a, IntJoukko b) {
        IntJoukko r = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        
        switch (operaatio) {
            case "erotus"   :   for (int i = 0; i < aTaulu.length; i++) {
                                    r.lisaa(aTaulu[i]);
                                }
                                for (int i = 0; i < bTaulu.length; i++) {
                                    r.poista(i);
                                }
                                return r;
                
            case "yhdiste"  :   for (int i = 0; i < aTaulu.length; i++) {
                                    r.lisaa(aTaulu[i]);
                                }
                                for (int i = 0; i < bTaulu.length; i++) {
                                    r.lisaa(bTaulu[i]);
                                }
                                return r;
                                
            case "leikkaus" :   for (int i = 0; i < aTaulu.length; i++) {
                                    for (int j = 0; j < bTaulu.length; j++) {
                                        if (aTaulu[i] == bTaulu[j]) {
                                            r.lisaa(bTaulu[j]);
                                        }
                                    }
                                }
                                return r;
                
            default         : return r;
        }
    }
        
}
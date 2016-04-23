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
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
        ljono = new int[kapasiteetti];
        alustaJoukkoNollilla();
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    private void alustaJoukkoNollilla() {
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
    }

    public boolean lisaa(int luku) {

        if (!kuuluu(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;

            // jos tämänhetkinen taulukko on täynnä, luodaan
            // uusi
            if (alkioidenLkm % ljono.length == 0) {
                int[] taulukkoOld = ljono.clone();
                ljono = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(taulukkoOld, ljono);
            }
            return true;
        }
        return false;
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

        // jos lukua ei löydy ollenkaan, lopetetaan siihen paikkaan
        if (!kuuluu(luku)) {
            return false;
        }

        // siirretään muita lukuja 
        int apu;

        for (int j = etsiLuku(luku); j < alkioidenLkm - 1; j++) {
            apu = ljono[j];
            ljono[j] = ljono[j + 1];
            ljono[j + 1] = apu;
        }

        // tilastot kuntoon ja paluuarvo
        alkioidenLkm--;
        return true;

    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    // antaa etsityn luvun sijainnin joukossa, jos ei löydy niin -1
    private int etsiLuku(int luku) {

        for (int i = 0; i < alkioidenLkm; i++) {

            // paikallistettu kohta, josta luku löytyy
            if (luku == ljono[i]) {
                return i;
            }
        }

        // ei löytynyt mitään
        return -1;

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    // apumetodi, joka palauttaa tietyssä indeksissä olevan
    // arvon
    private int annaLuku(int indeksi) {
        return ljono[indeksi];
    }

    @Override
    public String toString() {

        String tuotos = "{";

        for (int i = 0; i < alkioidenLkm; i++) {
            tuotos += ljono[i];
            tuotos += (i < alkioidenLkm - 1 ? ", " : "");
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

    // yhdistetään kaksi joukkoa luomalla yksi uusi joukko ja
    // lisäämällä siihen kahden aiemman joukon alkiot. lisäysmetodi
    // huolehtii siitä että ei tule tuplia.
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();

        for (int i = 0; i < a.mahtavuus(); i++) {
            x.lisaa(a.annaLuku(i));
        }
        for (int i = 0; i < b.mahtavuus(); i++) {
            x.lisaa(b.annaLuku(i));
        }
        return x;
    }

    // tehdään joukko, joka sisältää sekä a:sta että b:stä löytyvät luvut
    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {

        IntJoukko y = new IntJoukko();
        
        // luupataan läpi ja katsotaan että löytyykö myös b:stä
        for (int i = 0; i < a.mahtavuus(); i++) {
            if (b.kuuluu(a.annaLuku(i))) y.lisaa(a.annaLuku(i));
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

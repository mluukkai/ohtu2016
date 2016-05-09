/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author kkirjala
 */
public abstract class KiviPaperiSakset {

    protected Pelaaja ekaPelaaja;
    protected Pelaaja tokaPelaaja;
    private Tuomari tuomari;

    
    public void luoTuomari() {
        this.tuomari = new Tuomari();
    }
    
    public abstract void luoEkaPelaaja();
    public abstract void luoTokaPelaaja();

    // TODO
    // stepit: 1 ykköspelaajan siirto, 2 kakkospelaajan siirto, 3 evaluointi
    // 4 pisteen kirjaus
    
    public String ekanSiirto() {
        return ekaPelaaja.annaSiirto();
    }
    
    public String tokanSiirto() {
        return tokaPelaaja.annaSiirto();
    }

    public void pelaa() {

        // ensimmäinen kierros
        String siirtoEka = ekanSiirto();
        String siirtoToka = tokanSiirto();
        
        // päälooppi, mennään kierroksia kunnes tulee joku muu
        // syöte käyttäjältä kuin "k", "p" tai "s"
        while (onkoOkSiirto(siirtoEka) && onkoOkSiirto(siirtoToka)) {

            System.out.println("Tietokone valitsi: " + siirtoToka);

            // tuomari kirjaa pisteet ja kertoo tilanteen
            tuomari.kirjaaSiirto(siirtoEka, siirtoToka);
            System.out.println(tuomari);
            System.out.println();
            
            // kysytään lisää kierroksia
            siirtoEka = ekanSiirto();
            siirtoToka = tokanSiirto();
            
        }

        // peli loppuu.
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);

    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

}

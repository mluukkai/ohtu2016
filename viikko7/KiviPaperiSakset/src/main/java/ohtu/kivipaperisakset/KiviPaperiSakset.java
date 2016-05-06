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

    private Pelaaja ekaPelaaja;
    private Pelaaja tokaPelaaja;
    private Tuomari tuomari;

    abstract void printWinner();

    // TODO: tänne tuomarin perustaminen
    public void alustaPeli() {
        this.tuomari = new Tuomari();
    }

    // TODO
    // stepit: 1 ykköspelaajan siirto, 2 kakkospelaajan siirto, 3 evaluointi
    // 4 pisteen kirjaus
    
    
    public String[] pelaa() {

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();

            tokanSiirto = tekoaly.annaSiirto();
            System.out.println("Tietokone valitsi: " + tokanSiirto);
            tekoaly.asetaSiirto(ekanSiirto);

        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);

    }

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

}

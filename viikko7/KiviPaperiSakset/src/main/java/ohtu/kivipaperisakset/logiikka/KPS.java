
package ohtu.kivipaperisakset.logiikka;

import ohtu.kivipaperisakset.pelaaja.IhmisPelaaja;
import ohtu.kivipaperisakset.pelaaja.Pelaaja;
import ohtu.kivipaperisakset.pelaaja.Tekoaly;
import ohtu.kivipaperisakset.pelaaja.TekoalyParannettu;
import ohtu.kivipaperisakset.ui.UI;

public class KPS {

    public static int PvP = 0;
    public static int PvAI = 1;
    public static int PvVaikeaAI = 1;
    
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private UI ui;
    private Tuomari tuomari;

    public KPS(int tyyppi, UI ui) {
        this.ui = ui;
        if (tyyppi == PvP) alustaPvP();
        else if (tyyppi == PvAI) alustaPvAI();
        else if (tyyppi == PvVaikeaAI) alustaPvVaikeaAI();
    }
    
    private void alustaPvP() {
        this.pelaaja1 = new IhmisPelaaja(ui);
        this.pelaaja2 = new IhmisPelaaja(ui);
    }
    
    private void alustaPvAI() {
        this.pelaaja1 = new IhmisPelaaja(ui);
        this.pelaaja2 = new Tekoaly();
    }
    
    private void alustaPvVaikeaAI() {
        this.pelaaja1 = new IhmisPelaaja(ui);
        this.pelaaja2 = new TekoalyParannettu(20);
        
    }
    
    public void pelaa() {
        this.tuomari = new Tuomari();

        String ekanSiirto=null, tokanSiirto=null;

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            ui.tulosta(tuomari.toString());

            ui.tulosta("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = pelaaja1.annaSiirto();
            
            ui.tulosta("Toisen pelaajan siirto: ");
            tokanSiirto = pelaaja2.annaSiirto();
        }

        ui.tulosta(loppuTilanne());
    }
    
    
    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto) || siirto == null;
    }
    
    private String loppuTilanne() {
        return "Kiitos!\n" + tuomari.toString();
    }
    
    
}

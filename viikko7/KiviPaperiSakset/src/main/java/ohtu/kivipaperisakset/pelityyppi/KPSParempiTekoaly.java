package ohtu.kivipaperisakset.pelityyppi;

import ohtu.kivipaperisakset.hahmo.Ihminen;
import ohtu.kivipaperisakset.hahmo.TekoalyParannettu;


// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSakset {  
    
    @Override
    public void luoEkaPelaaja() {
        this.ekaPelaaja = new Ihminen("Ensimmäinen pelaaja");
    }

    @Override
    public void luoTokaPelaaja() {
        this.tokaPelaaja = new TekoalyParannettu(20, "Tietokone");
    }

    @Override
    public String ekanSiirto() {
        
        // rekisteöröidään ykköspelaajan siirto "koneoppimisen" vuoksi
        String siirto = this.ekaPelaaja.annaSiirto();        
        this.tokaPelaaja.asetaSiirto(siirto);
        
        return siirto;    
    }





}

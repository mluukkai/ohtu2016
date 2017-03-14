package ohtu.kivipaperisakset.pelityyppi;

import ohtu.kivipaperisakset.hahmo.Ihminen;
import ohtu.kivipaperisakset.hahmo.Tekoaly;

public class KPSTekoaly extends KiviPaperiSakset {

    public KPSTekoaly() {

    }

    
    @Override
    public void luoEkaPelaaja() {        
        this.ekaPelaaja = new Ihminen("Ensimmäinen pelaaja");
        
    }

    @Override
    public void luoTokaPelaaja() {
        this.tokaPelaaja = new Tekoaly("Tietokone");
    }


    
    
    
}
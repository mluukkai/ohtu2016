package ohtu.kivipaperisakset.pelityyppi;

import java.util.Scanner;
import ohtu.kivipaperisakset.hahmo.Ihminen;

public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {

    @Override
    public void luoEkaPelaaja() {
        this.ekaPelaaja = new Ihminen("Ensimmäinen pelaaja");
    }

    @Override
    public void luoTokaPelaaja() {
        this.tokaPelaaja = new Ihminen("Toinen pelaaja");
    }




}
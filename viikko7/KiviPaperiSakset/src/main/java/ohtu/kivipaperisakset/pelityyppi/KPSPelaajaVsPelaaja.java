package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {

    @Override
    public void luoEkaPelaaja() {
        this.ekaPelaaja = new Ihminen();
    }

    @Override
    public void luoTokaPelaaja() {
        this.tokaPelaaja = new Ihminen();
    }




}
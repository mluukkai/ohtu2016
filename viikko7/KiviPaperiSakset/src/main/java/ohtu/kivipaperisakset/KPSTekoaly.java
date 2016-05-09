package ohtu.kivipaperisakset;

public class KPSTekoaly extends KiviPaperiSakset {

    @Override
    public void luoEkaPelaaja() {
        this.ekaPelaaja = new Ihminen();
    }

    @Override
    public void luoTokaPelaaja() {
        this.tokaPelaaja = new Tekoaly();
    }


    
    
}
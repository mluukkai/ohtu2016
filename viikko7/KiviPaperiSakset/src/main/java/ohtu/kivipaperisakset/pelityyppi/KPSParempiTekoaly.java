package ohtu.kivipaperisakset;


// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSakset {  
    
    @Override
    public void luoEkaPelaaja() {
        this.ekaPelaaja = new Ihminen();
    }

    @Override
    public void luoTokaPelaaja() {
        this.tokaPelaaja = new TekoalyParannettu(20);
    }

    @Override
    public String ekanSiirto() {
        
        // rekisteöröidään ykköspelaajan siirto "koneoppimisen" vuoksi
        String siirto = this.ekaPelaaja.annaSiirto();        
        this.tokaPelaaja.asetaSiirto(siirto);
        
        return siirto;    
    }





}

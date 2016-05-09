package ohtu.kivipaperisakset;

public class PeliTehdas {

    public PeliType KPSTekoaly() {
        return new KPSTekoaly(new Ihmispelaaja(new InOut()), new Tuomari(), new InOut());
    }
    
    public PeliType KPSPelaajaVsPelaaja() {
        return new KPSPelaajaVsPelaaja(new Ihmispelaaja(new InOut()), new Tuomari(), new InOut());
    }

    public PeliType KPSParempiTekoaly() {
        return new KPSParempiTekoaly(new Ihmispelaaja(new InOut()), new Tuomari(), new InOut());
    }
    
    
    
}

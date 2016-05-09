package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends PeliType {

    Ihmispelaaja pelaaja2;

    public KPSPelaajaVsPelaaja(Ihmispelaaja pelaaja1, Tuomari tuomari, IO io) {
        super(pelaaja1, tuomari, io);
        this.pelaaja2 = new Ihmispelaaja(io);
    }

    public void pelaa() {

        io.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.annaSyote();
        io.print("Toisen pelaajan siirto: ");
        String tokanSiirto = io.annaSyote();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.print(tuomari.toString());
            io.print("");

            io.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = io.annaSyote();
            
            io.print("Toisen pelaajan siirto: ");
            tokanSiirto = io.annaSyote();
        }

        io.print("");
        io.print("Kiitos!");
        io.print(tuomari.toString());
    }

    
}
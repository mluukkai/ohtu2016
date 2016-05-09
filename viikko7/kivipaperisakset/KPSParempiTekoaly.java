package ohtu.kivipaperisakset;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends PeliType {

    private TekoalyParannettu tekoaly;

    public KPSParempiTekoaly(Ihmispelaaja pelaaja1, Tuomari tuomari, IO io) {
        super(pelaaja1, tuomari, io);
        this.tekoaly = new TekoalyParannettu(20);

    }

    public void pelaa() {

        io.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.annaSyote();
        String tokanSiirto;

        tokanSiirto = tekoaly.annaSiirto();
        io.print("Tietokone valitsi: " + tokanSiirto);

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.print(tuomari.toString());
            io.print("");

            io.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = io.annaSyote();

            tokanSiirto = tekoaly.annaSiirto();
            io.print("Tietokone valitsi: " + tokanSiirto);
            tekoaly.asetaSiirto(ekanSiirto);

        }

        io.print("");
        io.print("Kiitos!");
        io.print(tuomari.toString());
    }

}

package ohtu.kivipaperisakset;

public class KPSTekoaly extends PeliType {

    private Tekoaly tekoaly;

    public KPSTekoaly(Ihmispelaaja pelaaja1, Tuomari tuomari, IO io) {
        super(pelaaja1, tuomari, io);
        this.tekoaly = new Tekoaly();

    }

    @Override
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

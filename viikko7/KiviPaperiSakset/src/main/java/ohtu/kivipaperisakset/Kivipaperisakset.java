/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.LinkedList;

/**
 *
 * @author mikromafia
 */
public class Kivipaperisakset {

    public IO io;
    static int vuoro;
    public LinkedList<Komento> history;
    private final Komentotehdas komentotehdas;
    private final Logiikkatehdas logiikkatehdas;
    private Logiikka logiikka;
    private Tuomari tuomari;

    public Kivipaperisakset() {
        this.io = new ConsoleIO();
        this.history = new LinkedList<Komento>();
        this.komentotehdas = new Komentotehdas();
        this.logiikkatehdas = new Logiikkatehdas();
    }

    public void uusiPeli() {
        tuomari = new Tuomari();
        Ilmoitus.valitsePelitila();
        io.print("\n");
        io.print("> ");
        String command = io.readLine();
        if (alustaPeli(command.charAt(0))) {
            kierros();
        } else {
            io.print("Good bye!");
        }
    }

    public void kierros() {

        String command = "";

        if (vuoro%2==0) {
            Ilmoitus.varoitaVirheellisistaSiirroista();
        }

        while (true) {

            if (this.logiikka.ihmisenVuoro()) {
              //  io.print("\n");
                io.print(this.logiikka.konsolilyhenne(vuoro)+" ");

            }

            if (kasitteleKasky(this.logiikka.seuraavaSiirto(this.history))) {
                break;
            }

        }

        evaluoi();

    }

    private boolean alustaPeli(char c) {
        this.logiikka = this.logiikkatehdas.hae(c);
        if (this.logiikka == null) {
            return false;
        }
        return true;
    }

    private void evaluoi() {
        vuoro++;

        if (vuoro % 2 == 0) {
            String tulos = tuomari.kirjaaSiirto(this.history.poll(), this.history.poll());
            tulos = tulos.replace("PELAAJA1", this.logiikka.ensimmainenPelaaja());
            tulos = tulos.replace("PELAAJA2", this.logiikka.toinenPelaaja());
            io.print(tulos + "\n");
        }

        if (vuoro % 40 == 0) {
            String tulos = tuomari.tulokset();
            tulos = tulos.replace("PELAAJA1", this.logiikka.ensimmainenPelaaja());
            tulos = tulos.replace("PELAAJA2", this.logiikka.toinenPelaaja());
            io.print(tulos + "\n");
            uusiPeli();
        } else {
            kierros();
        }
    }

    private boolean kasitteleKasky(char c) {
        Komento komento = komentotehdas.hae(c);
        if (komento != null) {

            io.print("===" + this.logiikka.nykyinenPelaaja(vuoro) + " pelasi: " + komento.toString() + "! ===\n");

            history.add(komento);
            return true;
        }
        io.print("Tunnistamaton komento!\n");
        return false;

    }

}

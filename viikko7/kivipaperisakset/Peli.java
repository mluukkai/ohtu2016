/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author mikosty
 */
public class Peli implements KPSPeli {
    
    private IO io;
    private PeliTehdas tehdas;
    private PeliType tyyppi;
    
    public Peli() {
        this.tehdas = new PeliTehdas();
    }


    @Override
    public void kaynnista(IO io) {
        while (true) {
            io.print("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = io.annaSyote();
            if (vastaus.endsWith("a")) {
                io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                tyyppi = tehdas.KPSPelaajaVsPelaaja();
                tyyppi.pelaa();
            } else if (vastaus.endsWith("b")) {
                io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                tyyppi = tehdas.KPSTekoaly();
                tyyppi.pelaa();
            } else if (vastaus.endsWith("c")) {
                io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                tyyppi = tehdas.KPSParempiTekoaly();
                tyyppi.pelaa();
            } else {
                break;
            }

        }
    }
    
}

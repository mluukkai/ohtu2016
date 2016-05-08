/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.pelaajat.Pelaaja;

/**
 *
 * @author oskar
 */
public class Peli {
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;

    public Peli(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
    }
    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = pelaaja1.siirra();
        System.out.print("Toisen pelaajan siirto: ");
        String tokanSiirto = pelaaja2.siirra();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = pelaaja1.siirra();
            
            System.out.print("Toisen pelaajan siirto: ");
            tokanSiirto = pelaaja2.siirra();
            pelaaja1.kirjaaVastustajanSiirto(tokanSiirto);
            pelaaja2.kirjaaVastustajanSiirto(ekanSiirto);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    public static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}

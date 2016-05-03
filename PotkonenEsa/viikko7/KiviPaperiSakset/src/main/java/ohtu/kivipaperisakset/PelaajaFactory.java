/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author Esa Potkonen
 */
public class PelaajaFactory {
    public static Pelaaja annaPelaaja(String vastaus) {
        Pelaaja pelaaja = null;
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        if (vastaus.endsWith("a")) {
            pelaaja = new KPSPelaajaVsPelaaja(new Tuomari(), null);
        } else if (vastaus.endsWith("b")) {
            pelaaja = new KPSTekoaly(new Tuomari(), new Tekoaly());
        } else if (vastaus.endsWith("c")) {
            pelaaja = new KPSTekoaly(new Tuomari(), new TekoalyParannettu(20));
        }
        
        return pelaaja;
    } 
    
}

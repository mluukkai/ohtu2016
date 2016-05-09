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
public abstract class PeliType {
    
    Ihmispelaaja pelaaja1;
    Tuomari tuomari;
    IO io;

    public PeliType(Ihmispelaaja pelaaja1, Tuomari tuomari, IO io) {
        this.io = io;
        this.pelaaja1 = pelaaja1;
        this.tuomari = tuomari;
    }
    
    public static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
    protected abstract void pelaa();

}

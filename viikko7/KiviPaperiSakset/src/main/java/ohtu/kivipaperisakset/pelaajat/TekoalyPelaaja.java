/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset.pelaajat;

/**
 *
 * @author oskar
 */
public class TekoalyPelaaja extends Pelaaja {

    public TekoalyPelaaja() {
        super(false);
    }

    @Override
    public String otaSiirto() {
        if (siirto == 0) {
            return "k";
        } else if (siirto == 1) {
            return "p";
        } else {
            return "s";
        }
    }
    
}

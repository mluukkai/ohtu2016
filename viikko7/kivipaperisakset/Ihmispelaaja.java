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
public class Ihmispelaaja implements Pelaaja {
    
    private IO io;
    
    public Ihmispelaaja(IO io) {
        this.io = io;
    }

    @Override
    public String annaSiirto() {
        return io.annaSyote();
    }

    @Override
    public void asetaSiirto(String siirto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

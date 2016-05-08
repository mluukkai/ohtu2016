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
public abstract class Pelaaja {
    final boolean isSelfPrinting;
    protected int siirto = 0;

    public Pelaaja(boolean isSelfPrinting) {
        this.isSelfPrinting = isSelfPrinting;
    }
    
    public final String siirra() {
        siirto++;
        siirto = siirto % 3;
        String returnValue = this.otaSiirto();
        if (!this.isSelfPrinting) 
            System.out.print(returnValue + '\n');
        return returnValue;
    }
    
    // Implemeted will return the siirto
    abstract String otaSiirto();
    
    // Will be called with the opponents move at end of each turn.
    public void kirjaaVastustajanSiirto(String siirtto) {}
}

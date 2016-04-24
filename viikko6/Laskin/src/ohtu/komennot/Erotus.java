/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.komennot;

import java.util.ArrayList;
import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author oskar
 */
public class Erotus extends Komento {

    ArrayList<Integer> syote = new ArrayList<>();
    
    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }
    
    
    @Override
    public void suorita() {
        int value = this.getSyoteValue();
        this.syote.add(value);
        this.sovellus.miinus(value);
        this.setValues("" + this.sovellus.tulos(), "");
    }

    @Override
    public void peru() {
        int value = this.syote.remove(this.syote.size() - 1);
        this.sovellus.plus(value);
        this.setValues("" + this.sovellus.tulos(), "" + value);
    }
    

    
}

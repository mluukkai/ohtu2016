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
public class Nollaa extends Komento {

    ArrayList<Integer> syote = new ArrayList<>();
    ArrayList<Integer> tulos = new ArrayList<>();
    
    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }
    
    
    @Override
    public void suorita() {
        this.syote.add(this.getSyoteValue(0));
        this.tulos.add(this.sovellus.tulos());
        this.sovellus.nollaa();
        this.setValues("" + this.sovellus.tulos(), "");
    }

    @Override
    public void peru() {
        int prevSyote = this.syote.remove(this.syote.size() - 1);
        int prevTulos = this.tulos.remove(this.tulos.size() - 1);
        this.sovellus.plus(prevTulos);
        this.setValues("" + this.sovellus.tulos(), "" + prevSyote);
    }
    

    
}

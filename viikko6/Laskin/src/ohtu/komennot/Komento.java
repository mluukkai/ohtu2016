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
public abstract class Komento {
    Sovelluslogiikka sovellus;
    JTextField tuloskentta;
    JTextField syotekentta;
    public Komento(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }
    
    abstract public void suorita();
    abstract public void peru();
    
    protected int getSyoteValue() {
        return Integer.parseInt(syotekentta.getText());
    }
    
    protected int getSyoteValue(int defaultValue) {
        try {
            return Integer.parseInt(syotekentta.getText());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    
    protected int getTulosValue() {
        return Integer.parseInt(tuloskentta.getText());
    }
    
    protected void setValues(String tulo, String syote) {
        tuloskentta.setText(tulo);
        syotekentta.setText(syote);
    }
}

package ohtu;


import javax.swing.JTextField;
import ohtu.Komento;
import ohtu.Sovelluslogiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jkostet
 */
public class Nollaa implements Komento {

    JTextField tuloskentta;
    int tulos;
    
    
    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.tuloskentta = tuloskentta;
    }

    @Override
    public void suorita() {
        this.tulos = Integer.parseInt(tuloskentta.getText());
        tuloskentta.setText("0");
    }

    @Override
    public void peru() {
        tuloskentta.setText(""+tulos);
    }
    
}

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
public class Erotus implements Komento {

    JTextField tuloskentta;
    JTextField syotekentta;
    int tulos;
    int syote;
    
    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        this.tulos = Integer.parseInt(tuloskentta.getText());

        try {
            this.syote = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
            this.syote = 0;
        }
        
        tuloskentta.setText((""+(tulos - syote)));
        syotekentta.setText("");
    }

    @Override
    public void peru() {
        tuloskentta.setText(""+tulos);
    }
    
    
}

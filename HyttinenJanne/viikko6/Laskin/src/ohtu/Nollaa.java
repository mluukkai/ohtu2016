/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author hyttijan
 */
public class Nollaa implements Komento{
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinen;
    Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.edellinen = 0;
    }

    @Override
    public void suorita() {
        this.edellinen = Integer.parseInt(this.tuloskentta.getText());
        this.sovellus.nollaa();
    }

    @Override
    public void peru() {
        this.tuloskentta.setText(String.valueOf(this.edellinen));
    }
    
}

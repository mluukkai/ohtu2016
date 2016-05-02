/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaatiot;

import javax.swing.JTextField;
import ohtu.Komento;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author jphanski
 */
public class Miinus implements Komento {

    private final Sovelluslogiikka sovellus;
    private final JTextField tuloskentta;
    private final JTextField syotekentta;
    private int edellinen;

    public Miinus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        edellinen = Integer.parseInt(syotekentta.getText());
        sovellus.miinus(edellinen);
    }

    @Override
    public void peru() {
        sovellus.plus(edellinen);
    }
    
}

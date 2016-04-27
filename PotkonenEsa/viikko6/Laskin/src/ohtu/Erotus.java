/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author Esa Potkonen
 */
public class Erotus implements Komento {
    Sovelluslogiikka sovellus;
    JTextField tuloskentta;
    JTextField syotekentta;
    int arvo = 0;
    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
            this.arvo = arvo;
           sovellus.miinus(arvo);
        } catch (Exception e) {
        }

        int laskunTulos = sovellus.tulos();
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }

    @Override
    public void peru() {
        int reverse = -arvo;
        syotekentta.setText(""+reverse);
        suorita();
    }
    
}

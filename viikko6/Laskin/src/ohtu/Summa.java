/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author kkirjala
 */
public class Summa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinenArvo;

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;        
    }

    @Override
    public void suorita() {
        if (syotekentta.getText().isEmpty()) return;
        
        int tulos = this.edellinenArvo + Integer.parseInt(syotekentta.getText());
        tuloskentta.setText(String.valueOf(tulos));
    }

    @Override
    public void peru() {
        tuloskentta.setText(String.valueOf(this.edellinenArvo));
    }

}

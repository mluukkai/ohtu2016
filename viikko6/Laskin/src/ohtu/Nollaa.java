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
public class Nollaa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    
    private int edellinenArvo;
    

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {      
        this.edellinenArvo = (tuloskentta.getText().isEmpty() ? 0 : Integer.parseInt(tuloskentta.getText()));
        
        tuloskentta.setText(String.valueOf(0));
    }

    @Override
    public void peru() {
        tuloskentta.setText(String.valueOf(this.edellinenArvo));
    }

}

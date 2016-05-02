/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author samukaup
 */
public abstract class Komento {
    
    protected JTextField tuloskentta;
    protected JTextField syotekentta;
    protected Sovelluslogiikka sovellus;
    private int vanhaArvo;

    public Komento(JTextField tuloskentta, JTextField syotekentta, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = sovellus;
        
    }
    
    public void suorita() {
        int arvo = 0;
 
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        vanhaArvo = Integer.parseInt(tuloskentta.getText());
        
        operaatio(arvo);
        
        int laskunTulos = sovellus.tulos();
         
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }
    
    public void peru() {
        sovellus.setTulos(vanhaArvo);
        tuloskentta.setText("" + sovellus.tulos());
    }

    protected abstract void operaatio(int arvo);  
    
    
}

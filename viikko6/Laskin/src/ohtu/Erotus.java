/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author mikromafia
 */
public class Erotus implements Komento {
    
     
    private final Sovelluslogiikka sovellus;
       private final JTextField tuloskentta;
       private final JTextField syotekentta;
       private int arvo;
     
       public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus=sovellus;
           this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        
        try {
            this.arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        sovellus.miinus(this.arvo);
                    int laskunTulos = sovellus.tulos();        
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }

    @Override
    public void peru() {
        sovellus.plus(this.arvo);
         int laskunTulos = sovellus.tulos();        
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
                    System.out.println("undo pressed");
    }
    
}

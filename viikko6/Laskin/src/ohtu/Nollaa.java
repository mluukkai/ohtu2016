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
public class Nollaa implements Komento{

  private final Sovelluslogiikka sovellus;
       private final JTextField tuloskentta;
       private final JTextField syotekentta;
       private int arvo;
     
       public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus=sovellus;
           this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        arvo = sovellus.tulos();
        
        sovellus.nollaa();
                    int laskunTulos = sovellus.tulos();        
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }

    @Override
    public void peru() {
               
         int laskunTulos = this.arvo;        
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
                    System.out.println("undo pressed");
    }
    
    
}

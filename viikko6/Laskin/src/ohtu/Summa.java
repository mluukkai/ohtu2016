/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author nikok
 */
public class Summa implements Komento {
    Sovelluslogiikka sovellus;
    JTextField tulos;
    JTextField syotto;
    int edellinen;
    
    Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tulos = tuloskentta;
        this.syotto = syotekentta;
    }

    @Override
    public void suorita() {
        this.edellinen = sovellus.tulos();
        int arvo = 0;
 
        try {
            arvo = Integer.parseInt(syotto.getText());
        } catch (Exception e) {
        }
        
        sovellus.plus(arvo);

        syotto.setText("");
        tulos.setText("" + sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.aseta(edellinen);
        tulos.setText("" + sovellus.tulos());
    }
    
}

package ohtu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JTextField;

/**
 *
 * @author hyttijan
 */
public class Summa implements Komento {

    private JTextField tuloskentta, syotekentta;
    private Sovelluslogiikka sovelluslogiikka;
    private int edellinen;
    
    public Summa(Sovelluslogiikka sovelluslogiikka, JTextField tuloskentta, JTextField syotekentta) {
        this.sovelluslogiikka = sovelluslogiikka;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.edellinen = 0;
    }

    @Override
    public void suorita() {
        try {
            this.edellinen = Integer.parseInt(this.tuloskentta.getText());
            int syoteInt = Integer.parseInt(this.syotekentta.getText());
            this.sovelluslogiikka.plus(syoteInt);
            this.tuloskentta.setText(String.valueOf(sovelluslogiikka.tulos()));
            this.syotekentta.setText("");
        } catch (NumberFormatException e) {}
    }

    @Override
    public void peru() {
        this.tuloskentta.setText(String.valueOf(this.edellinen));
    }

}

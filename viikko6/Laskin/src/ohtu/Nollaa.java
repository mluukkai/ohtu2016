package ohtu;

import javax.swing.JTextField;

public class Nollaa extends Komento {

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }

    @Override
    protected void suorita() {
        sovellus.nollaa();
        this.setTulos();
    }

    @Override
    protected void peru() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

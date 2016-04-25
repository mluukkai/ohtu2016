package ohtu;

import javax.swing.JTextField;

public class Nollaa extends Komento {

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }

    @Override
    protected void suorita() {
        viimeisinArvo = this.getArvo();
        sovellus.nollaa();
        this.setTulos();
    }

    @Override
    protected void peru() {
        sovellus.aseta(viimeisinArvo);
        this.setTulos();
    }
    
}

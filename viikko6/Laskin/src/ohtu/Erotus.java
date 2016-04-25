package ohtu;

import javax.swing.JTextField;

public class Erotus extends Komento {

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }

    @Override
    protected void suorita() {
        sovellus.miinus(this.getArvo());
        this.setTulos();
    }

    @Override
    protected void peru() {
        sovellus.plus(viimeisinArvo);
        this.setTulos();
    }
    
}

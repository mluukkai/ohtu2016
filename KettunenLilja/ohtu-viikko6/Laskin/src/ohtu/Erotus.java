package ohtu;

import javax.swing.JTextField;

class Erotus implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int vanhaSyote;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        int syote = Integer.parseInt(this.syotekentta.getText());
        sovellus.miinus(syote);
        vanhaSyote = syote;
    }

    @Override
    public void peru() {
        sovellus.plus(vanhaSyote);
    }

}

package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tulos;
    private JTextField syote;
    private int edellinen;
    
    public Nollaa(Sovelluslogiikka sovellus, JTextField tulos, JTextField syote) {
        this.sovellus = sovellus;
        this.tulos = tulos;
        this.syote = syote;
        this.edellinen = 0;
    }

    @Override
    public void suorita() {
        edellinen = sovellus.tulos();
        sovellus.nollaa();
        asetaSyote();
    }

    @Override
    public void peru() {
        sovellus.plus(edellinen);
        asetaSyote();
    }
    
    public void asetaSyote() {
        int laskunTulos = sovellus.tulos();
        syote.setText("");
        tulos.setText("" + laskunTulos);
    }
}

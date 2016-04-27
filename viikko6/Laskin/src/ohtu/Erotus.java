package ohtu;

import javax.swing.JTextField;

public class Erotus implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tulos;
    private JTextField syote;
    private int edellinen;
    
    public Erotus(Sovelluslogiikka sovellus, JTextField tulos, JTextField syote) {
        this.sovellus = sovellus;
        this.tulos = tulos;
        this.syote = syote;
        this.edellinen = 0;
    }

    @Override
    public void suorita() {
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syote.getText());
        } catch (Exception e) {
        }
        
        edellinen = arvo;
        
        sovellus.miinus(edellinen);
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

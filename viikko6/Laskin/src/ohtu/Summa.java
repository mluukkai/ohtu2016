
package ohtu;

import javax.swing.JTextField;

public class Summa implements Komento {
    private final Sovelluslogiikka sovellus;
    private final JTextField tuloskentta;
    private final JTextField syotekentta;

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }
    
    @Override
    public void suorita() {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (NumberFormatException e) {}
        
        sovellus.plus(arvo);
        
        int laskunTulos = sovellus.tulos();
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }

    @Override
    public void peru() {
        int edellinen = sovellus.edellinenTulos();
        syotekentta.setText("");
        tuloskentta.setText(""+edellinen);
    }
    
}

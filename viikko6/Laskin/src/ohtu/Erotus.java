package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author sebahemm
 */
public class Erotus implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinenSyote;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        sovellus.miinus(Integer.parseInt(syotekentta.getText()));
        tuloskentta.setText(String.valueOf(sovellus.tulos()));
        edellinenSyote = Integer.parseInt(syotekentta.getText());
    }

    @Override
    public void peru() {
        sovellus.plus(edellinenSyote);
        tuloskentta.setText(String.valueOf(sovellus.tulos()));
    }

}

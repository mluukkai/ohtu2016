package ohtu;

import javax.swing.JTextField;

public class Summa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinenSyote;

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        sovellus.plus(Integer.parseInt(syotekentta.getText()));
        tuloskentta.setText(String.valueOf(sovellus.tulos()));
        edellinenSyote = Integer.parseInt(syotekentta.getText());
    }

    @Override
    public void peru() {
        sovellus.miinus(edellinenSyote);
        tuloskentta.setText(String.valueOf(sovellus.tulos()));
    }

}

package ohtu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Tapahtumankuuntelija implements ActionListener {

    private JButton plus;
    private JButton miinus;
    private JButton nollaa;
    private JButton undo;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private Sovelluslogiikka sovellus;
    private Map<JButton, Komento> komennot;
    private Komento edellinen;

    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.nollaa = nollaa;
        this.undo = undo;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = new Sovelluslogiikka();
        komennot = new HashMap<>();
        komennot.put(plus, new Plus(tuloskentta, syotekentta, sovellus));
        komennot.put(miinus, new Miinus(tuloskentta, syotekentta, sovellus));
        komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta, sovellus));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Komento komento = komennot.get(e.getSource());
        if (komento != null) {
            komento.suorita();
            edellinen = komento;
        } else {
            edellinen.peru();
            edellinen = null;
            //undo
        }

        nollaa.setEnabled(sovellus.tulos() != 0);
        undo.setEnabled(edellinen != null);

    }

}

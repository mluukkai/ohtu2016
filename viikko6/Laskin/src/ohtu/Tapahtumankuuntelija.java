package ohtu;

import Operaatiot.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
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
    private HashMap<JButton, Komento> komennot;
    Komento edellinen;
    
    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = new Sovelluslogiikka();
        komennot = new HashMap<>();
        komennot.put(plus, new Plus(sovellus, tuloskentta, syotekentta));
        komennot.put(miinus, new Miinus(sovellus, tuloskentta, syotekentta));
        komennot.put(nollaa, new Nollaa(sovellus, tuloskentta, syotekentta));
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        int arvo = 0;
 
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        Komento komento;
        komento = komennot.get(ae.getSource());
        if (komento == null) {
            if (edellinen != null) {
                edellinen.peru();
            }
            edellinen = null;
            undo.setEnabled(false);
        }
        else {
            komento.suorita();
            undo.setEnabled(true);
        }
        edellinen = komento;
                
        int laskunTulos = sovellus.tulos();
         
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        if ( laskunTulos==0) {
            nollaa.setEnabled(false);
        } else {
            nollaa.setEnabled(true);
        }
    }
}
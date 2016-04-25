package ohtu;

import javax.swing.JTextField;

public abstract class Komento {
    
    protected Sovelluslogiikka sovellus;
    protected JTextField tuloskentta;
    protected JTextField syotekentta;
    protected int viimeisinArvo;

    public Komento(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }
    
    protected int getArvo() {
        int arvo = 0;
 
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        
        viimeisinArvo = arvo;
        
        return arvo;
    }
    
    protected void setTulos() {
        int laskunTulos = sovellus.tulos();
        
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }
    
    protected abstract void suorita();
    protected abstract void peru();
}


package ohtu.kivipaperisakset.pelaaja;

import ohtu.kivipaperisakset.ui.UI;

public class IhmisPelaaja implements Pelaaja {

    private final UI ui;

    public IhmisPelaaja(UI ui) {
        this.ui = ui;
    }
    
    @Override
    public String annaSiirto() {
        return this.ui.kysySiirto();
    }
    
}

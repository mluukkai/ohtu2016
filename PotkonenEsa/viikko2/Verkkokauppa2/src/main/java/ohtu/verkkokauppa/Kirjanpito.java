
package ohtu.verkkokauppa;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
@Component
public class Kirjanpito implements IKirjanpito {
    
    private ArrayList<String> tapahtumat;

    public Kirjanpito() {
        tapahtumat = new ArrayList<String>();
    }
    
    /* (non-Javadoc)
	 * @see ohtu.verkkokauppa.IKirjanpito#lisaaTapahtuma(java.lang.String)
	 */
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    /* (non-Javadoc)
	 * @see ohtu.verkkokauppa.IKirjanpito#getTapahtumat()
	 */
    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }       
}

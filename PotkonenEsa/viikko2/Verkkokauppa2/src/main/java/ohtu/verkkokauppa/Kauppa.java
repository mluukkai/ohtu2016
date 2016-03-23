package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kauppa implements IKauppa {
	@Autowired
    private IVarasto varasto;
	@Autowired
    private IPankki pankki;
	@Autowired
    private IViitegeneraattori viitegeneraattori;
	@Autowired
    private IKirjanpito kirjanpito;
    private Ostoskori ostoskori;
    private String kaupanTili;

    public Kauppa() {
        kaupanTili = "33333-44455";
    }

    public IKirjanpito getKirjanpito() {
		return kirjanpito;
	}

	/* (non-Javadoc)
	 * @see ohtu.verkkokauppa.IKauppa#aloitaAsiointi()
	 */
    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    /* (non-Javadoc)
	 * @see ohtu.verkkokauppa.IKauppa#poistaKorista(int)
	 */
    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    /* (non-Javadoc)
	 * @see ohtu.verkkokauppa.IKauppa#lisaaKoriin(int)
	 */
    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    /* (non-Javadoc)
	 * @see ohtu.verkkokauppa.IKauppa#tilimaksu(java.lang.String, java.lang.String)
	 */
    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}

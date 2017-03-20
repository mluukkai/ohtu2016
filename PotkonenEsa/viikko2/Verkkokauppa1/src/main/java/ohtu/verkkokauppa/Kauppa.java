package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;


public class Kauppa implements IKauppa {

    private IVarasto varasto;
    private IPankki pankki;
    private Ostoskori ostoskori;
    private IViitegeneraattori viitegeneraattori;
    private String kaupanTili;
    private IKirjanpito kirjanpito;

    public Kauppa(IVarasto varasto, IPankki pankki, IViitegeneraattori viitegeneraattori) {
        this.varasto = varasto;
        this.pankki = pankki;
        this.viitegeneraattori = viitegeneraattori;
        this.kirjanpito  = varasto.getKirjanpito();
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

package ohtu.verkkokauppa;

public class Pankki implements IPankki {
    private IKirjanpito kirjanpito;

    public Pankki(IKirjanpito kirjanpito) {
        this.kirjanpito = kirjanpito;
    }

    /* (non-Javadoc)
	 * @see ohtu.verkkokauppa.IPankki#tilisiirto(java.lang.String, int, java.lang.String, java.lang.String, int)
	 */
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}

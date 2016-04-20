package ohtu.verkkokauppa;

public interface IKauppa {

	void aloitaAsiointi();

	void poistaKorista(int id);

	void lisaaKoriin(int id);

	boolean tilimaksu(String nimi, String tiliNumero);

}
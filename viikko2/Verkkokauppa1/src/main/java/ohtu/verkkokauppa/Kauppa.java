package ohtu.verkkokauppa;


public class Kauppa {

    private VarastoInterface varastoInterface;
    private PankkiInterface pankkiInterface;
    private Ostoskori ostoskori;
    private ViiteInterface viiteInterface;
    private String kaupanTili;

    
    public Kauppa(VarastoInterface varastoI, ViiteInterface viiteI, PankkiInterface pankkiI) {
        viiteInterface=viiteI;
        varastoInterface = varastoI;
        pankkiInterface = pankkiI;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varastoInterface.haeTuote(id); 
        varastoInterface.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varastoInterface.saldo(id)>0) {
            Tuote t = varastoInterface.haeTuote(id);             
            ostoskori.lisaa(t);
            varastoInterface.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viiteInterface.uusi();
        int summa = ostoskori.hinta();
        
        return pankkiInterface.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
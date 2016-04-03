package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class Kauppa {

    private VarastoInterface varasto;
    private PankkiInterface pankki;
    private OstoskoriInterface ostoskori;
    private ViitegeneraattoriInterface viitegeneraattori;
    private String kaupanTili;

    @Autowired
    public Kauppa(VarastoInterface vI, PankkiInterface pI, ViitegeneraattoriInterface viiI) {
        varasto = vI;
        pankki = pI;
        viitegeneraattori = viiI;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        TuoteInterface t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            TuoteInterface t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}

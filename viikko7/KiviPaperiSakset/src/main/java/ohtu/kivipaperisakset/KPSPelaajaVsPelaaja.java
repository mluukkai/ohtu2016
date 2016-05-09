package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends KPSPeli {

    @Override
    protected String pyydaTokanSiirto() {
        System.out.print("Toisen pelaajan siirto: ");
        return ui.lueSyote();
    }

    @Override
    protected void suunnitteleStrategiaa(String ekanSiirto, String tokanSiirto) {
    }
}

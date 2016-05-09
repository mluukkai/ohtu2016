package ohtu.kivipaperisakset;

public abstract class KPSPeli {

    private final Tuomari tuomari;
    protected Kayttoliittyma ui;

    public KPSPeli() {
        this.tuomari = new Tuomari();
    }

    public void pelaa(Kayttoliittyma ui) {
        this.ui = ui;
        while (true) {
            String ekanSiirto = pyydaEkanSiirto();
            String tokanSiirto = pyydaTokanSiirto();

            if (!siirtoOK(ekanSiirto) || !siirtoOK(tokanSiirto)) {
                break;
            }

            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            ui.tulostaKehote(tuomari + "\n");

            suunnitteleStrategiaa(ekanSiirto, tokanSiirto);
        }
        ui.tulostaKehote("\nKiitos!\n" + tuomari);
    }

    private static boolean siirtoOK(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    private String pyydaEkanSiirto() {
        ui.tulostaKehote("Ensimmäisen pelaajan siirto: ");
        return ui.lueSyote();
    }

    protected abstract String pyydaTokanSiirto();

    protected abstract void suunnitteleStrategiaa(String ekanSiirto, String tokanSiirto);
}

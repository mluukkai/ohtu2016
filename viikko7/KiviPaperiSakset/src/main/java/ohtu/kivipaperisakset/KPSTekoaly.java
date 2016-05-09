package ohtu.kivipaperisakset;

public class KPSTekoaly extends KPSPeli {

    private final Tekoalypelaaja tekoaly;

    public KPSTekoaly(Tekoalypelaaja tekoaly) {
        this.tekoaly = tekoaly;
    }

    @Override
    protected String pyydaTokanSiirto() {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        return tokanSiirto;
    }

    @Override
    protected void suunnitteleStrategiaa(String ekanSiirto, String tokanSiirto) {
        tekoaly.asetaSiirto(ekanSiirto);
    }
}

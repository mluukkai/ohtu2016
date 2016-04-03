package ohtu.verkkokauppa;

import java.util.ArrayList;

public class Ostoskori implements OstoskoriInterface {

    ArrayList<TuoteInterface> tuotteet;

    public Ostoskori() {
        tuotteet = new ArrayList<TuoteInterface>();
    }

    @Override
    public void lisaa(TuoteInterface t) {
        tuotteet.add(t);
    }

    @Override
    public void poista(TuoteInterface t) {
        tuotteet.remove(t);
    }

    @Override
    public int hinta() {
        int hinta = 0;

        for (TuoteInterface tuote : tuotteet) {
            hinta += tuote.getHinta();
        }

        return hinta;
    }
}

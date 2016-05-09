package ohtu.kivipaperisakset.hahmo;

public class Tekoaly implements Pelaaja {

    int siirto;
    private String nimi;

    public Tekoaly(String nimi) {
        this.nimi = nimi;
        siirto = 0;
    }

    @Override
    public String annaSiirto() {
        siirto++;
        siirto = siirto % 3;

        if (siirto == 0) {
            return "k";
        } else if (siirto == 1) {
            return "p";
        } else {
            return "s";
        }
    }

    @Override
    public void asetaSiirto(String ekanSiirto) {
        // ei tehdä mitään 
    }

    @Override
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public String getNimi() {
        return this.nimi;
    }

    
}

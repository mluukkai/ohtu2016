package ohtu.kivipaperisakset;

public class Tekoaly implements Vastustaja {
    private boolean vaikea;
    int siirto;
    private String[] muisti;
    private int vapaaMuistiIndeksi;
    private final int muistinKoko = 20;
    

    public Tekoaly() {
        this.siirto = 0;
        this.vaikea = false;
        this.muisti = new String[muistinKoko];
        this.vapaaMuistiIndeksi = 0;
    }
    public Tekoaly(boolean vaikea){
        this.siirto = 0;
        this.vaikea = vaikea;
        this.muisti = new String[muistinKoko];
        this.vapaaMuistiIndeksi = 0;
    }

    public String annaSiirto() {
        if(vaikea){
            String siirto = this.annaVaikeaSiirto();
            this.asetaMuistiin(siirto);
            
            return siirto;
        }
        
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
    public String siirto() {
        String palautettavaSiirto = annaSiirto();
        
        System.out.println("Tietokone valitsi: " + palautettavaSiirto);
        
        return palautettavaSiirto;
    }
    
    public String annaVaikeaSiirto() {
        if(vapaaMuistiIndeksi == 0 || vapaaMuistiIndeksi == 1) {
          return "k";
        }

        String viimeisinSiirto = muisti[vapaaMuistiIndeksi - 1];

        int k = 0;
        int p = 0;
        int s = 0;


        for(int i = 0; i < vapaaMuistiIndeksi - 1; i++) {
          if(viimeisinSiirto.equals(muisti[i])) {
            String seuraava = muisti[i+1];

            if("k".equals(seuraava)) {
              k++;
            }
            else if("p".equals(seuraava)) {
              p++;
            }
            else {
              s++;
            }        
          }
        }


        // Tehdään siirron valinta esimerkiksi seuraavasti;
        // - jos kiviä eniten, annetaan aina paperi
        // - jos papereita eniten, annetaan aina sakset
        // muulloin annetaan aina kivi
        if(k > p && k > s) {
          return "p";
        }
        else if (p > k && p > s) {
          return "s";
        }
        else {
          return "k";
        }

        // Tehokkaampiakin tapoja löytyy, mutta niistä lisää 
        // Johdatus Tekoälyyn kurssilla!
    }
    public void asetaMuistiin(String siirto){
        if(vapaaMuistiIndeksi == muisti.length) {
            for(int i = 1; i < muisti.length; i++) {
              muisti[i-1] = muisti[i];
            }

            vapaaMuistiIndeksi--;
        }

        muisti[vapaaMuistiIndeksi] = siirto;    
        vapaaMuistiIndeksi++;
    }
}

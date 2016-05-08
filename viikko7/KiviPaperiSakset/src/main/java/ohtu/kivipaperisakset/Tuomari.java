package ohtu.kivipaperisakset;

// Tuomari pitää kirjaa ensimmäisen ja toisen pelaajan pisteistä sekä tasapelien määrästä.
public class Tuomari {

    private int ekanPisteet;
    private int tokanPisteet;
    private int tasapelit;

    public Tuomari() {
        this.ekanPisteet = 0;
        this.tokanPisteet = 0;
        this.tasapelit = 0;
    }

    public String kirjaaSiirto(Komento ekanSiirto, Komento tokanSiirto) {
    //    System.out.println("1:"+ekanSiirto.merkki()+" vs 2:"+tokanSiirto.merkki());
        if (ekanSiirto.merkki()==tokanSiirto.merkki()) {
            tasapelit++;
            return "PELAAJA1 ja PELAAJA2 tasapeliin!";
        } else if (ekanSiirto.voittaa()==tokanSiirto.merkki()) {
            ekanPisteet++;
            return "PELAAJA1 voitti!";
        } else {
            tokanPisteet++;
            return "PELAAJA2 voitti!";
        }
    }



    public String tulokset() {
        String s = "### PELI OHI ###\nLopputilanne:\nPELAAJA1: " + ekanPisteet + " - PELAAJA2: " + tokanPisteet + "\n"
                + "Tasapelit: " + tasapelit+"\n";
        return s;
    }
}
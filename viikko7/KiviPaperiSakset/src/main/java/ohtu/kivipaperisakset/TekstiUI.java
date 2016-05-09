package ohtu.kivipaperisakset;

public class TekstiUI implements Kayttoliittyma {
    @Override
    public void tulostaOhjeet() {
        System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");
    }

    @Override
    public boolean pelinAloitus(String vastaus) {
        Vastustaja vastustaja1 = new Pelaaja(1);
        Vastustaja vastustaja2 = null;

        if (vastaus.endsWith("a")) {
            vastustaja2 = new Pelaaja(2);
        } else if (vastaus.endsWith("b")) {
            vastustaja2 = new Tekoaly();
        } else if (vastaus.endsWith("c")) {
            vastustaja2 = new Tekoaly(true);
        }
        
        if(vastustaja2 != null){
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            Peli.pelaa(vastustaja1, vastustaja2);
        }
        
        return false;
    }
}

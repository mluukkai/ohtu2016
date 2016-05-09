package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Kayttoliittyma {

    private static final Scanner scanner = new Scanner(System.in);

    public String lueSyote() {
        return scanner.nextLine();
    }

    public void tulostaOhjeet() {
        System.out.println("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetataan");
    }

    public void tulostaLopetusohje() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron "
                + "eli jonkun muun kuin k, p tai s");
    }

    public void tulostaKehote(String kehote) {
        System.out.println(kehote);
    }
}

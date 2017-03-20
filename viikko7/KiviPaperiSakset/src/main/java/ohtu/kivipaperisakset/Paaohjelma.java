package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            if (vastaus.endsWith("a")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                /*
                KPSPelaajaVsPelaaja kaksinpeli = new KPSPelaajaVsPelaaja();
                kaksinpeli.pelaa();
                */
                Pelitehdas.pelaa(new Ihmispelaaja(), new Ihmispelaaja());
            } else if (vastaus.endsWith("b")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                Pelitehdas.pelaa(new Ihmispelaaja(), new TekoalyPelaaja());
            } else if (vastaus.endsWith("c")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                Pelitehdas.pelaa(new Ihmispelaaja(), new ParempiTekoalyPelaaja(20));
            } else {
                break;
            }

        }

    }
}

package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static IntJoukko A, B, C;

    private static String luku() {
        Scanner lukija = new Scanner(System.in);
        String luettu = lukija.nextLine();
        return luettu;
    }

    private static IntJoukko mikaJoukko() {
        String luettu;
        while (true) {
            switch((luettu = luku()).toUpperCase()) {
                case "A": return A;
                case "B": return B;
                case "C": return C;
                default:
                    System.out.println("Virheellinen joukko! " + luettu);
                    System.out.print("Yritä uudelleen!");
                    break;
            }
        }
    }

    private static void lisaa() {
        int lisLuku;
        IntJoukko joukko;
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mihin joukkoon? ");
        joukko = mikaJoukko();
        System.out.println("");
        System.out.print("Mikä luku lisätään? ");
        lisLuku = lukija.nextInt();
        joukko.lisaa(lisLuku);

    }

    private static void yhdiste() {
        IntJoukko aJoukko, bJoukko, c;
        System.out.print("1. joukko? ");
        aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        bJoukko = mikaJoukko();
        c = IntJoukko.yhdiste(aJoukko, bJoukko);
        System.out.println("A yhdiste B = " + c.toString());
    }

    private static void leikkaus() {
        IntJoukko aJoukko, bJoukko, c;
        System.out.print("1. joukko? ");
        aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        bJoukko = mikaJoukko();
        c = IntJoukko.leikkaus(aJoukko, bJoukko);
        System.out.println("A leikkaus B = " + c.toString());
    }

    private static void erotus() {
        IntJoukko aJoukko, bJoukko, c;
        System.out.print("1. joukko? ");
        aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        bJoukko = mikaJoukko();
        c = IntJoukko.erotus(aJoukko, bJoukko);
        System.out.println("A erotus B = " + c.toString());
    }

    private static void poista() {
        IntJoukko joukko;
        int lisLuku;
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mistä joukosta? ");
        joukko = mikaJoukko();
        System.out.print("Mikä luku poistetaan? ");
        lisLuku = lukija.nextInt();
        joukko.poista(lisLuku);
    }

    private static void kuuluu() {
        IntJoukko joukko;
        int kysLuku;
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mihin joukkoon? ");
        joukko = mikaJoukko();
        System.out.print("Mikä luku? ");
        kysLuku = lukija.nextInt();
        if (joukko.kuuluu(kysLuku)) {
            System.out.println(kysLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(kysLuku + " ei kuulu joukkoon ");
        }
    }

    public static void main(String[] args) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        String luettu;

        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");

        while (true) {
            luettu = luku();
            switch(luettu.toLowerCase()) {
                case "lisää": case "li": lisaa();
                    break;
                case "poista": case "p": poista();
                    break;
                case "kuuluu": case "k": kuuluu();
                    break;
                case "yhdiste": case "y": yhdiste(); 
                    break;
                case "erotus": case "e": erotus();
                    break;
                case "lopeta": case "quit": case "q": return;
                case "A": System.out.println(A);
                    break;
                case "B": System.out.println(B);
                    break;
                case "C": System.out.println(C);
                    break;
                default:
                    System.out.println("Virheellinen komento! " + luettu);
                    break;
                    
            }
            
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
    }
}

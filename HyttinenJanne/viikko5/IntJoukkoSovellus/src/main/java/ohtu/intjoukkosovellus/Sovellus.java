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
        Scanner lukija = new Scanner(System.in);
        IntJoukko joukko = null;
        while (joukko==null) {
            joukko = joukonValinta();
        }
        return joukko;
    }
    private static IntJoukko joukonValinta(){
        String luettu = luku();
        IntJoukko joukko = tarkista(luettu);
        if(joukko==null){
            System.out.println("Virheellinen joukko! " + luettu);
            System.out.print("Yritä uudelleen!");
        }
        return joukko;    
    }
    public static IntJoukko tarkista(String luettu){
        if (luettu.equals("A") || luettu.equals("a")) {
            return A;
        } else if (luettu.equals("B") || luettu.equals("b")) {
            return B;
        } else if (luettu.equals("C") || luettu.equals("c")) {
            return C;
        }
        return null;
    }
    private static void lisaa() {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = mikaJoukko();
        System.out.println("");
        System.out.print("Mikä luku lisätään? ");
        int lisLuku = lukija.nextInt();
        joukko.lisaa(lisLuku);
    }

    private static void yhdiste() {
        System.out.print("1. joukko? ");
        IntJoukko aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        IntJoukko bJoukko = mikaJoukko();
        IntJoukko yhdiste = IntJoukko.yhdiste(aJoukko, bJoukko);
        System.out.println("A yhdiste B = " + yhdiste.toString());
    }

    private static void leikkaus() {
        System.out.print("1. joukko? ");
        IntJoukko aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        IntJoukko bJoukko = mikaJoukko();
        IntJoukko leikkaus = IntJoukko.leikkaus(aJoukko, bJoukko);
        System.out.println("A leikkaus B = " + leikkaus.toString());
    }

    private static void erotus() {
        System.out.print("1. joukko? ");
        IntJoukko aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        IntJoukko bJoukko = mikaJoukko();
        IntJoukko c = IntJoukko.erotus(aJoukko, bJoukko);
        System.out.println("A erotus B = " + c.toString());
    }

    private static void poista() {
        System.out.print("Mistä joukosta? ");
        IntJoukko joukko = mikaJoukko();
        System.out.print("Mikä luku poistetaan? ");
        int lisLuku = Integer.parseInt(luku());
        joukko.poista(lisLuku);
    }

    private static void kuuluu() {
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = mikaJoukko();
        System.out.print("Mikä luku? ");
        int kysLuku = Integer.parseInt(luku());
        onkoJoukossa(joukko,kysLuku);
    }
    private static void onkoJoukossa(IntJoukko joukko,int kysLuku){
        boolean kuuluuko = joukko.kuuluu(kysLuku);
        if (kuuluuko) {
            System.out.println(kysLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(kysLuku + " ei kuulu joukkoon ");
        }
    }
    
    public static void alusta(){
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko."); 
    }
    
    public static void paaOhjelma(){
         while (true) {
             
            String luettu = luku();
           
            if (luettu.equals("lisää") || luettu.equals("li")) {
                lisaa();
            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
                poista();
            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
                kuuluu();
            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
                yhdiste();
            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
                leikkaus();
            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
                erotus();
            } else if (luettu.equalsIgnoreCase("A")) {
                System.out.println(A);
            } else if (luettu.equalsIgnoreCase("B")) {
                System.out.println(B);
            } else if (luettu.equalsIgnoreCase("C")) {
                System.out.println(C);
            } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            } else {
                System.out.println("Virheellinen komento! " + luettu);
            }
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
    }
    
    public static void main(String[] args) {
        alusta();
        paaOhjelma();
    }
}

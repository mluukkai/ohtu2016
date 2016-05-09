package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Kayttoliittyma kayttoliittyma = new TekstiUI();
        
        while (true) {
            kayttoliittyma.tulostaOhjeet();

            String vastaus = scanner.nextLine();
            
            if (! kayttoliittyma.pelinAloitus(vastaus)) {
                break;
            }
        }

    }
}

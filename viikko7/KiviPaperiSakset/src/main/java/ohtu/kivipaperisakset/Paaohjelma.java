package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.pelityyppi.PeliCreator;
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
                PeliCreator.luoPeli(1).pelaa();
            } else if (vastaus.endsWith("b")) {
                PeliCreator.luoPeli(2).pelaa();
            } else if (vastaus.endsWith("c")) {
                PeliCreator.luoPeli(3).pelaa();
            } else {
                break;
            }

        }

    }
}

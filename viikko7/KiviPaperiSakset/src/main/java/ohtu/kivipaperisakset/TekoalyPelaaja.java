package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author nikok
 */
public class TekoalyPelaaja extends Pelaaja{
    int siirto;

    public TekoalyPelaaja() {
        siirto = 0;
    }

    @Override
    public String getSiirto(String vastustajanEdellinenSiirto) {
        siirto++;
        siirto = siirto % 3;

        switch (siirto) {
            case 0:
                System.out.println("k");
                return "k";
            case 1:
                System.out.println("p");
                return "p";
            default:
                System.out.println("s");
                return "s";
        }
    }
}

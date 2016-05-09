package ohtu.kivipaperisakset;

import java.util.HashMap;
import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap vastaukset = new HashMap<String,KPS>();
        vastaukset.put("a", new KPSPelaajaVsPelaaja());
        vastaukset.put("b", new KPSTekoaly());
        vastaukset.put("c", new KPSParempiTekoaly());
        
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");
            System.out.println();
            String vastaus = scanner.nextLine();
            if(vastaukset.containsKey(vastaus)){
                KPS peli = (KPS)vastaukset.get(vastaus);
                peli.pelaa();
            }
            else{
                break;
            }
        }   

    }
}

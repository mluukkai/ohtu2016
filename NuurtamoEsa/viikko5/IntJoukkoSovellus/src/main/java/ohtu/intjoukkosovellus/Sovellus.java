package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static IntJoukko A, B, C;

    

    public static void main(String[] args) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        
        A.lisaa(10);
        A.lisaa(6);
        
        B.lisaa(7);
        B.lisaa(8);
        
        int[] lista=A.yhdiste(B).toIntArray();
        for(int i=0;i<lista.length;i++){
            System.out.println(lista[i]);
        }
        
    }
}

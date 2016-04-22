package ohtu.intjoukkosovellus;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntJoukkoTest {

    IntJoukko joukko;

    @Before
    public void setUp() {
        joukko = new IntJoukko();
        joukko.lisaa(10);
        joukko.lisaa(3);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void antaaVirheilmoituksenJosKonstruktorissaNegatiivinenKapasiteetti() {
        IntJoukko j = new IntJoukko(-1);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void antaaVirheilmoituksenJosKonstruktorissaNegatiivinenKapasiteettiJaKasvatusarvo() {
        IntJoukko j = new IntJoukko(-1, -1);
    }

    @Test
    public void lukujaLisattyMaara() {
        joukko.lisaa(4);
        assertEquals(3, joukko.mahtavuus());
    }

    @Test
    public void samaLukuMeneeJoukkoonVaanKerran() {
        joukko.lisaa(10);
        joukko.lisaa(3);
        assertEquals(2, joukko.mahtavuus());
    }

    @Test
    public void vainLisatytLuvutLoytyvat() {
        assertTrue(joukko.kuuluu(10));
        assertFalse(joukko.kuuluu(5));
        assertTrue(joukko.kuuluu(3));
    }

    @Test
    public void poistettuEiOleEnaaJoukossa() {
        joukko.poista(3);
        assertFalse(joukko.kuuluu(3));
        assertEquals(1, joukko.mahtavuus());
    }
    
    @Test
    public void palautetaanOikeaTaulukko() {
        int[] odotettu = {3, 55, 99};
        
        joukko.lisaa(55);
        joukko.poista(10);
        joukko.lisaa(99);

        int[] vastaus = joukko.toIntArray();
        Arrays.sort(vastaus);
        assertArrayEquals(odotettu, vastaus);
    }
    
    @Test
    public void poistoPalauttaaFalseJosLukuaEiTaulussa() {
        boolean odotettu = joukko.poista(7);
        assertFalse(odotettu);
        assertEquals(2, joukko.mahtavuus());
    }
    
    
    @Test
    public void toimiiKasvatuksenJalkeen(){
        int[] lisattavat = {1,2,4,5,6,7,8,9,11,12,13,14};
        for (int luku : lisattavat) {
            joukko.lisaa(luku);
        }
        assertEquals(14, joukko.mahtavuus());
        assertTrue(joukko.kuuluu(11));
        joukko.poista(11);
        assertFalse(joukko.kuuluu(11));
        assertEquals(13, joukko.mahtavuus());
    }
    
    @Test
    public void poistoToimiiJosPoistettavaViimeisena(){
        int[] lisattavat = {1,2,4,5,6,7,8,9,11,12,13,14};
        for (int luku : lisattavat) {
            joukko.lisaa(luku);
        }
        joukko.poista(14);
        assertFalse(joukko.kuuluu(14));
        assertEquals(13, joukko.mahtavuus());
    }
    
    @Test
    public void poistoToimiiJosPoistettavaKeskella(){
        int[] lisattavat = {1,2,4,5,6,7,8,9,11,12,13,14};
        for (int luku : lisattavat) {
            joukko.lisaa(luku);
        }
        joukko.poista(8);
        assertFalse(joukko.kuuluu(8));
        assertEquals(13, joukko.mahtavuus());
    }
    
    @Test
    public void yhdisteToimii(){
        int[] lisattavat1 = {1,2,4,5,6,7};
        int[] lisattavat2 = {8,9,11};
        IntJoukko joukko2 = new IntJoukko();
        for (int luku : lisattavat1) {
            joukko.lisaa(luku);
        }
        for (int luku : lisattavat2) {
            joukko2.lisaa(luku);
        }
        IntJoukko joukko3 = IntJoukko.yhdiste(joukko, joukko2);
        assertEquals(11, joukko3.mahtavuus());
    }
    
    @Test
    public void leikkausToimii(){
        int[] lisattavat1 = {1,2,4,5,6,7};
        int[] lisattavat2 = {5,6,7,11,12};
        IntJoukko joukko2 = new IntJoukko();
        for (int luku : lisattavat1) {
            joukko.lisaa(luku);
        }
        for (int luku : lisattavat2) {
            joukko2.lisaa(luku);
        }
        IntJoukko joukko3 = IntJoukko.leikkaus(joukko, joukko2);
        assertEquals(3, joukko3.mahtavuus());
    }
    
    @Test
    public void erotusToimii(){
        int[] lisattavat1 = {1,2,4,5,6,7};
        int[] lisattavat2 = {3,4,6,11,14};
        IntJoukko joukko2 = new IntJoukko();
        for (int luku : lisattavat1) {
            joukko.lisaa(luku);
        }
        for (int luku : lisattavat2) {
            joukko2.lisaa(luku);
        }
        IntJoukko joukko3 = IntJoukko.erotus(joukko, joukko2);
        assertEquals(5, joukko3.mahtavuus());
    }
    
    @Test
    public void toStringToimii(){
        assertEquals("{10, 3}", joukko.toString());
    }
    
    @Test
    public void toStringToimiiYhdenKokoiselleJoukolla(){
        joukko = new IntJoukko();
        joukko.lisaa(1);
        assertEquals("{1}", joukko.toString());
    }

    @Test
    public void toStringToimiiTyhjallaJoukolla(){
        joukko = new IntJoukko();
        assertEquals("{}", joukko.toString());
    }     
}

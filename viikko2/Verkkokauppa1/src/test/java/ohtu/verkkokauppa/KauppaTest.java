/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 */
public class KauppaTest {
    
    public KauppaTest() {
    }

    @Test
public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
    // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);

    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    // määritellään että viitegeneraattori palauttaa viitten 42
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 1
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, viite, pankki);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.tilimaksu("pekka", "12345");

    // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
    verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
    // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
}
    
    /**
     * Test of aloitaAsiointi method, of class Kauppa.
     */
    @Test
    public void testAloitaAsiointi() {
        // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);

    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    // määritellään että viitegeneraattori palauttaa viitten 42
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 1
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, viite, pankki);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.tilimaksu("pekka", "12345");

    // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
    //(String nimi, int viitenumero, String tililta, String tilille, int summa) {
    verify(pankki).tilisiirto((eq("pekka")), (eq(42)), (eq("12345")),(eq("33333-44455")),(eq(5)));   
    // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }
    
    @Test
    public void testAloitaAsiointiKaksiEriTuotetta() {
        // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);

    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    // määritellään että viitegeneraattori palauttaa viitten 42
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 1
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.saldo(2)).thenReturn(1); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
    when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "viinapullo", 10));

    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, viite, pankki);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);  
    k.lisaaKoriin(2);  
    k.tilimaksu("pekka", "12345");

    // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
    //(String nimi, int viitenumero, String tililta, String tilille, int summa) {
    verify(pankki).tilisiirto((eq("pekka")), (eq(42)), (eq("12345")),(eq("33333-44455")),(eq(15)));   
    // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }

     @Test
    public void testAloitaAsiointiKaksiSamaaTuotetta() {
        // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);

    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    // määritellään että viitegeneraattori palauttaa viitten 42
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 1
    when(varasto.saldo(1)).thenReturn(2); 
    
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 2));
    

    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, viite, pankki);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);  
    k.lisaaKoriin(1);  
    k.tilimaksu("pekka", "12345");

    // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
    //(String nimi, int viitenumero, String tililta, String tilille, int summa) {
    verify(pankki).tilisiirto((eq("pekka")), (eq(42)), (eq("12345")),(eq("33333-44455")),(eq(4)));   
    // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }
    
     
    @Test
    public void testAloitaAsiointiKaksiEriTuotettaJoistaToinenLoppu() {
        // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);

    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    // määritellään että viitegeneraattori palauttaa viitten 42
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 1
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.saldo(2)).thenReturn(0); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
    when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "viinapullo", 10));

    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, viite, pankki);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);  
    k.lisaaKoriin(2);  
    k.tilimaksu("pekka", "12345");

    // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
    //(String nimi, int viitenumero, String tililta, String tilille, int summa) {
    verify(pankki).tilisiirto((eq("pekka")), (eq(42)), (eq("12345")),(eq("33333-44455")),(eq(5)));   
    // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }

      @Test
    public void testAloitaAsiointiToistamiseenIlmanEdellisenAsiakkaanOstoksia() {
        // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);

    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    // määritellään että viitegeneraattori palauttaa viitten 42
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 1
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.saldo(2)).thenReturn(10); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
    when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "viinapullo", 10));

    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, viite, pankki);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);  
    k.lisaaKoriin(1);  
    k.tilimaksu("pekka", "12345");

    verify(pankki).tilisiirto((eq("pekka")), (eq(42)), (eq("12345")),(eq("33333-44455")),(eq(10)));   
    
    k.aloitaAsiointi();
    k.lisaaKoriin(2);  
    k.lisaaKoriin(2);  
    k.tilimaksu("pekka", "12345");
    
    // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
    //(String nimi, int viitenumero, String tililta, String tilille, int summa) {
    verify(pankki).tilisiirto((eq("pekka")), (eq(42)), (eq("12345")),(eq("33333-44455")),(eq(20)));   
    // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }

      @Test
    public void testPankkiPyytääUudenViitenumeronJokaiselleMaksutapahtumalle() {
        // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);

    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    // määritellään että viitegeneraattori palauttaa viitten 42
   // when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 1
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.saldo(2)).thenReturn(10); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
    when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "viinapullo", 10));

    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, viite, pankki);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);  
    k.lisaaKoriin(1);  
    k.tilimaksu("pekka", "12345");

    verify(viite, times(1)).uusi();
    //verify(pankki).tilisiirto((eq("pekka")), (eq(42)), (eq("12345")),(eq("33333-44455")),(eq(10)));   
    
    k.aloitaAsiointi();
    k.lisaaKoriin(2);  
    k.lisaaKoriin(2);  
    k.tilimaksu("pekka", "12345");
    verify(viite, times(2)).uusi();
    // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
    //(String nimi, int viitenumero, String tililta, String tilille, int summa) {
//    verify(pankki).tilisiirto((eq("pekka")), (eq(42)), (eq("12345")),(eq("33333-44455")),(eq(20)));   
    // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }
    
    
     @Test
    public void testVarastosaldojenToimivuudenVarmistus() {
        // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);

    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    // määritellään että viitegeneraattori palauttaa viitten 42
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 1
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.saldo(2)).thenReturn(0); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
    when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "viinapullo", 10));

    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, viite, pankki);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);  
    k.lisaaKoriin(2);  
    k.poistaKorista(1);  
    k.tilimaksu("pekka", "12345");

    // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
    //(String nimi, int viitenumero, String tililta, String tilille, int summa) {
    verify(pankki).tilisiirto((eq("pekka")), (eq(42)), (eq("12345")),(eq("33333-44455")),(eq(0)));   
    // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }
}

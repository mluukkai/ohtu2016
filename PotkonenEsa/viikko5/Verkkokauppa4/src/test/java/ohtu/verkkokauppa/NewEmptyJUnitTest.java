/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 *
 * @author Esa Potkonen
 */
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
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
    when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "piima", 6));

    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.tilimaksu("pekka", "12345");

    // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
    verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
    // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    // Oikea maksaja
    verify(pankki).tilisiirto(eq("pekka"), anyInt(),eq("12345"), anyString(),eq(5));   
    
}
@Test
public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan2() {
    // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);

    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    // määritellään että viitegeneraattori palauttaa viitten 42
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 1
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
    when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "piima", 6));

    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.lisaaKoriin(2);     // ostetaan tuotetta numero 2 eli piimää
    k.tilimaksu("pekka", "12345");

    verify(pankki).tilisiirto(eq("pekka"), anyInt(),eq("12345"), anyString(),anyInt());   
    
}
@Test
public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan3() {
    // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);

    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    // määritellään että viitegeneraattori palauttaa viitten 42
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 1
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
    when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "piima", 6));

    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.tilimaksu("pekka", "12345");

    verify(pankki).tilisiirto(eq("pekka"), anyInt(),eq("12345"), anyString(),eq(10));   
    
}
@Test
public void viiteUusi() {
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
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.lisaaKoriin(6);     // ostetaan tuotetta numero 6 eli koffi joka loppu
    k.tilimaksu("pekka", "12345");

    verify(pankki).tilisiirto(eq("pekka"), anyInt(),eq("12345"), anyString(),eq(5));   

    // tehdään ostokset toiseen kertaan
    k.aloitaAsiointi();
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.lisaaKoriin(6);     // ostetaan tuotetta numero 6 eli koffi joka loppu
    k.tilimaksu("pekka", "12345");

    verify(viite, times(2)).uusi();
   
}
@Test
public void hintaMuutos() {
    // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);

    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    // määritellään että viitegeneraattori palauttaa viitten 42
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);

    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.tilimaksu("pekka", "12345");

    assertEquals(5, varasto.haeTuote(1).getHinta());

  
}
@Test
public void save() {
    // luodaan ensin mock-oliot
    Kirjanpito kp = new KirjanpitoImpl();
    Pankki pankki = new PankkiImpl(kp);
    Viitegeneraattori viite = new ViitegeneraattoriImpl();
    Varasto varasto = new VarastoImpl(kp);
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.tilimaksu("pekka", "12345");

    assertEquals(3, varasto.haeTuote(1).getHinta());
 
}
}

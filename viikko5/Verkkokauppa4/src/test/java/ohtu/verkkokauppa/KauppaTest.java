/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author jkostet
 */
public class KauppaTest {
    public KauppaTest() {
    }
    
    @Before
    public void setUp() {
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
        Kauppa k = new Kauppa(varasto, pankki, viite);              

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);
    }
    
    @Test
    public void varastossaOlevienEriTuotteidenOstoOnnistuu() {
//      aloitetaan asiointi, koriin lisätään kaksi eri tuotetta, joita varastossa on ja suoritetaan ostos. varmistettava että kutsutaan pankin metodia tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla
        Pankki pankki = mock(Pankki.class);
        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).thenReturn(42);

        Varasto varasto = mock(Varasto.class);
        when(varasto.saldo(1)).thenReturn(3);
        when(varasto.saldo(2)).thenReturn(3);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "koodi", 3));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "skripti", 5));
        
        Kauppa k = new Kauppa(varasto, pankki, viite);

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("mluukkai", "1337");

        verify(pankki).tilisiirto("mluukkai", 42, "1337", "33333-44455", 8);
    }
    
    @Test
    public void VarastossaOlevanTuotteenUseanKappaleenOstoOnnistuu() {
//      aloitetaan asiointi, koriin lisätään kaksi samaa tuotetta jota on varastossa tarpeeksi ja suoritetaan ostos. varmistettava että kutsutaan pankin metodia tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla
        Pankki pankki = mock(Pankki.class);
        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).thenReturn(42);

        Varasto varasto = mock(Varasto.class);
        when(varasto.saldo(1)).thenReturn(3);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "koodi", 3));
        
        Kauppa k = new Kauppa(varasto, pankki, viite);

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("mluukkai", "1337");

        verify(pankki).tilisiirto("mluukkai", 42, "1337", "33333-44455", 6);
    }
    
    @Test
    public void ostetaanTuoteJotaOnVarastossaMutteiTuotettaJotaEiOle() {
//      aloitetaan asiointi, koriin lisätään tuote jota on varastossa tarpeeksi ja tuote joka on loppu ja suoritetaan ostos. varmistettava että kutsutaan pankin metodia tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla
        Pankki pankki = mock(Pankki.class);
        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).thenReturn(42);

        Varasto varasto = mock(Varasto.class);
        when(varasto.saldo(1)).thenReturn(3);
        when(varasto.saldo(2)).thenReturn(0);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "koodi", 3));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "skripti", 5));
        
        Kauppa k = new Kauppa(varasto, pankki, viite);

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("mluukkai", "1337");

        verify(pankki).tilisiirto("mluukkai", 42, "1337", "33333-44455", 3);
    }
    
    @Test
    public void edellinenOstosEiVaikutaSeuraavanHintaan() {
        //      varmistettava, että metodin aloitaAsiointi kutsuminen nollaa edellisen ostoksen tiedot (eli edellisen ostoksen hinta ei näy uuden ostoksen hinnassa), katso tarvittaessa apua projektin MockitoDemo testeistä!
        Pankki pankki = mock(Pankki.class);
        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).
                thenReturn(42).
                thenReturn(43).
                thenReturn(44);

        Varasto varasto = mock(Varasto.class);
        when(varasto.saldo(1)).thenReturn(3);
        when(varasto.saldo(2)).thenReturn(3);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "koodi", 3));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "skripti", 5));
        
        Kauppa k = new Kauppa(varasto, pankki, viite);

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("mluukkai", "1337");

        verify(pankki).tilisiirto("mluukkai", 42, "1337", "33333-44455", 8);
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("arto", "010101");
        
        verify(pankki).tilisiirto("arto", 43, "010101", "33333-44455", 3);
    }
    
    @Test
    public void kauppaPyytaaUudenViitenumeronJokaiselleMaksutapahtumalle() {
//      varmistettava, että kauppa pyytää uuden viitenumeron jokaiselle maksutapahtumalle, katso tarvittaessa apua projektin MockitoDemo testeistä!
        // no tää ny tulee tos yllä D:
    }
    
    @Test
    public void tuotteenPoistaminenKortistaPalauttaaSenVarastoon() {
        Pankki pankki = mock(Pankki.class);
        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).
                thenReturn(42).
                thenReturn(43).
                thenReturn(44);

        Varasto varasto = mock(Varasto.class);
        when(varasto.saldo(1)).thenReturn(3);
        when(varasto.saldo(2)).thenReturn(3);
        Tuote t = new Tuote(1, "koodi", 3);
        when(varasto.haeTuote(1)).thenReturn(t);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "skripti", 5));
        
        Kauppa k = new Kauppa(varasto, pankki, viite);

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.poistaKorista(2);
        k.poistaKorista(1);
        // testia ajaettaessa huomataan, ettei korista poistaminen toimi tassa?
        k.tilimaksu("mluukkai", "1337");
        
        verify(pankki).tilisiirto("mluukkai", 42, "1337", "33333-44455", 3);
        verify(varasto, times(1)).palautaVarastoon(t);
    }
            
}

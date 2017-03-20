package ohtu.verkkokauppa;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class KauppaTest {
    
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
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
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

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);   
    }

    @Test  
    public void kutsutaanMetodiaTilisiirtoOikeinKaksiEriTuotettaOstaessa() {
        
        Pankki pankki = mock(Pankki.class);
        
        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).thenReturn(42);
        
        Varasto varasto = mock(Varasto.class);
        
        //Tuote 1
        when(varasto.saldo(1)).thenReturn(3);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "kalja", 2));
        
        //Tuote 2
        when(varasto.saldo(2)).thenReturn(4);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipä", 6));
        
        Kauppa k = new Kauppa(varasto, pankki, viite);
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("jarmo", "1234");
        
        verify(pankki).tilisiirto("jarmo", 42, "1234", "33333-44455", 8);
    }
    
    
    @Test  
    public void kutsutaanMetodiaTilisiirtoOikeinKaksiSamaaTuotettaOstaessa() {
        
        Pankki pankki = mock(Pankki.class);
        
        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).thenReturn(42);
        
        Varasto varasto = mock(Varasto.class);
        
        //Tuote 1
        when(varasto.saldo(1)).thenReturn(3);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "kalja", 2));
        
        Kauppa k = new Kauppa(varasto, pankki, viite);
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("jarmo", "1234");
        
        verify(pankki).tilisiirto("jarmo", 42, "1234", "33333-44455", 4);
    }
    
    
    @Test  
    public void kutsutaanMetodiaTilisiirtoOikeinKaksiEriTuotettaOstaessaKunToinenOnLoppu() {
        Pankki pankki = mock(Pankki.class);
        
        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).thenReturn(42);
        
        Varasto varasto = mock(Varasto.class);
        
        //Tuote 1
        when(varasto.saldo(1)).thenReturn(0);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "kalja", 2));
        
        //Tuote 2
        when(varasto.saldo(2)).thenReturn(4);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipä", 6));
        
        Kauppa k = new Kauppa(varasto, pankki, viite);
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("jarmo", "1234");
        
        verify(pankki).tilisiirto("jarmo", 42, "1234", "33333-44455", 6);
    }
    
    @Test  
    public void aloitaAsiointiNollaaEdellisenOstoksenTiedot() {
        
        Pankki pankki = mock(Pankki.class);
        
        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).thenReturn(42);
        
        Varasto varasto = mock(Varasto.class);
        
        //Tuote 1
        when(varasto.saldo(1)).thenReturn(3);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "kalja", 2));
        
        //Tuote 2
        when(varasto.saldo(2)).thenReturn(4);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipä", 6));
        
        Kauppa k = new Kauppa(varasto, pankki, viite);
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("jarmo", "1234");
        
        verify(pankki).tilisiirto("jarmo", 42, "1234", "33333-44455", 8);
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("jorma", "12345");
        
        verify(pankki).tilisiirto("jorma", 42, "12345", "33333-44455", 2);
    }
    
    @Test  
    public void saadaanJokaKertaUusiViitenumero() {
        
        Pankki pankki = mock(Pankki.class);
        
        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).
                thenReturn(1).
                thenReturn(2).
                thenReturn(3);
        
        Varasto varasto = mock(Varasto.class);
        
        //Tuote 1
        when(varasto.saldo(1)).thenReturn(3);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "kalja", 2));
        
        Kauppa k = new Kauppa(varasto, pankki, viite);
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("jarmo", "1234");
        
        verify(pankki).tilisiirto("jarmo", 1, "1234", "33333-44455", 2);
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("jorma", "12345");
        
        verify(pankki).tilisiirto("jorma", 2, "12345", "33333-44455", 2);
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("jere", "123456");
        
        verify(pankki).tilisiirto("jere", 3, "123456", "33333-44455", 2);
    }
    
    @Test
    public void ostosPoistuuOstoskorista() {
        // luodaan ensin mock-oliot
        Pankki pankki = mock(Pankki.class);

        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        // määritellään että viitegeneraattori palauttaa viitten 42
        Varasto varasto = mock(Varasto.class);
        
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 1
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        // sitten testattava kauppa 
        Kauppa k = new Kauppa(varasto, pankki, viite);              

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.poistaKorista(1);
        
        verify(varasto, times(1)).palautaVarastoon(any(Tuote.class));
    }
    
}

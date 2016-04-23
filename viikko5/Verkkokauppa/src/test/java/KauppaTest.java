import ohtu.verkkokauppa.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;


public class KauppaTest {
    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    Kauppa kauppa;
    
    public KauppaTest() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
        kauppa = new Kauppa(varasto, pankki, viite);
    }
    
    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);
        
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
    public void ostetaanYksiTuote(){
        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "Maito", 5));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("Kristian Lauttamus", "Testi");
        
        verify(pankki).tilisiirto("Kristian Lauttamus", 42, "Testi", "33333-44455", 5);
        // String nimi, int viitenumero, String tililta, String tilille, int summa
    }
    
    @Test
    public void ostetaanUseampiTuote(){
        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "Maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Lehmä", 5));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Testaaja", "Testitili");
        
        verify(pankki).tilisiirto("Testaaja", 42, "Testitili", "33333-44455", 10);
    }
    
    @Test
    public void ostetaanKaksiSamaaTuotetta(){
        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "Maito", 5));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("Testaaja", "Testitili");
        
        verify(pankki).tilisiirto("Testaaja", 42, "Testitili", "33333-44455", 10);
    }
    
    @Test
    public void ostetaanKaksiTuotettaJoistaToinenOnLoppu(){
        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(0);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "Maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Lehmä", 5));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Testaaja", "Testitili");
        
        verify(pankki).tilisiirto("Testaaja", 42, "Testitili", "33333-44455", 5);
    }
    
    @Test
    public void aloitusNollaaOstoprosessin(){
        when(viite.uusi()).
                thenReturn(1).
                thenReturn(2).
                thenReturn(3);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "Maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Lehmä", 5));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Testaaja", "Testitili");
        
        verify(pankki).tilisiirto("Testaaja", 1, "Testitili", "33333-44455", 10);
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("Testaaja", "Testitili");
        
        verify(pankki).tilisiirto("Testaaja", 2, "Testitili", "33333-44455", 5);
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Testaaja", "Testitili");
        
        verify(pankki).tilisiirto("Testaaja", 3, "Testitili", "33333-44455", 5);
    }
    
    @Test
    public void uusiViitePyydetaanAina(){
        when(viite.uusi()).
                thenReturn(1).
                thenReturn(2).
                thenReturn(3);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "Maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Lehmä", 5));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Testaaja", "Testitili");
        
        verify(viite.uusi(), times(1));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("Testaaja", "Testitili");
        
        verify(viite.uusi(), times(2));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Testaaja", "Testitili");
        
        verify(viite.uusi(), times(3));
    }
}

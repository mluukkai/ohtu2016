package ohtu.verkkokauppa;

import org.junit.*;
import static org.mockito.Mockito.*;

public class KauppaTest {
    
    Pankki pankki;
    Varasto varasto;
    Viitegeneraattori viite;
    Kauppa k;
    
    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        varasto = mock(Varasto.class);
        viite = mock(Viitegeneraattori.class);
        k = new Kauppa(varasto, pankki, viite);
    }

    @Test
    public void tilisiirtoaKutsutaanOikeillaArgumenteilla1() {
        when(viite.uusi()).thenReturn(40);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        
        String a = "pekka";
        String t = "1234";
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu(a,t);
        
        verify(pankki).tilisiirto(a, viite.uusi(), t, "33333-44455", 5);
        
    }
    
    @Test
    public void tilisiirtoaKutsutaanOikeillaArgumenteilla2() {
        when(viite.uusi()).thenReturn(40);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipä", 4));
        
        String a = "pekka";
        String t = "1234";
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu(a,t);
        
        verify(pankki).tilisiirto(a, viite.uusi(), t, "33333-44455", 9);
    }
    
    @Test
    public void tilisiirtoaKutsutaanOikeillaArgumenteilla3() {
        when(viite.uusi()).thenReturn(40);
        when(varasto.saldo(1)).thenReturn(2);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        
        String a = "pekka";
        String t = "1234";
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu(a,t);
        
        verify(pankki).tilisiirto(a, viite.uusi(), t, "33333-44455", 10);
    }
    
    @Test
    public void tilisiirtoaKutsutaanOikeillaArgumenteilla4() {
        when(viite.uusi()).thenReturn(40);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(2)).thenReturn(0);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipä", 4));
        
        String a = "pekka";
        String t = "1234";
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu(a,t);
        
        verify(pankki).tilisiirto(a, viite.uusi(), t, "33333-44455", 5);
    }
    
    @Test
    public void aloitaAsiointiNollaaEdellisetOstokset() {
        when(viite.uusi()).thenReturn(40);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipä", 4));
        
        String a = "pekka";
        String t = "1234";
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu(a, t);
        verify(pankki).tilisiirto(a, viite.uusi(), t, "33333-44455", 5);
        
        k.aloitaAsiointi();
        k.lisaaKoriin(2);
        k.tilimaksu(a, t);
        verify(pankki).tilisiirto(a, viite.uusi(), t, "33333-44455", 4);
    }
    
    @Test
    public void uusiViitenumeroUudellaTapahtumalla() {
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipä", 4));
        String a = "pekka";
        String t = "1234";
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu(a, t);
        k.aloitaAsiointi();
        k.lisaaKoriin(2);
        k.tilimaksu(a, t);
        verify(viite, times(2)).uusi(); 
   }
    
   @Test
   public void koristaPoistoToimii() {
        when(viite.uusi()).thenReturn(40);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipä", 4));
        String a = "pekka";
        String t = "1234";
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.poistaKorista(1);
        k.tilimaksu(a, t);
        
        verify(pankki).tilisiirto(a, viite.uusi(), t, "33333-44455", 4);
   }
}

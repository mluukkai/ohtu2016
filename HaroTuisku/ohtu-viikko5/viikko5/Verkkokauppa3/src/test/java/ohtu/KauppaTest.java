package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
public class KauppaTest {

    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;

    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
    }

    @Test
    public void ostoksenPaatyttyaKutsutaanPankinMetodiaTilisiirto() {
        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "kala", 5));

        Kauppa k = new Kauppa(varasto, pankki, viite);

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("bob", "12345");

        verify(pankki).tilisiirto("bob", 42, "12345", "33333-44455", 5);
    }
    
    @Test
    public void ostosKahdellaEriTuotteella() {
        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "kala", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "ruisleipä", 7));

        Kauppa k = new Kauppa(varasto, pankki, viite);

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("bob", "12345");

        verify(pankki).tilisiirto("bob", 42, "12345", "33333-44455", 12);
    }
    
    @Test
    public void ostosKahdellaSamallaTuotteella() {
        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "kala", 5));

        Kauppa k = new Kauppa(varasto, pankki, viite);

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("bob", "12345");

        verify(pankki).tilisiirto("bob", 42, "12345", "33333-44455", 10);
    }
    
    @Test
    public void ostosKahdellaEriTuotteellaToinenLoppu() {
        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(0);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "kala", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "ruisleipä", 7));

        Kauppa k = new Kauppa(varasto, pankki, viite);

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("bob", "12345");

        verify(pankki).tilisiirto("bob", 42, "12345", "33333-44455", 5);
    }
    
    @Test
    public void aloitaAsiointiNollaaTiedot() {
        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "kala", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "ruisleipä", 7));

        Kauppa k = new Kauppa(varasto, pankki, viite);

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("bob", "12345");
        
        verify(pankki).tilisiirto("bob", 42, "12345", "33333-44455", 12);
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("bob", "12345");

        verify(pankki).tilisiirto("bob", 42, "12345", "33333-44455", 5);
    }
    
    @Test
    public void uusiViiteJokaKerta() {
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "kala", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "ruisleipä", 7));

        Kauppa k = new Kauppa(varasto, pankki, viite);

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("bob", "12345");
        
        verify(viite, times(1)).uusi();
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("bob", "12345");

        verify(viite, times(2)).uusi();
    }
    
    @Test
    public void poistoKorista() {
        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "kala", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "ruisleipä", 7));

        Kauppa k = new Kauppa(varasto, pankki, viite);

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.poistaKorista(2);
        
        Tuote t = varasto.haeTuote(2);
        verify(varasto, times(1)).palautaVarastoon(t);
        k.tilimaksu("bob", "12345");
        verify(pankki).tilisiirto("bob", 42, "12345", "33333-44455", 12);
    }

}
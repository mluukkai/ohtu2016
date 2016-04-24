
import ohtu.verkkokauppa.Kauppa;
import ohtu.verkkokauppa.Ostoskori;
import ohtu.verkkokauppa.Pankki;
import ohtu.verkkokauppa.Tuote;
import ohtu.verkkokauppa.Varasto;
import ohtu.verkkokauppa.Viitegeneraattori;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Matchers;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class KauppaTest {

    Kauppa kauppa;
    Ostoskori ostoskori;
    Pankki pankki;
    Varasto varasto;
    Viitegeneraattori viitegeneraattori;

    public KauppaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viitegeneraattori = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
    }

    @Test
    public void pankinMetodiaTilisiirtoKutsutaanOikeillaParametreillKunYksiTuoteKorissa() {
        when(viitegeneraattori.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        Kauppa kauppa = new Kauppa(varasto, pankki, viitegeneraattori);

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "5555");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("5555"), eq("33333-44455"), eq(5));
    }

    @Test
    public void pankinMetodiaTilisiirtoKutsutaanOikeillaParametreillaKunKaksiEriTuotettaKorissa() {
        when(viitegeneraattori.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "karkki", 3));

        Kauppa kauppa = new Kauppa(varasto, pankki, viitegeneraattori);

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("pekka", "5555");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("5555"), eq("33333-44455"), eq(8));

    }

    @Test
    public void pankinMetodiaTilisiirtoKutsutaanOikeillaParametreillaKunKaksiSamaaTuotettaKorissa() {
        when(viitegeneraattori.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        Kauppa kauppa = new Kauppa(varasto, pankki, viitegeneraattori);

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "5555");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("5555"), eq("33333-44455"), eq(10));
    }

    @Test
    public void pankinMetodiaTilisiirtoKutsutaanOikeillaParametreillaKunYksiTuoteKorissaJaYhdestaSaldoLoppu() {
        when(viitegeneraattori.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(0);
        when(varasto.saldo(2)).thenReturn(1);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "karkki", 3));

        Kauppa kauppa = new Kauppa(varasto, pankki, viitegeneraattori);

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("pekka", "5555");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("5555"), eq("33333-44455"), eq(3));
    }

    @Test
    public void aloitaAsiointiMetodinKutsuNollaaOstokset() {
        when(viitegeneraattori.uusi()).
                thenReturn(42);
        when(varasto.saldo(1)).
                thenReturn(10);
        when(varasto.haeTuote(1)).
                thenReturn(new Tuote(1, "maito", 5));

        Kauppa kauppa = new Kauppa(varasto, pankki, viitegeneraattori);

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);

        kauppa.tilimaksu("pekka", "5555");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("5555"), eq("33333-44455"), eq(5));

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);

        kauppa.tilimaksu("jari", "4555");
        verify(pankki).tilisiirto(eq("jari"), eq(42), eq("4555"), eq("33333-44455"), eq(5));
    }

    @Test
    public void kauppaAntaaUudenViitteenJokaiselleMaksulle() {
        when(viitegeneraattori.uusi()).
                thenReturn(43).
                thenReturn(44);
        when(varasto.saldo(1)).
                thenReturn(10);
        when(varasto.haeTuote(1)).
                thenReturn(new Tuote(1, "maito", 5));

        Kauppa kauppa = new Kauppa(varasto, pankki, viitegeneraattori);

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);

        kauppa.tilimaksu("pekka", "5555");

        verify(pankki).tilisiirto(eq("pekka"), eq(43), eq("5555"), eq("33333-44455"), eq(5));

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);

        kauppa.tilimaksu("jari", "4555");
        verify(pankki).tilisiirto(eq("jari"), eq(44), eq("4555"), eq("33333-44455"), eq(5));

    }
    
    @Test
    public void poistaKoristaMetodinKutsuPoistaaOstoksenKoristat() {
    when(viitegeneraattori.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        Kauppa kauppa = new Kauppa(varasto, pankki, viitegeneraattori);

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        kauppa.poistaKorista(1);
//        kauppa.tilimaksu("pekka", "5555");

        verify(varasto).palautaVarastoon(new Tuote(1, "maito", 5));
    }
    
    @After
    public void tearDown() {
    }
}

package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;


public class KauppaTest {
    Kauppa kauppa;
    Pankki pankki;
    Viitegeneraattori viitegen;
    Varasto varasto;
    
    
    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viitegen = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
        kauppa = new Kauppa();
    }
    
    @Test
    public void testAloitaAsiointi() {
        System.out.println("aloitaAsiointi");
        Kauppa instance = new Kauppa();
        instance.aloitaAsiointi();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of poistaKorista method, of class Kauppa.
     */
    @Test
    public void testPoistaKorista() {
        System.out.println("poistaKorista");
        int id = 0;
        Kauppa instance = new Kauppa();
        instance.poistaKorista(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lisaaKoriin method, of class Kauppa.
     */
    @Test
    public void testLisaaKoriin() {
        System.out.println("lisaaKoriin");
        int id = 0;
        Kauppa instance = new Kauppa();
        instance.lisaaKoriin(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tilimaksu method, of class Kauppa.
     */
    @Test
    public void testTilimaksu() {
        System.out.println("tilimaksu");
        String nimi = "";
        String tiliNumero = "";
        Kauppa instance = new Kauppa();
        boolean expResult = false;
        boolean result = instance.tilimaksu(nimi, tiliNumero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

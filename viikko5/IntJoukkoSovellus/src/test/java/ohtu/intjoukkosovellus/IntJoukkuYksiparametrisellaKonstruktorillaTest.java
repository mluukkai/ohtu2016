
package ohtu.intjoukkosovellus;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class IntJoukkuYksiparametrisellaKonstruktorillaTest extends IntJoukkoTest {
    
    @Before
    @Override
    public void setUp() {
        joukko = new IntJoukko(3);
        joukko.lisaa(10);
        joukko.lisaa(3);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testaaNegatiivinenKapasiteetti(){
        joukko = new IntJoukko(-5);
    }
    
    // perii kaikki testit luokasta IntJoukkoTest
}

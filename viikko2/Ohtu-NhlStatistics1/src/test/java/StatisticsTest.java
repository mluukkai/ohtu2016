/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ohtuesimerkki.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juhokyyh
 */
public class StatisticsTest {
    Statistics stats;
    
    private final Player semenko = new Player("Semenko", "EDM", 4, 12);
    private final Player lemieux = new Player("Lemieux", "PIT", 45, 54);
    private final Player kurri = new Player("Kurri", "EDM", 37, 53);
    private final Player yzerman = new Player("Yzerman", "DET", 42, 56);
    private final Player gretzky = new Player("Gretzky", "EDM", 35, 89);
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(semenko);
            players.add(lemieux);
            players.add(kurri);
            players.add(yzerman);
            players.add(gretzky);

            return players;
        }
    };
    
    public StatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void loytaaPelaajan() {
        assertEquals(semenko,stats.search("Semenko"));
    }
    
    @Test
    public void palauttaaNullJosEiLoydy() {
        assertNull(stats.search("fakename"));
    }
    
    @Test
    public void loytaaTiiminPelaajat() {
        List<Player> test = stats.team("EDM");
        
        assertEquals(3, test.size());
        assertTrue(test.contains(semenko));
        assertTrue(test.contains(kurri));
        assertTrue(test.contains(gretzky));
    }
    
    @Test
    public void topScorersMetodiToimii() {
        List<Player> test = stats.topScorers(3);
        
        assertEquals(3, test.size());
        assertEquals(gretzky, test.get(0));
        assertEquals(lemieux, test.get(1));
        assertEquals(yzerman, test.get(2));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

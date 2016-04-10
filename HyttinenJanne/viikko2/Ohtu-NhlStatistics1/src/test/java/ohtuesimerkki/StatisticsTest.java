/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hyttijan
 */
public class StatisticsTest {
    Statistics stats;
    
    Reader readerStub;
    
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
        readerStub = new Reader() {

            @Override
            public List<Player> getPlayers() {
                ArrayList<Player> players = new ArrayList<Player>();
                players.add(new Player("Semenko", "EDM", 4, 12));
                players.add(new Player("Lemieux", "PIT", 45, 54));
                players.add(new Player("Kurri",   "EDM", 37, 53));
                players.add(new Player("Yzerman", "DET", 42, 56));
                players.add(new Player("Gretzky", "EDM", 35, 89));

                return players;
            }
        };
        stats = new Statistics(readerStub);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of search method, of class Statistics.
     */
    @Test
    public void testSearch() {
        String test = "Semenko";
        Player player = stats.search(test);
        
        assertNotNull(player);
    }
    @Test
    public void testSearch2() {
        String test = "Semenko1";
        Player player = stats.search(test);
        assertNull(player);
    }


    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void testTeam() {
       ArrayList<Player> edm = (ArrayList<Player>)stats.team("EDM");
       assertEquals(edm.get(0).getName(),"Semenko");
       assertEquals(edm.get(1).getName(),"Kurri");
       assertEquals(edm.get(2).getName(),"Gretzky");
       
    }
      
    @Test
    public void testTeam2() {
       ArrayList<Player> edm = (ArrayList<Player>)stats.team("EDM");
       assertFalse(edm.get(0).getName().equals("Yzerman"));
       
    }

    /**
     * Test of topScorers method, of class Statistics.
     */
    @Test
    public void testTopScorers() {
       List<Player> topScorers = stats.topScorers(3);
       assertEquals(topScorers.get(0).getName(),"Gretzky");
       assertEquals(topScorers.get(1).getName(),"Lemieux");
       assertEquals(topScorers.get(2).getName(),"Yzerman");
       assertTrue(topScorers.size()==4);
    }
    public void testTopScorers2() {
       List<Player> topScorers = stats.topScorers(4);
       assertFalse(topScorers.get(3).getName().equals("Semenko"));
    }
    
}

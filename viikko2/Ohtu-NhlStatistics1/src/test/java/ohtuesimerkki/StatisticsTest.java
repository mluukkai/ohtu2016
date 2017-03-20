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
 * @author ile
 */
public class StatisticsTest {
    
    public StatisticsTest() {
    }
    
    Statistics stats;
    Reader readerStub = new Reader() {
        
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
    public void playerSearchTest(){
        
        assertEquals(4, stats.search("Semenko").getGoals());
    }
    @Test
    public void playerNotFound(){
        assertEquals(null, stats.search("ASD"));
    }
    @Test
    public void teamSearchReturnsPlayers(){
        assertEquals(3, stats.team("EDM").size());
        assertEquals(0, stats.team("ASD").size());
        assertEquals(1, stats.team("PIT").size());
    }
    @Test
    public void topScorerTest(){
        List<Player> list = stats.topScorers(4);
        assertEquals(5, list.size());
        assertEquals("Gretzky", list.get(0).getName());
    }

    
}

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
 * @author rimi
 */
public class StatisticsTest {
    Statistics stats;
    
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
        Reader readerStub = new Reader() {
            @Override
            public List<Player> getPlayers() {
                ArrayList<Player> players = new ArrayList<Player>();
                
                players.add(new Player("Semenko", "EDM", 4, 12));
                players.add(new Player("Lemieux", "PIT", 45, 54));
                players.add(new Player("Kurri", "EDM", 37, 53));
                players.add(new Player("Yzerman", "DET", 42, 56));
                players.add(new Player("Gretzky", "EDM", 35, 89));
                
                return players;
            }
        };
        
        this.stats = new Statistics(readerStub);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void validSearch() {
        assertNotNull(stats.search("Kurri"));
    }
    
    @Test
    public void invalidSearch() {
        assertNull(stats.search("nonexisting"));
    }

    @Test
    public void validTeam() {
        List<Player> team = stats.team("EDM");
        assertNotNull(team);
        assertFalse(team.isEmpty());
        assertEquals(3, team.size());
        assertEquals("EDM", team.get(0).getTeam());
    }
    
    @Test
    public void invalidTeam() {
        List<Player> team = stats.team("EDMATE");
        assertNotNull(team);
        assertTrue(team.isEmpty());
    }
    
    @Test
    public void topTwoScores() {
        List<Player> scores = stats.topScorers(2);
        assertFalse(scores.isEmpty());
        assertEquals("Gretzky", scores.get(0).getName());
        assertEquals("Lemieux", scores.get(1).getName());
    }
}

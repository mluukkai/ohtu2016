package ohtuesimerkki;

import java.util.List;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StaticsticsTest {
    Statistics stats;
    
    Reader readerStub = new Reader() {
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
    
    public StaticsticsTest() {
        stats = new Statistics(readerStub);
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void findsPlayers() {
        assertNotNull(stats.search("Semenko"));
        assertNotNull(stats.search("Lemieux"));
        assertNotNull(stats.search("Yzerman"));
    }
    @Test
    public void wontFindNonExistingPlayers() {
        assertNull(stats.search("gaegewrg"));
    }

    @Test
    public void findTeam() {
        List players = stats.team("EDM");
        
        assertEquals(players.size(), 3);
        assertTrue(players.contains(stats.search("Semenko")));
        assertTrue(players.contains(stats.search("Kurri")));
        assertTrue(players.contains(stats.search("Gretzky")));
    }
    
    @Test
    public void nonExistingTeamHasZeroPlayers() {
        List players = stats.team("GEWRG");
        assertEquals(players.size(), 0);
    }
    
    @Test
    public void getTopScorer() {
        List players = stats.topScorers(1);
        assertEquals(players.size(), 1);
        assertTrue(players.contains(stats.search("Gretzky")));
    }
    
    @Test
    public void getZeroTopScorers() {
        List players = stats.topScorers(0);
        assertEquals(players.size(), 0);
    }
}

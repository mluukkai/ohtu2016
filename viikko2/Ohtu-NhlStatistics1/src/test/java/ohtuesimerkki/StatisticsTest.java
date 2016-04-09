package ohtuesimerkki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {

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
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void testaaKonstruktori() {
        Statistics test = new Statistics(readerStub);
        assertEquals(stats.getClass(), test.getClass());
    }
    
    @Test
    public void testaaSearch() {
        Player expected = new Player("Semenko", "EDM", 4, 12);
        Player result = stats.search("Semenko");
        assertEquals(expected.toString(), result.toString());
    }
    
    @Test
    public void testaaSearchEiLoydy() {
        assertNull(stats.search("Remes"));
    }
    
    @Test
    public void testaaPlayersOfTeam() {
        Player test = new Player("Lemieux", "PIT", 45, 54);
        assertEquals(stats.team("PIT").get(0).compareTo(test), 0);
    }
    
    @Test
    public void testaaPlayersOfTeamEmpty() {
        assertTrue(stats.team("BOS").isEmpty());
    }
    
    @Test
    public void testaaTopScorersNegatiivinen() {
        assertTrue(stats.topScorers(-1).equals(new ArrayList<Player>()));
    }
    
    @Test
    public void testaaTopScorersNolla() {
        Player test = new Player("Gretzky", "EDM", 35, 89);
        assertEquals(stats.topScorers(0).get(0).compareTo(test), 0);
    }
    
    @Test
    public void testaaTopScorersPositiivinen() {
        Player test1 = new Player("Gretzky", "EDM", 35, 89);
        Player test2 = new Player("Lemieux", "PIT", 45, 54);
        List<Player> result = stats.topScorers(1);
        assertEquals(result.get(0).compareTo(test1), 0);
        assertEquals(result.get(1).compareTo(test2), 0);
    }


    // ...
}

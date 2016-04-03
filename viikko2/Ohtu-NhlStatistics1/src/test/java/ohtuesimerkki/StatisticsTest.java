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
 * @author Simo
 */
public class StatisticsTest {

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

    /**
     * Test of search method, of class Statistics.
     */
    @Test
    public void testSearchNotFound() {
        System.out.println("search");
        String name = "Fail";
        Player expResult = null;
        Player result = stats.search(name);
        assertEquals(expResult, result);
    }

    @Test
    public void testSearchFound() {
        System.out.println("search");
        String name = "Semenko";
        Player result = stats.search(name);
        assertNotNull(result);
    }

    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void testTeam() {
        System.out.println("team");
        String teamName = "PIT";
        List<Player> expResult = new ArrayList<Player>();
        expResult.add(stats.search("Lemieux"));
        List<Player> result = stats.team(teamName);
        assertEquals(expResult, result);
    }

    @Test
    public void testTeamNotFound() {
        System.out.println("team");
        String teamName = "fail";
        List<Player> expResult = new ArrayList<Player>();
        List<Player> result = stats.team(teamName);
        assertEquals(expResult, result);
    }

    /**
     * Test of topScorers method, of class Statistics.
     */
    @Test
    public void testTopScorersEmpty() {
        System.out.println("topScorers");
        int howMany = -1;
        List<Player> expResult = null;
        List<Player> result = stats.topScorers(howMany);
        assertEquals(0, result.size());
    }

    @Test
    public void testTopScorers() {
        System.out.println("topScorers");
        int howMany = 2;
        List<Player> result = stats.topScorers(howMany);
        assertEquals(3, result.size());
    }

}

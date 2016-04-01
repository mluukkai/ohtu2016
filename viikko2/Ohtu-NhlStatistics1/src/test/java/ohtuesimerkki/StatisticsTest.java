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
 * @author mikromafia
 */
public class StatisticsTest {

    // Statistics stats;// = new Statistics(new PlayerReader);
    Statistics stats;
//    Statistics stats = new Statistics() {
//        players = readerStub 
//    }
//    }
    Reader readerStub = new Reader() {
             //Statistics stats = new Statistics( new PlayerReader("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
            players.add(new Player("Sel8nne", "WTF", 1, 2));
            players.add(new Player("Derp", "LOL", 25, 33));
            players.add(new Player("Drool", "WUT", 105, 63));

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
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of search method, of class Statistics.
     */
    @Test
    public void testSearchExistingName() {

        stats = new Statistics(readerStub);

        System.out.println("el8nne");
        String name = "el8nne";

        Player result = stats.search(name);
        Player tester = new Player("Sel8nne", "WTF", 1, 2);

        assertEquals(tester.getName(), result.getName());

    }

    @Test
    public void testSearchNonExistingName() {

        stats = new Statistics(readerStub);

        System.out.println("el9nne");
        String name = "el9nne";

        Player result = stats.search(name);

        assertEquals(null, result
        );

    }

    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void testExistingTeam() {
        stats = new Statistics(readerStub);
        System.out.println("team testing for WTF");

        String name = "WTF";

//        Player result = stats.search(name);
//        Player tester = new Player("Sel8nne", "WTF", 1, 2);
        assertEquals(1, stats.team(name).size());

    }

    @Test
    public void testNonExistingTeam() {
        stats = new Statistics(readerStub);
        System.out.println("team testing for WTH");

        String name = "WTH";

//        Player result = stats.search(name);
//        Player tester = new Player("Sel8nne", "WTF", 1, 2);
        assertEquals(0, stats.team(name).size());

    }

    /**
     * Test of topScorers method, of class Statistics.
     */
    @Test
    public void testTopScorers() {
        stats = new Statistics(readerStub);
        System.out.println("testing topScorers, first for 0 players");
        for (Player plr : stats.topScorers(0)) {
            System.out.println(plr.getName() + ", goals: " + plr.getGoals());
        }
        assertEquals(1, stats.topScorers(0).size());

        System.out.println("testing topScorers, -1 players");
        assertEquals(0, stats.topScorers(-1).size());
        System.out.println("should pass as zero...");
        System.out.println("topscorers, top 5:");
        for (Player plr : stats.topScorers(5)) {
            System.out.println(plr.getName() + ", goals: " + plr.getGoals());
        }
        assertEquals(6, stats.topScorers(5).size());

    }

}

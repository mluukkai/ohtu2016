/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mikosty
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void searchReturnsRightPlayer() {
        Player semenko = new Player("Semenko", "EDM", 4, 12);
        Player searched = stats.search("Semenko");
        
        assertEquals(semenko.toString(), searched.toString());
    }
    @Test
    public void searchReturnsNullIfNotFound() {
        Player searched = stats.search("faulty");
        
        assertEquals(searched, null);
    }
    @Test
    public void teamReturnsCorrectList() {
        List<Player> correctList = new ArrayList();
        correctList.add(new Player("Semenko", "EDM", 4, 12));
        correctList.add(new Player("Gretzky", "EDM", 35, 89));
        correctList.add(new Player("Kurri", "EDM", 37, 53));

        List<Player> statsList = stats.team("EDM");
        
        Collections.sort(statsList);
        Collections.sort(correctList);
        
        String correctTeam = "";
        String statsTeam = "";
        
        for (Player player : statsList) {
            statsTeam += player.toString();
        }
        
        for (Player player : correctList) {
            correctTeam += player.toString();
        }
        
        assertEquals(correctTeam, statsTeam);
        
    }
    @Test 
    public void topScorersWorks() {
        List<Player> topScorers = stats.topScorers(1);
        
        Player topScorer = topScorers.get(0);
        
        assertEquals(topScorer.getName(), "Gretzky");
        
    }
}



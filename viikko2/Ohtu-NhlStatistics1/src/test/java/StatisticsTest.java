/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.PlayerReader;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author krislaut
 */
public class StatisticsTest {
    private Statistics stats;
    
    Reader readerStub = new Reader() {
        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
            
            players.add(new Player("nimi1", "team1", 1, 12));
            players.add(new Player("nimi2", "team1", 9, 1));
            players.add(new Player("nimi3", "team3", 2, 1));
            players.add(new Player("nimi4", "team5", 1, 5));
            players.add(new Player("nimi5", "team5", 3, 4));
            
            return players;
        }
    };
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void playersByTeam(){
        assertEquals(stats.team("team1").get(0).getName(), "nimi1");
        assertEquals(stats.team("team3").get(0).getName(), "nimi3");
        assertEquals(stats.team("team5").get(0).getName(), "nimi4");
    }

    @Test
    public void playersAmountByTeam(){
        assertEquals(stats.team("team1").size(), 2);
        assertEquals(stats.team("team3").size(), 1);
        assertEquals(stats.team("team5").size(), 2);
        assertEquals(stats.team("team0").size(), 0);
    }
    
    @Test
    public void playersTopScorer(){
        List<Player> list = stats.topScorers(1);
        
        assertEquals(list.get(0).getName(), "nimi1");
    }
    
    @Test
    public void playersTopScorers(){
        List<Player> list = stats.topScorers(3);
        
        assertEquals(list.get(0).getName(), "nimi1");
        assertEquals(list.get(1).getName(), "nimi2");
        assertEquals(list.get(2).getName(), "nimi5");
    }
    
    @Test
    public void search(){
        assertEquals(stats.search("nimi1").getName(), "nimi1");
        assertEquals(stats.search("nimi").getName(), "nimi1");
        assertEquals(stats.search("tätäeilöydy").getName(), null);
    }
}

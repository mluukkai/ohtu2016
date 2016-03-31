/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jkostet
 */
public class StatisticsTest {
    
    public StatisticsTest() {
        stats = new Statistics(readerStub);
    }
    
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

    
    @Before
    public void setUp() {
    }

    @Test
    public void searchLoytaaPelaajan() {
        Player result = stats.search("Lemi");
        assertEquals("PIT", result.getTeam());
    }
    
    @Test
    public void eiLoydetaOlematontaPelaajaa() {
        assertEquals(null, stats.search("Coolness"));
    }

    @Test
    public void joukkueenPelaajienListaus() {
        List pelaajat = stats.team("EDM");
        System.out.println(pelaajat.toString());
        assertEquals(pelaajat.toString(), "[Semenko              EDM  4 + 12 = 16, Kurri                EDM 37 + 53 = 90, Gretzky              EDM 35 + 89 = 124]");
    }
    
    @Test
    public void listaaOikeaMaaraTopScorers() {
        // haetaan top 3 (0,1,2) 
        assertEquals(3, stats.topScorers(2).size());
    }
    
}

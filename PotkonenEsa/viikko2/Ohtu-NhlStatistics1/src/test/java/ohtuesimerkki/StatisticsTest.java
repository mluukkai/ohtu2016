package ohtuesimerkki;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StatisticsTest {
    double vertailuTarkkuus = 0.0001;
    Statistics stats = new Statistics(new ReaderStub());
    @Test
    public void testNullCreate() {
    	new Statistics(null);
    }
    @Test
    public void testCreate() {
    	new Statistics(new ReaderStub());
    }
    @Test
    public void testTeam() {
    	List<Player> players = stats.team("PHI");
    	assertEquals(0,players.size(),vertailuTarkkuus);
    	players = stats.team("EDM");
    }
    @Test
    public void testNullTeam() {
    	List<Player> players = stats.team(null);
    	assertEquals(0,players.size(),vertailuTarkkuus);
    }
    @Test
    public void testTop() {
    	List<Player> players = stats.topScorers(1);
    	assertEquals(2,players.size(),vertailuTarkkuus);
    }
    @Test
    public void testSearch() {
    	Player player = stats.search("Kurri");
    	//assertNull(player);
    	player = stats.search("Hurri");
    }
    @Test(expected=NullPointerException.class)
    public void testNullSearch() {
    	Player player = stats.search(null);
    	//assertNull(player);
    }
}

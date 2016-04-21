import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import ohtuesimerkki.Player;
import ohtuesimerkki.Statistics;
import ohtuesimerkki.Reader;
import static org.junit.Assert.assertEquals;

public class StatisticsTest {

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
    
    @Before
    public void setUp() {
        this.stats = new Statistics(this.readerStub);
    }
    
    /*
    
    @Test
    public void test() {
        
    }
    
    */
    
    @Test
    public void allPlayersFound() {
        for (Player player : readerStub.getPlayers()) {
            assertEquals(player.getName(), this.stats.search(player.getName()).getName());
        }
    }
    
    @Test
    public void invalidPlayerNotFound() {
        assertEquals(null, this.stats.search("dsah54hbf4"));
    }
    
    
    @Test
    public void findsCorrectPlayers() {
        assertEquals(3, this.stats.team("EDM").size());
    }
    
    @Test
    public void findsTopScorers() {
        assertEquals(3, this.stats.topScorers(3).size());
    }

    
}

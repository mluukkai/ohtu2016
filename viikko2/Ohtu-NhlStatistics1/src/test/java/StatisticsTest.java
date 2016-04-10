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

public class StatisticsTest {
    
    public StatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
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
    public void searchByNameWhenNameIsInList() {
        Player player = stats.search("Kurri");
        assertEquals(37 + " " + 53, player.getGoals() + " " + player.getAssists());
    }
    
    @Test 
    public void searchByNameWhenNameIsNotInList() {
        assertEquals(null, stats.search("Ihmemies"));
    }
   
    
    @Test
    public void searchTeamByTeamName() {
        List<Player> team = stats.team("PIT");
        assertEquals(team.get(0).getGoals() + " " + team.get(0).getAssists(), 45 + " " + 54);
    }
    
    @Test
    public void topScorersReturnsRightSizeList() {
        List<Player> topScorers = stats.topScorers(2);
        assertEquals(topScorers.size(), 3);
    }
    
    @After
    public void tearDown() {
    }

}

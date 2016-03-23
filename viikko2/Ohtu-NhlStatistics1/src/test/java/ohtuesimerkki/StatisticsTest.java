package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    Statistics stats;

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
        stats = new Statistics(readerStub);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void searchExistingPlayer() {
        Player found = stats.search("Kurri");
        assertEquals(found.getName(), "Kurri");
    }

    @Test
    public void searchNonExistingPlayer() {
        Player found = stats.search("Tyson");
        assertTrue(found == null);
    }

    @Test
    public void searchExistingTeam() {
        List<Player> found = stats.team("DET");
        assertTrue(!found.isEmpty());
    }

    @Test
    public void searchNonExistingTeam() {
        List<Player> found = stats.team("XYZ");
        assertTrue(found.isEmpty());
    }
    
    @Test
    public void topScoresReturnsRightAmountOfPlayers(){
        assertTrue(stats.topScorers(4).size()==5); //sieltä tulee yksi liikaa...
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

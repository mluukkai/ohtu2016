package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        Matcher m = new And(new HasAtLeast(10, "goals"),
                            new HasAtLeast(10, "assists"),
                            new PlaysIn("PHI")
        );

        Matcher n = new Or(new HasAtLeast(40, "assists"),
                           new PlaysIn("PHI")
        );
        
        Matcher j = new Not(new HasAtLeast(8, "assists"));

        for (Player player : stats.matches(n)) {
            System.out.println(player);
        }
    }
}

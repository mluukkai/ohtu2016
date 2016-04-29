package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        QueryBuilder qb = new QueryBuilder();
        Matcher m1 = qb.playsIn("NYR").hasAtLeast(10, "goals").build();
        Matcher m2 = qb.playsIn("EDM").hasFewerThan(2, "goals").build();
        
        Matcher m = qb.oneOf(m1, m2).build();
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}

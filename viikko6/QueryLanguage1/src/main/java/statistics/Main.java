package statistics;

import statistics.matcher.*;
import statistics.querybuilder.QueryBuilder;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        /*
         Matcher m = new And( new HasAtLeast(10, "goals"),
         new HasAtLeast(10, "assists"),
         new PlaysIn("PHI")
         );
        
         for (Player player : stats.matches(m)) {
         System.out.println( player );
         }
         */
        
        QueryBuilder query = new QueryBuilder();

        /*
        Matcher m = query.playsIn("NYR")
                .hasAtLeast(10, "goals")
                .hasFewerThan(25, "assists").build();
                */
        
        Matcher m = query.hasFewerThan(10, "goals").playsIn("NYR").build();

        
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
                
        
    }
}

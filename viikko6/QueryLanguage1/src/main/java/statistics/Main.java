package statistics;

import statistics.matcher.*;
// import statistics.querybuilder.QueryBuilder;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        /*
         Matcher m = new And(new HasAtLeast(null, 10, "goals"),
         new HasFewerThan(null, 25, "assists"),
         new PlaysIn(null, "NYR")
         );
         */
        QueryBuilder query = new QueryBuilder();

        /*
         Matcher m = query.playsIn("NYR")
         .hasAtLeast(10, "goals")
         .hasFewerThan(25, "assists").build();
         */
        Matcher m = query.oneOf(
                query.playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(25, "assists").build(),
                
                query.playsIn("EDM")
                .hasAtLeast(10, "points").build(),
                
                query.playsIn("NYR")
                .hasAtLeast(10, "goals")
                .hasFewerThan(25, "assists").build()
                
        ).build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

    }
}

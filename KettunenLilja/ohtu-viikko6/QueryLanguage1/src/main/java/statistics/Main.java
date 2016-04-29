package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
//          
//        Matcher m = new And( new HasAtLeast(10, "goals"),
//                             new HasAtLeast(10, "assists"),
//                             new PlaysIn("PHI")
//        );

//        Matcher m = new Not( new HasFewerThan(10, "goals"),
//                             new HasFewerThan(10, "assists"),
//                             new PlaysIn("PHI")
//        );
        QueryBuilder query = new QueryBuilder();

        Matcher m1 = query.playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(50, "assists").build();

        Matcher m2 = query.playsIn("EDM")
                .hasAtLeast(10, "points").build();

        Matcher m = query.oneOf(m1, m2).build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}

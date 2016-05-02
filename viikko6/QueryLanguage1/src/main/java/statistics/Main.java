package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        Matcher m = new And(new HasAtLeast(10, "goals"),
                new HasAtLeast(10, "assists"),
                new PlaysIn("PHI")
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("");
        System.out.println("");

        m = new Or(new PlaysIn("DAL"),
                new PlaysIn("ANA"),
                new PlaysIn("PHI")
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("");
        System.out.println("");

        m = new And(new HasFewerThan(10, "goals"),
                new PlaysIn("PHI")
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("");
        System.out.println("");

        m = new Not(new PlaysIn("DAL"),
                new PlaysIn("ANA"),
                new PlaysIn("PHI"),
                new HasFewerThan(30, "goals")
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("");
        System.out.println("");

        QueryBuilder query = new QueryBuilder();

        m = query.playsIn("NYR")
                .hasAtLeast(10, "goals")
                .hasFewerThan(25, "assists").build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("");
        System.out.println("");

        Matcher m1 = query.playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(20, "assists").build();

        Matcher m2 = query.playsIn("EDM")
                .hasAtLeast(50, "points").build();

        Matcher m3 = query.oneOf(m1, m2).build();
        
        for (Player player : stats.matches(m3)) {
            System.out.println(player);
        }
    }
}

package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        Matcher m = new And( new HasAtLeast(10, "goals"),
                             new HasAtLeast(10, "assists"),
                             new PlaysIn("PHI")
        );
        //print("Original",stats, m);

        m = new Or(  new PlaysIn("ANA"),
                     new PlaysIn("PHI"));
        print("Or",stats, m);

        m = new Not(new PlaysIn("NJD"),new PlaysIn("OTT"));
        print("Not",stats, m);
        
        m = new And( new PlaysIn("ANA"), new HasFewerThan(25, "goals")
        );
        print("HasFewerThan",stats, m);
        
        QueryBuilder query = new QueryBuilder();

        Matcher q = query.playsIn("NYR")
                     .hasAtLeast(10, "goals")
                     .hasFewerThan(25, "assists").build();        
        print("QueryBuilder",stats, q);
        
        Matcher m1 = query.playsIn("PHI")
                          .hasAtLeast(10, "goals")
                          .hasFewerThan(15, "assists").build();

        Matcher m2 = query.playsIn("EDM")
                          .hasAtLeast(50, "points").build();

        Matcher m3 = query.oneOf(m1, m2).build();        
        print("QueryBuilder oneOf",stats, m3);
    }

    private static void print(String what, Statistics stats, Matcher m) {
        System.out.println("Begin-------------"+what+"--------------------");
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}

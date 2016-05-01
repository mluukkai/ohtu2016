package statistics;

import statistics.matcher.QueryBuilder;
import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        Matcher m = new And( new HasAtLeast(2, "goals"),
                             new HasAtLeast(7, "assists"),
                
                             new PlaysIn("PHI"),
                new HasFewerThan(10, "assists")
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        System.out.println("=== 40+ goals or plays in PHI and 20+ goals ===");
         m = new Or( 
                             
                
                             new And(new PlaysIn("PHI"),
                             new HasAtLeast(20, "goals")),
                             new HasAtLeast(40, "goals")
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
           System.out.println("=== PHI and has fewer than 15, but not 8 assists ===");
         m = new And( 
                             
                new PlaysIn("PHI"),
                             
                new HasFewerThan(15, "assists") ,
                 new Not(0, "assists")           
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("=== paranneltu kyselykieli ===");
         QueryBuilder query = new QueryBuilder();

            m = query.playsIn("NYR")
                     .hasAtLeast(15, "goals")
                     .hasFewerThan(33, "assists").build();

    for (Player player : stats.matches(m)) {
        System.out.println( player );
    }
    
        System.out.println("=== paranneltu II ===");
        Matcher m1 = query.playsIn("PHI")
                  .hasAtLeast(10, "goals")
                  .hasFewerThan(20, "assists").build();

Matcher m2 = query.playsIn("EDM")
                  .hasAtLeast(50, "points").build();

 m = query.oneOf(m1, m2).build();
     for (Player player : stats.matches(m)) {
        System.out.println( player );
    }
    }
}

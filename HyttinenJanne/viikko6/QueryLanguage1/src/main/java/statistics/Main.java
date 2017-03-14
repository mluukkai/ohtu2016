package statistics;

import statistics.matcher.QueryBuilder;
import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        QueryBuilder query = new QueryBuilder();
        Matcher m = query.and(query.playsIn("PHI").build(),query.hasFewerThan(10, "goals").build()).build();
       
        
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}

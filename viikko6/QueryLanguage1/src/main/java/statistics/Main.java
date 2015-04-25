package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        Matcher m = new And( new HasAtLeast(10, "goals"),
                             new HasAtLeast(10, "assists"),
                             new PlaysIn("PHI")
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("----");
        
        QueryBuilder query = new QueryBuilder();
        
        Matcher m1 = query.oneOf(
                        query.playsIn("PHI")
                             .hasAtLeast(10, "goals")
                             .hasFewerThan(15, "assists").build(),

                        query.playsIn("EDM")
                             .hasAtLeast(50, "points").build()
                       ).build();
        
        for (Player player : stats.matches(m1)) {
            System.out.println( player );
        }
    }
}
package statistics.querybuilder;

import statistics.Player;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.PlaysIn;

public class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {

        /*
         this.matcher = new Matcher() {

         @Override
         public boolean matches(Player p) {
         return true;
         }
         };
         */
    }

    public Matcher build() {
        return matcher;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new HasAtLeast(this.matcher, value, category);
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new HasFewerThan(this.matcher, value, category);
        return this;
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new PlaysIn(this.matcher, team);
        return this;
    }

}

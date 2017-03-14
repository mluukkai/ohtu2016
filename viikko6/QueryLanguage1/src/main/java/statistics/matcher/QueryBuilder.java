package statistics.matcher;

import java.util.ArrayList;

public class QueryBuilder {

    private Matcher matcher;

    // by default all conditions will be chained, therefore we initialize
    // using an And() operator
    public QueryBuilder() {
        this.matcher = new And();

    }

    private QueryBuilder(Matcher matcher) {
        this.matcher = matcher;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        return new QueryBuilder(new And(this.matcher, new HasAtLeast(value, category)));
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        return new QueryBuilder(new And(this.matcher, new HasFewerThan(value, category)));
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        return new QueryBuilder(new Or(matchers));
    }

    public QueryBuilder playsIn(String team) {
        return new QueryBuilder(new And(this.matcher, new PlaysIn(team)));
    }


    public Matcher build() {
        return this.matcher;
    }

}

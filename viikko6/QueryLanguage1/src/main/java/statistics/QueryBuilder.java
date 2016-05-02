package statistics;

import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {
        matcher = new And();
    }

    public QueryBuilder(Matcher matcher) {
        this.matcher = matcher;
    }

    public QueryBuilder playsIn(String team) {
        return new QueryBuilder(new And(matcher, new PlaysIn(team)));
    }

    public QueryBuilder hasAtLeast(int value, String fieldName) {
        return new QueryBuilder(new And(matcher, new HasAtLeast(value, fieldName)));
    }

    public QueryBuilder hasFewerThan(int value, String fieldName) {
        return new QueryBuilder(new And(matcher, new HasFewerThan(value, fieldName)));
    }

    public QueryBuilder oneOf(Matcher matcher1, Matcher matcher2) {
        return new QueryBuilder(new Or(matcher1, matcher2));
    }

    public Matcher build() {
        Matcher returnMatcher = this.matcher;
        this.matcher = new And();
        return returnMatcher;
    }

}

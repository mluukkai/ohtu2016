package statistics.matcher;

public class QueryBuilder {

    Matcher matcher;
    
    public QueryBuilder(Matcher matcher) {
        this.matcher = matcher;
    }
    
    public QueryBuilder() {
        this(new TrueMatcher());
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
   
    public QueryBuilder oneOf(Matcher... matchers) {
        return new QueryBuilder(new And(matcher, new Or(matchers)));
    }
    
    public Matcher build() {
        return matcher;
    }
}

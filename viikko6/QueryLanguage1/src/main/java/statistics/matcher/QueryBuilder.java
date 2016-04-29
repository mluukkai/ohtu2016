
package statistics.matcher;



public class QueryBuilder {
    private final Matcher[] matchers;
    private final int size;

    
    public QueryBuilder() {
        this.matchers = new Matcher[0];
        this.size=0;
    }
    
    public QueryBuilder(Matcher[] matchers) {
        this.matchers = matchers;
        this.size = matchers.length;
    }
    
    
    public Matcher build() {
        Matcher matcher = new And(matchers);
        return matcher;
    }
    
    public QueryBuilder playsIn(String team) {
        Matcher[] newMatchers = initNewMatcherArray();
        
        newMatchers[size] = new PlaysIn(team);
        return new QueryBuilder(newMatchers);
    }
    
    public QueryBuilder hasAtLeast(int number, String type) {
        Matcher[] newMatchers = initNewMatcherArray();
        newMatchers[size] = new HasAtLeast(number, type);
        return new QueryBuilder(newMatchers);
    }
    
    public QueryBuilder hasFewerThan(int number, String type) {
        Matcher[] newMatchers = initNewMatcherArray();
        newMatchers[size] = new HasFewerThan(number, type);
        return new QueryBuilder(newMatchers);
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        Matcher[] newMatchers = initNewMatcherArray();
        newMatchers[size] = new Or(matchers);
        return new QueryBuilder(newMatchers);
    }
    
    private Matcher[] initNewMatcherArray() {
        int newSize = size+1;
        Matcher[] newMatchers = new Matcher[newSize];
        int i=0;
        for (Matcher m : this.matchers) {
            newMatchers[i++] = m;
        }
        
        return newMatchers;
    }
    
}

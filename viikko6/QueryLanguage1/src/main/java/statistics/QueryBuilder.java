/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import java.util.ArrayList;
import statistics.matcher.*;

/**
 *
 * @author oskar
 */
public class QueryBuilder {
    Matcher matcher;

    public QueryBuilder(Matcher matchers) {
        this.matcher = matchers;
    }

    public QueryBuilder() {
        this.matcher = new Noop();
    }
    
    
    public QueryBuilder playsIn(String team) {
        return new QueryBuilder(new And(this.matcher, new PlaysIn(team)));
    }
    
    public QueryBuilder hasAtLeast(int value, String property) {
        return new QueryBuilder(new And(this.matcher, new HasAtLeast(value, property)));
    }
    
    public QueryBuilder hasFewerThan(int value, String property) {
        return new QueryBuilder(new And(this.matcher, new HasFewerThan(value, property)));
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        return new QueryBuilder(new And(this.matcher, new Or(matchers)));
    }
    
    public QueryBuilder oneOf(QueryBuilder... builders) {
        ArrayList<Matcher> built = new ArrayList<Matcher>();
        for (QueryBuilder builder : builders) {
            built.add(builder.build());
        }
        return this.oneOf((Matcher[]) built.toArray(new Matcher[built.size()]));
    }
    
    public Matcher build() {
        return this.matcher;
    }
}

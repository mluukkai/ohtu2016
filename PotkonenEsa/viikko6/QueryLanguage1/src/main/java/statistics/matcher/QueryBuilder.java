/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author Esa Potkonen
 */
public class QueryBuilder {
    private Matcher matcher;
    public QueryBuilder() {
        matcher = new And();
    }
    // Tämä ei kyllä toimi millään, mutta näyttää komialta
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        matcher = new Or(m1, m2);
        return this;
    }
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And(matcher,new HasFewerThan(value, category));
        return this;
    }
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher =  new And(matcher,new HasAtLeast(value, category));
        return this;
    }
    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher,new PlaysIn(team));
        return this;
    }
    public Matcher build() {
       return matcher; 
    }
}

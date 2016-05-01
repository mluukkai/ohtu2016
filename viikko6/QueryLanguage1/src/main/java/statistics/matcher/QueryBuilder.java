/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.matcher.Matcher;
import statistics.matcher.PlaysIn;


public class QueryBuilder {
    private Matcher matcher;

    public QueryBuilder(Matcher matcher) {
        this.matcher=matcher;
    }
    
    public QueryBuilder() {
        this.matcher = new And();
    }
    
   

    public Matcher build() {
        return this.matcher;
    }
    
         public QueryBuilder Not(int value, String cat) {
        QueryBuilder qb = new QueryBuilder(new And(new Not(value, cat), this.matcher));
        return qb;
    }
    
       public QueryBuilder hasFewerThan(int value, String cat) {
        QueryBuilder qb = new QueryBuilder(new And(new HasFewerThan(value, cat), this.matcher));
        return qb;
    }

    public QueryBuilder playsIn(String missa) {
        QueryBuilder qb = new QueryBuilder(new And(new PlaysIn(missa), this.matcher));
        return qb;
    }
     public QueryBuilder hasAtLeast(int value, String category) {
        QueryBuilder qb = new QueryBuilder(new And(new HasAtLeast(value, category),this.matcher));
        return qb;
    }
     
      public QueryBuilder oneOf(Matcher... matchers) {
        QueryBuilder qb = new QueryBuilder(new Or(matchers));
        return qb;
    }
     
     
 

    
}
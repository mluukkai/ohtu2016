/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author hyttijan
 */
public class QueryBuilder{
    private Matcher matcher;
    public QueryBuilder(){
        
    }
    public QueryBuilder playsIn(String team){
        this.matcher = new PlaysIn(team);
        return this;
    }
    public QueryBuilder hasFewerThan(int value,String category){
        this.matcher = new HasFewerThan(value,category);
        return this;
    }
    public QueryBuilder not(Matcher...matcher){
        this.matcher = new Not(matcher);
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value,String category){
        this.matcher = new HasAtLeast(value,category);
        return this;
    }
    public QueryBuilder and(Matcher...matchers){
        this.matcher = new And(matchers);
        return this;
    }
    public QueryBuilder or(Matcher...matchers){
        this.matcher = new Or(matchers);
        return this;
    }
    public Matcher build(){
        return this.matcher;
    }
  
   
    
    
}

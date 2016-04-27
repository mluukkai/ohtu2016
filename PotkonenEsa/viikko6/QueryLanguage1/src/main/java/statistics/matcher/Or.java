/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author Esa Potkonen
 */
public class Or implements Matcher {

    private Matcher[] matchers;

    public Or(Matcher... matchers) {
        this.matchers = matchers;
    }
    @Override
    public boolean matches(Player p) {
        boolean b = false;
        for (Matcher matcher : matchers) {
            if (matcher.matches(p)) {
                b = true;
            }
        }
        return b;
    }

    @Override
    public void add(Matcher m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

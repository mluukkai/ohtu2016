package statistics.matcher;

import statistics.Player;

public class And implements Matcher {

    private Matcher[] matchers;

    public And(Matcher... matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : matchers) {
            if (!matcher.matches(p)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void add(Matcher m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

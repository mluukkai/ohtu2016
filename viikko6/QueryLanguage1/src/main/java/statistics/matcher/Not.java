package statistics.matcher;

import statistics.Player;

/**
 *
 * @author samukaup
 */
public class Not implements Matcher {

    private Matcher[] matchers;

    public Not(Matcher... matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : matchers) {
            if (matcher.matches(p)) {
                return false;
            }
        }
        return true;
    }
    
}

/*public class Not implements Matcher{

    private Player player;
    
    public Not(Player player) {
        this.player = player;
    }

    @Override
    public boolean matches(Player p) {
        return p == player;
    }
    
}*/

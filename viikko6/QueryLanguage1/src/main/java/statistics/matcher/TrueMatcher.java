package statistics.matcher;

import statistics.Player;

public class TrueMatcher implements Matcher {

    public TrueMatcher() {
    }

    
    @Override
    public boolean matches(Player p) {
        return true;
    }
    
}

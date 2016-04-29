
package statistics.matcher;

import statistics.Player;

public class PlaysIn implements Matcher {
    private String team;
    private Matcher matcher;

    public PlaysIn(Matcher matcher, String team) {
        this.matcher = matcher;
        this.team = team;
    }        
    
    @Override
    public boolean matches(Player p) {
        System.out.println("playsin: " + (p.getTeam().contains(team)));
        return p.getTeam().contains(team);
    }
    
}


package statistics.matcher;

import statistics.Player;

public class PlaysIn implements Matcher {
    private Matcher matcher;
    private String team;

    public PlaysIn(Matcher matcher, String team) {
        this.matcher = matcher;
        this.team = team;
    }        

    public PlaysIn(String team) {
        this.team = team;
    }        
    
    @Override
    public boolean matches(Player p) {
        return p.getTeam().contains(team) && (this.matcher != null ? this.matches(p) : true);
    }

    @Override
    public void add(Matcher m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

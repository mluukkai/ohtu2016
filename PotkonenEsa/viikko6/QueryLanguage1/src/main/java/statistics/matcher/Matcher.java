
package statistics.matcher;

import statistics.Player;

public interface Matcher {
    void add(Matcher m);
    boolean matches(Player p);
}

package ohtu;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.compareTo(player1Name) == 0) {
            m_score1 += 1;
        } else if (playerName.compareTo(player2Name) == 0) {
            m_score2 += 1;
        }
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            if (m_score1 > 3)
                return "Deuce";
            else
                return translateToTennis(m_score1) + "-All";
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            String edellaOlevaPelaaja = (m_score1 > m_score2 ? player1Name : player2Name);
            int pisteEtu = (m_score1 > m_score2 ? m_score1 - m_score2 : m_score2 - m_score1);
            
            if (pisteEtu == 1 ) {
                return "Advantage " + edellaOlevaPelaaja;
            } else if (pisteEtu >= 2) {
                return "Win for " + edellaOlevaPelaaja;
            }
        } else
            return translateToTennis(m_score1) + "-" + translateToTennis(m_score2);
        throw new IllegalStateException("Score could not be displayed, the world is ending, frogs are raining, Cthulhu is waking from its slumber!!");
    }

    public String translateToTennis(int points) {
        switch (points) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }
}

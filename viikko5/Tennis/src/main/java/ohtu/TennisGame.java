package ohtu;

public class TennisGame {
    private int m_score1 = 0;
    private int m_score2 = 0;
    private final String player1Name;
    private final String player2Name;
    private static final String scoreStrings[] = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName))
            m_score1++;
        else
            m_score2++;
    }

    private String getAtSameScore(int score) {
        if(score >= scoreStrings.length)
            return "Deuce";
        return scoreStrings[score] + "-All";
    }

    private String getAtHigherScore() {
        String score;
        int difference = Math.abs(m_score1 - m_score2);
        if (difference == 1) {
            score = "Advantage ";
        } else {
            score = "Win for ";
        }

        if (m_score1 > m_score2)
            score += "player1";
        else if (m_score1 < m_score2)
            score += "player2";
        return score;
    }

    public String getScore() {
        String score = "";

        if (m_score1 == m_score2) {
            return getAtSameScore(m_score1);
        }
        if (m_score1 >= 4 || m_score2 >= 4) {
            return getAtHigherScore();
        }

        score += scoreStrings[m_score1];
        score += "-";
        score += scoreStrings[m_score2];
        return score;
    }
}
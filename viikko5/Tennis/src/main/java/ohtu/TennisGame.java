package ohtu;

public class TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    final private String player1Name;
    final private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name))
            m_score1 += 1;
        else if (playerName.equals(this.player2Name))
            m_score2 += 1;
        else
            throw new IllegalArgumentException("Unknown player " + playerName);
    }

    public String getScore() {
        if (m_score1 == m_score2)
            return this.getTiedScore();
        else if (m_score1 >= 4 || m_score2 >= 4)
            return this.getAdvantageScore();
        else
            return this.getStandardScore();
    }
    
    String getTiedScore() {
        if (m_score1 < 4)
            return scoreToString(m_score1) + "-All";
        else
            return "Deuce";
    }
    
    String getAdvantageScore() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1)
            return "Advantage " + this.player1Name;
        else if(minusResult == -1)
            return "Advantage " + this.player2Name;
        else
            return "Win for " + (minusResult >= 2 ? this.player1Name : this.player2Name);
    }
    
    String getStandardScore() {
        return scoreToString(m_score1) + "-" + scoreToString(m_score2);
    }
    
    String scoreToString(int score) {
        switch(score) {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
            default:
                throw new IllegalArgumentException("Cannot convert " + score + " to score string.");
        }
    }
}
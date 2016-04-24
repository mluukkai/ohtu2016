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

    // method that gives either one of the players one point
    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            m_score1++;
        } else {
            m_score2++;
        }
    }

    // main game logic
    public String getScore() {

        if (m_score1 == m_score2) {
            
            // tie, both players have the same score
            return scoreTie();
            
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            
            // other one of the players either has advantage
            // or wins
            return scoreAdvantage();
            
        } else {
            
            // both players are between 0-30 points.
            return scorePoints();
            
        }
 
    }

    private String scorePoints() {
        
        String scoreText = "";
        
        // we'll process both players at the time, i = 1 or i = 2
        for (int i = 1; i <= 2; i++) {
            
            if (i == 1) {
                // player 1
                scoreText += formattedPlayerScore(m_score1);
            } else {
                // player 2
                scoreText += "-";
                scoreText += formattedPlayerScore(m_score2);
            }

            
        }
        return scoreText;
    }

    private String formattedPlayerScore(int tempScore) {
        
        String scoreText = "";
        
        switch (tempScore) {
            case 0:
                scoreText += "Love";
                break;
            case 1:
                scoreText += "Fifteen";
                break;
            case 2:
                scoreText += "Thirty";
                break;
            case 3:
                scoreText += "Forty";
                break;
        }
        return scoreText;
    }

    private String scoreAdvantage() {
        String score;
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }

    private String scoreTie() {
        String score;
        switch (m_score1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
}

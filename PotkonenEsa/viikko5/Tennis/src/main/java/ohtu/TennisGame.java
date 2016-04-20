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
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }
    private boolean isEven(int score1, int score2) {
        boolean status = false;
        if (score1==score2)
        {
            status = true;
        }
        return status;
    }
    private String getAdvantageOrWinText(int score1, int score2) {
        String score = "";
        int difference = score1 - score2;
        switch (difference) {
            case -4:
            case -3:
            case -2:
                score ="Win for player2";
                break;
            case -1:
                score ="Advantage player2";
                break;
            case 1:
                score ="Advantage player1";
                break;
            case 2:
            case 3:
            case 4:
                score = "Win for player1";
                break;
            default:
        }

        return score;
    }
    private boolean isAdvantageOrWin(int score1, int score2) {
        boolean status = false;

        if (score1>=4 || score2>=4)
        {
            status = true;
        }
        return status;
    }
    public String getScore() {
        String score = "";
        int tempScore=0;
        if (isEven(m_score1,m_score2)) {
            score = scoreText(m_score1);
        } else if (isAdvantageOrWin(m_score1,m_score2)) {
            score = getAdvantageOrWinText(m_score1,m_score2);
        } else {
            score += pointsText(m_score1);
            score += "-";
            score += pointsText(m_score2);
        }
        System.out.println("ohtu.TennisGame.getScore("+score+")");
        return score;
    }
    private String pointsText(int tempScore) {
        String score = "";
        switch(tempScore)
        {
            case 0:
                score+="Love";
                break;
            case 1:
                score+="Fifteen";
                break;
            case 2:
                score+="Thirty";
                break;
            case 3:
                score+="Forty";
                break;
        }
        return score;
    }

    private String pointsTextp(int tempScore, String score) {
        switch(tempScore)
        {
            case 0:
                score+="Love";
                break;
            case 1:
                score+="Fifteen";
                break;
            case 2:
                score+="Thirty";
                break;
            case 3:
                score+="Forty";
                break;
        }
        return score;
    }

    private String scoreText(int wons) {
        String score;
        switch (wons)
        {
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
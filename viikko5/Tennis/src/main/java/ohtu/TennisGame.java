package ohtu;

public class TennisGame {

    private int score1 = 0;
    private int score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name) score1 += 1;
        else score2 += 1; 
    }

    public String getScore() {
        String score = "";
        if (score1 == score2 && score1 < 4) score = scoreIsTie(score);
        else if (score1 == score2 && score1 > 3) score = "Deuce";
        else if (score1 >= 4 || score2 >= 4) score = scoreIsAboveFour(score);
        else score = scoreEarlyGame(score);
        return score;
    }
    
    public String scoreEarlyGame(String score) {
        score += scoreEarlyGameWriter(score, score1);
        score += "-";
        score += scoreEarlyGameWriter(score, score2);
        return score;
    }
    
    public String scoreEarlyGameWriter(String score, int temp) {
        String[] s = {"Love", "Fifteen", "Thirty", "Forty"};
        return score = s[temp];
    }
    
    public String scoreIsTie(String score) {
        String[] tie = {"Love-All", "Fifteen-All", "Thirty-All", "Forty-All"};
        return score = tie[score1];
    }
    
    public String scoreIsAboveFour(String score) {
            if (getCurrentScore() == 1) return score = "Advantage " + player1Name;
            if (getCurrentScore() == -1) return score = "Advantage " + player2Name;
            return score = gameOver();
    }
    
    public String gameOver() {
        if (getCurrentScore() > 1) return "Win for " + player1Name;
        return "Win for " + player2Name;
    }
    
    public int getCurrentScore() {
        return score1 - score2;
    }
}

package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (this.player1Name.equals(playerName))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String score;
        if (player1Score==player2Score)
        {
            score = getTennisTermForTie(player1Score);
        }
        else if (player1Score>=4 || player2Score>=4)
        {
            score = getTennisTermForAdvantage(player1Score, player2Score);
        }
        else
        {
            score = getTennisTermForScore(player1Score) 
                    +"-"+ 
                    getTennisTermForScore(player2Score);
        }
        return score;
    }
    
    
    
    private String getTennisTermForScore(int score) {
        switch(score)
            {
                case 0:
                    return "Love";
                case 1:
                    return "Fifteen";
                case 2:
                    return "Thirty";
                case 3:
                    return "Forty";
                default:
                    return "Deuce";
            }
    }
    
    private String getTennisTermForAdvantage(int player1Score, int player2Score) {
        String scoreTerm;
        int scoreDifference = player1Score-player2Score;
        if (scoreDifference==1) scoreTerm ="Advantage player1";
        else if (scoreDifference ==-1) scoreTerm ="Advantage player2";
        else if (scoreDifference>=2) scoreTerm = "Win for player1";
        else scoreTerm ="Win for player2";
        return scoreTerm;
    }
    
    private String getTennisTermForTie(int tiedScore) {
        if (tiedScore >= 4) return getTennisTermForScore(tiedScore);
        else return getTennisTermForScore(tiedScore)+"-All";
    }
    
}
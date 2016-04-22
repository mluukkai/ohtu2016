package ohtu;

public class TennisGame {
    
    private int player1_scores = 0;
    private int player2_scores = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) player1_scores += 1;
        else player2_scores += 1;
    }

    public String getScore() {
        String score = "";
        if (player1_scores == player2_scores) score = tied(score);       
        else if (player1_scores >= 4 || player2_scores >= 4) score = advantage(score);
        else score = miscSituation(score, player1_scores) + "-" + miscSituation(score, player2_scores);
 
        return score;
    }
    
    public String tied(String score) {
         switch (player1_scores) {
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
    
    public String advantage(String score) {
        int scoreSubtraction = player1_scores - player2_scores;
        if (scoreSubtraction == 1) score = "Advantage player1";
        else if (scoreSubtraction == -1) score = "Advantage player2";
        else if (scoreSubtraction >= 2) score = "Win for player1";
        else score = "Win for player2";
        
        return score;
    }
    
    public String miscSituation(String score, int player_scores) {
        switch(player_scores) {
            case 0:
                score = "Love";
                break;
            case 1:
                score = "Fifteen";
                break;
            case 2:
                score = "Thirty";
                break;
            case 3:
                score = "Forty";
                break;
        }
        return score;
    }
}
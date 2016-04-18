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
        if (playerName.equals(this.player1Name)) {
            player1Score += 1;
        }else {
            player2Score += 1;
        }
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        
        if (player1Score == player2Score) {
            return tieScore(player1Score);
        }else if (player1Score >= 4 || player2Score >= 4) {
            return playerWonOrScoreDifferenceLessThanOne();
        }else {
            return scoreName(player1Score) + "-" + scoreName(player2Score);
        }
    }
    
    private String playerWonOrScoreDifferenceLessThanOne() {
        int difference = Math.abs(player1Score - player2Score);
        
        if (difference >= 2) {
            if (player1Score > player2Score) {
                return "Win for " + player1Name;
            }else {
                return "Win for " + player2Name;
            }
        }else {
            if (player1Score > player2Score) {
                return "Advantage " + player1Name;
            }else {
                return "Advantage " + player2Name;
            }
        }
    }
    
    private String tieScore(int score) {
        if (score >= 4) {
            return "Deuce";
        }
        
        return scoreName(score) + "-All";
    }

    private String scoreName(int number) {
        switch(number)
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
                return "Unknown";
        }
    }

}


package ohtu;

public class TennisGame {
    
    private int firstPlayersScore = 0;
    private int secondPlayersScore = 0;
    private String firstPlayer;
    private String secondPlayer;

    public TennisGame(String player1Name, String player2Name) {
        this.firstPlayer = player1Name;
        this.secondPlayer = player2Name;
    }
    
    /**
     * Adds score to the given player
     * @param playerName 
     */
    public void wonPoint(String playerName) {
        if (playerName.equals("player1")){
            firstPlayerWonPoint();
        } else if(playerName.equals("player2")){
            secondPlayerWonPoint();
        }
    }
    public void firstPlayerWonPoint(){
        firstPlayersScore++;
    }
    public void secondPlayerWonPoint(){
        secondPlayersScore++;
    }
    
    public String getScore() {
        // Same score
        if (firstPlayersScore==secondPlayersScore) {
            return handleSameScore();
        }
        
        // Atleast one score over 4
        if (firstPlayersScore >= 4 || secondPlayersScore >= 4){
            return handleScoreOverFour();
        }
        
        String score = "";
        
        // First player
        switch(firstPlayersScore)
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

        score += "-";

        // Second player
        switch(secondPlayersScore)
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
    
    private String handleSameScore(){
        switch (firstPlayersScore)
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";

        }
    }
    
    private String handleScoreOverFour(){
        int result = firstPlayersScore-secondPlayersScore;
            
        switch(result){
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                if(result >= 2){
                    return "Win for player1";
                } else {
                    return "Win for player2";
                }
        }
    }
}
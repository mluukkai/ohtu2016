/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennismaven2;

/**
 *
 * @author mikromafia
 */
public class TennisGame {
    
        public Player player1;
    public Player player2;


    public TennisGame(String player1Name, String player2Name) {
        this.player1= new Player(player1Name);
        this.player2= new Player(player2Name);
        
    }

    public void wonPoint(String playerName) {
        if (player1.getName().contains(playerName)) {
            player1.addPoint();
        }
        else {
            player2.addPoint();
        }
    }

    public String getScore() {
        int scoreDifference = Math.abs(player1.getScore()-player2.getScore());
        int topScore = Math.max(player1.getScore(), player2.getScore());
        
        if (scoreDifference==0 && player1.getScore()>3) {
            return "Deuce";
        } else if (scoreDifference==0) {
            return player1.getScoreword()+"-All";
        } else if (topScore>3 && scoreDifference>1) {
            return "Win for "+ScoreAnalyzer.nameThePlayerWithHigherScore(player1, player2);
        } else if (topScore>3 && scoreDifference==1) {
            return "Advantage "+ScoreAnalyzer.nameThePlayerWithHigherScore(player1, player2);
        } else {
            return player1.getScoreword()+"-"+player2.getScoreword();
        }
    
}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author samukaup
 */
public class Tennis {
    private int score1;
    private int score2;
    private String player1;
    private String player2;

    public Tennis(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.score1 = 0;
        this.score2 = 0;
    }
    
    public void wonPoint(String playerName) {
        if (playerName == player1) {
            score1 += 1;
        } else {
            score2 += 1;
        }
    }
    
    public String advantage() {
        
        if (score1 > score2) {
            
        }
        return "";
    }
}

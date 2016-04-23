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
public class ScoreAnalyzer {
    
    public static String nameThePlayerWithHigherScore(Player player1, Player player2) {
        if (player1.getScore()>player2.getScore()) {
            return player1.getName();
        } else if (player1.getScore()==player2.getScore()) {
            return "Deuce";
        } else {
            return player2.getName();
        }
    }
    
}

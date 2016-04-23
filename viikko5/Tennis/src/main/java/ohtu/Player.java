/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author mikromafia
 */
public class Player {
    
    private String name;
    private int score;
    
    public Player(String name) {
        this.name=name;
        this.score=0;
    }
    
    public void addPoint() {
        score++;
    }
    
    public void reset() {
        score=0;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getScore() {
        return score;
    }
    
    public String getScoreword() {
        if (score==0) {
            return "Love";
        }
        if (score==1) {
            return "Fifteen";
        }
        if (score==2) {
            return "Thirty";
        }
        if (score==3) {
            return "Forty";
        }
        
            return "Advantage";
        
        
    }
    
}

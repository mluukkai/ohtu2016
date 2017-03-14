/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author kkirjala
 */
public class Main {

    // this is a dummy simulated game for debugging purposes mainly.
    
    
    public static void main(String[] args) {
        TennisGame game = new TennisGame("player1", "player2");

        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());

        game.wonPoint("player2");
        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());

        game.wonPoint("player2");
        System.out.println(game.getScore());
        // forty-thirty

        game.wonPoint("player2");
        System.out.println(game.getScore());
        // forty-all        

        game.wonPoint("player1");
        System.out.println(game.getScore());
        // advantage player1       

        game.wonPoint("player2");
        System.out.println(game.getScore());
        // deuce        

        game.wonPoint("player2");
        System.out.println(game.getScore());
        // advantage player2   

        game.wonPoint("player2");
        System.out.println(game.getScore());
        // win player2

    }

}

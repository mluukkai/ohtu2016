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
        if (playerName == player1Name)player1Score += 1;
        else player2Score += 1;
    }

    public String statusAsString() {
        String situation = "";
        
        //normal
        situation=scoreAsWord(player1Score)+"-"+scoreAsWord(player2Score);
        
        //tie
        if (player1Score==player2Score){
            situation=scoreAsWord(player1Score)+"-All";
            if(player1Score==4)situation="Deuce";
        }
        //endgame
        else if (player1Score>=4 || player2Score>=4){
            int difference = player1Score-player2Score;
            if (difference==1) situation ="Advantage player1";
            else if (difference ==-1) situation ="Advantage player2";
            else if (difference>=2) situation = "Win for player1";
            else situation ="Win for player2";
        }
        return situation;
    }
    
    public String scoreAsWord(int score){
        String string="";
        switch(score){
            case 0:string= "Love";break;
            case 1:string= "Fifteen";break;    
            case 2:string= "Thirty";break;
            case 3:string="Forty";break;
        }
        return string;
    }
}
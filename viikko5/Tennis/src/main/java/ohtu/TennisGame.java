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
        if (playerName == "player1")
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String message = "";
        int tempScore=0;
        if (player1Score==player2Score)
        {
            switch (player1Score)
            {
                case 0:
                        message = "Love-All";
                    break;
                case 1:
                        message = "Fifteen-All";
                    break;
                case 2:
                        message = "Thirty-All";
                    break;
                case 3:
                        message = "Forty-All";
                    break;
                default:
                        message = "Deuce";
                    break;
                
            }
        }
        else if (player1Score>=4 || player2Score>=4)
        {
            int minusResult = player1Score-player2Score;
            
            if (minusResult==1)         message = "Advantage player1";
            else if (minusResult ==-1)  message = "Advantage player2";
            else if (minusResult>=2)    message = "Win for player1";
            else                        message = "Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player1Score;
                else { message+="-"; tempScore = player2Score;}
                switch(tempScore)
                {
                    case 0:
                        message+="Love";
                        break;
                    case 1:
                        message+="Fifteen";
                        break;
                    case 2:
                        message+="Thirty";
                        break;
                    case 3:
                        message+="Forty";
                        break;
                }
            }
        }
        return message;
    }
}
package ohtu;

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
//        String score = "";
//        int tempScore=0;
//        if (scorePlayer1==scorePlayer2)
//        {
//            switch (scorePlayer1)
//            {
//                case 0:
//                        score = "Love-All";
//                    break;
//                case 1:
//                        score = "Fifteen-All";
//                    break;
//                case 2:
//                        score = "Thirty-All";
//                    break;
//                case 3:
//                        score = "Forty-All";
//                    break;
//                default:
//                        score = "Deuce";
//                    break;
//                
//            }
//        }
//        else if (scorePlayer1>=4 || scorePlayer2>=4)
//        {
//            int minusResult = scorePlayer1-scorePlayer2;
//            if (minusResult==1) score ="Advantage player1";
//            else if (minusResult ==-1) score ="Advantage player2";
//            else if (minusResult>=2) score = "Win for player1";
//            else score ="Win for player2";
//        }
//        else
//        {
//            for (int i=1; i<3; i++)
//            {
//                if (i==1) tempScore = scorePlayer1;
//                else { score+="-"; tempScore = scorePlayer2;}
//                switch(tempScore)
//                {
//                    case 0:
//                        score+="Love";
//                        break;
//                    case 1:
//                        score+="Fifteen";
//                        break;
//                    case 2:
//                        score+="Thirty";
//                        break;
//                    case 3:
//                        score+="Forty";
//                        break;
//                }
//            }
//        }
//        return score;
    }
}
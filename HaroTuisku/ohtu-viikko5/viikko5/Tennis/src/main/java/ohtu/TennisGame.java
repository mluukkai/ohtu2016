package ohtu;

public class TennisGame {
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerOne;
    private String playerTwo;

    public TennisGame(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void wonPoint(String player) {
        if (player.equals(playerOne)) {
            playerOneScore += 1;
        } else {
            playerTwoScore += 1;
        }
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (playerOneScore == playerTwoScore) {
            return printScoreWhenEven();
        } else if (playerOneScore >= 4 || playerTwoScore >= 4) {
            return printScoreWhenAdvantageOrWin();
        } else {
            return printPlayerScoreValueAsString(playerOneScore)
                    + "-"
                    + printPlayerScoreValueAsString(playerTwoScore);
        }
    }

    private String printPlayerScoreValueAsString(int playerScore) {
        String score = "";
        switch (playerScore) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
        return score;
    }

    private String printScoreWhenEven() {
        String score = "";
        if (playerOneScore > 3) {
            return "Deuce";
        }
        return printPlayerScoreValueAsString(playerOneScore) + "-All";
    }

    private String printScoreWhenAdvantageOrWin() {
        String score = "";
        int minusResult = playerOneScore - playerTwoScore;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }
}
package ohtu;

public class TennisGame {
    
    private int p1_score = 0;
    private int p2_score = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            p1_score += 1;
        else
            p2_score += 1;
    }

    public String getScore() {
        if (p1_score==p2_score)
        {
            return tie();
        }
        else if (p1_score>=4 || p2_score>=4)
        {
            return advantage();
        }
        else
        {
            return score();
        }
    }

    private String score() {
        return scoreName(p1_score) + "-" + scoreName(p2_score);
    }

    private String advantage() {
        int difference = p1_score-p2_score;
        if (difference==1) return "Advantage player1";
        else if (difference ==-1) return "Advantage player2";
        else if (difference>=2) return "Win for player1";
        else return "Win for player2";
    }

    private String tie() {
        if(p1_score == 4) {
            return "Deuce";
        } else {
            return scoreName(p1_score) + "-" + "All";
        }
    }
    
    private String scoreName(int score){
        switch (score)
        {
            default:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty"; 
        }
    }
}
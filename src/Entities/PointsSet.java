public class PointsSet {


    //region variables
    private String score;

    //endregion

    //region contructeur

    PointsSet(String pScore) {
        this.score = pScore;
    }

    //endregion

    //region getter

    public String getScore() {
        return score;
    }

    //endregion

    //region methodes

    public void AugmentePoints(){
        int scoreInt = Integer.parseInt(score);
        scoreInt++;
        this.score = Integer.toString(scoreInt);
    }


    //endregion
}

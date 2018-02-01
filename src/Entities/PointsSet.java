/**
 * Permet de calculer les points d'un set (1-2-3-4-5-6-7)
 * @Author : Adeline Dumas - 14/12/2017 - Création
 */
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

    /***
     * Augmente les points du joueur
     */
    public void AugmentePoints(){
        int scoreInt = Integer.parseInt(score);
        scoreInt++;
        this.score = Integer.toString(scoreInt);
    }


    //endregion
}

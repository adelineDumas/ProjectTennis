/***
 * Permet de calculer les points d'un jeu (15-30-40)
 * @Author Adeline Dumas - 14/12/2017 - Création
 */

public class PointsJeu {

    //region variables
    private String score;

    //endregion

    //region contructeur

    PointsJeu(String pScore) {
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
     * Ajoute les points au joueur
     */
    public void AugmentePoints(){
        switch (score){
            case "0" : this.score = "15"; break ;
            case "15" : this.score = "30"; break ;
            case "30" : this.score = "40"; break ;
            case "40" : this.score = "A"; break ;
            case "A" : this.score = "Gagné"; break ;
        }
    }

    /***
     * Diminue les points du joueur
     */
    public void DiminuePoint(){
        switch (score){
            case "A": this.score = "40"; break;
        }
    }

    //endregion
}

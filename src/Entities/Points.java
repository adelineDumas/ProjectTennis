/***
 * Permet de calculer les points d'un jeu
 * @Author Adeline Dumas - 14/12/2017 - Création
 */

public enum Points {

    //region variables

    ZERO("0"), QUINZE("15"), TRENTE ("30"), QUARANTE("40"), AVANTAGE("A");

    private String score;

    //endregion

    //region contructeur

    Points(String score) {
        this.score = score;
    }

    //endregion

    //region getter

    public String getScore() {
        return score;
    }

    //endregion
}

/***
 * Sert à déterminer combien de sets gagnants il faut avoir
 * @Author Adeline Dumas - 14/12/2017 - Création
 */

public enum MatchType {

    //region variables

    BEST_OF_THREE(2), BEST_OF_FIVE(3);

    private final int numberOfSetsToWin;

    //endregion

    //region constructeur

    MatchType(int numberOfSetsToWin) {
        this.numberOfSetsToWin = numberOfSetsToWin;
    }


    //endegion

    //region methodes

    public int numberOfSetsToWin() {
        return numberOfSetsToWin;
    }

    public int maxNumberOfSets(){
        return numberOfSetsToWin*2 - 1;
    }

    //endregion

}

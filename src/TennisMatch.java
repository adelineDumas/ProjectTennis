import Entities.Player;

/***
 * Classe permettant de gérer l'évolution du score d'un match de tennis en fonction du joueur qui marque un point
 * @Author Adeline Dumas - 14/12/2017
 */

public class TennisMatch {

    //region enum

    public enum MatchType {
        BEST_OF_THREE(2), BEST_OF_FIVE(3);
        private final int numberOfSetsToWin;
        private MatchType(int numberOfSetsToWin) {
            this.numberOfSetsToWin = numberOfSetsToWin;
        }
        public int numberOfSetsToWin() {
            return numberOfSetsToWin;
        }
        public int maxNumberOfSets(){
            return numberOfSetsToWin*2 - 1;
        }
    }

    //endregion

    public TennisMatch(Player player1, Player player2, MatchType matchType, boolean tieBreakInLastSet){

    }

    public void updateWithPointWonBy(Player player){

    }

    public String pointsForPlayer(Player player){
        return null;
    }

    public int currentSetNumber(){
        return 0;
    }

    public int gamesInCurrentSetForPlayer(Player player){
        return 0;
    }

    public int gamesInSetForPlayer(int setNumber, Player player){
        return 0;
    }

    public boolean isFinished(){
        return false;
    }
}
